fun main() {
    println(transfer(sumMonth = 40000, sumTransfer = 15000))
    println(transfer("Maestro", 75001, 51000))
    println(transfer("Visa", 5000, 10000))
    println(transfer("UnionPay", 5000, 10000))
}

fun transfer(typeCard: String = "VK Pay", sumMonth: Int = 0, sumTransfer: Int): String {

    val checkLimit = checkLimitTransfer(typeCard, sumMonth, sumTransfer)

    return when (typeCard) {
        "VK Pay", "MasterCard", "Maestro", "Visa", "Mir" -> if (checkLimit == "OK")
            calcCommission(typeCard, sumMonth, sumTransfer) else checkLimit

        else -> "Invalid typeCard name"
    }
}

fun checkLimitTransfer(typeCard: String, sumMonth: Int, sumTransfer: Int): String {
    val msgErrorDayLimit = "Превышен дневной лимит переводов"
    val msgErrorMonthLimit = "Превышен лимит переводов в месяц"
    val msgErrorAllLimit = "Превышен дневной лимит переводов и в месяц"
    val vkPayLimitDay = 15_000
    val vkPayLimitMonth = 40_000
    val limitDay = 150_000
    val limitMonth = 600_000

    return when (typeCard) {
        "VK Pay" -> when {
            sumTransfer > vkPayLimitDay && sumMonth > vkPayLimitMonth -> msgErrorAllLimit
            sumTransfer > vkPayLimitDay -> msgErrorDayLimit
            sumMonth > vkPayLimitMonth -> msgErrorMonthLimit
            else -> "OK"
        }

        "MasterCard", "Maestro", "Visa", "Mir" -> when {
            sumTransfer > limitDay && sumMonth > limitMonth -> msgErrorAllLimit
            sumTransfer > limitDay -> msgErrorDayLimit
            sumMonth > limitMonth -> msgErrorMonthLimit
            else -> "OK"
        }

        else -> "Invalid typeCard name"
    }
}

fun calcCommission(typeCard: String, sumMonth: Int, sumTransfer: Int): String {
    val masterMaestroMonthLimit = 75_000
    val visaMirMinCommissionRub = 35
    val zeroCommission = 0

    val commissionMasterMaestro = 0.006 * sumTransfer + 20
    val commissionVisaMir = 0.0075 * sumTransfer

    return when (typeCard) {
        "VK Pay" -> "$zeroCommission"
        "MasterCard", "Maestro" ->
            if (sumMonth > masterMaestroMonthLimit) "$commissionMasterMaestro" else "$zeroCommission"

        "Visa", "Mir" ->
            if (commissionVisaMir < visaMirMinCommissionRub) "$visaMirMinCommissionRub" else "$commissionVisaMir"

        else -> "Invalid typeCard name"
    }
}