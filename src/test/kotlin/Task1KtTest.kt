import org.junit.Test

import org.junit.Assert.*

class Task1KtTest {

    @Test
    fun transferVkPay() {
        val result = transfer("VK Pay", 5000, 8590)
        assertEquals("0", result)
    }

    @Test
    fun transferVkPayUpLimitDay() {
        val result = transfer("VK Pay", 5000, 15001)
        assertEquals("Превышен дневной лимит переводов", result)
    }


    @Test
    fun transferVkPayUpLimitMonth() {
        val result = transfer("VK Pay", 45000, 1500)
        assertEquals("Превышен лимит переводов в месяц", result)
    }

    @Test
    fun transferVkPayUpLimitAll() {
        val result = transfer("VK Pay", 45000, 15001)
        assertEquals("Превышен дневной лимит переводов и в месяц", result)
    }

    @Test
    fun transferMasterCardUpLimitMonth() {
        val result = transfer("MasterCard", 75001, 51000)
        assertEquals("326.0", result)
    }

    @Test
    fun transferMasterCardDownLimitMonth() {
        val result = transfer("MasterCard", 7400, 51000)
        assertEquals("0", result)
    }

    @Test
    fun transferMasterCardUpLimitDay() {
        val result = transfer("MasterCard", 5000, 215001)
        assertEquals("Превышен дневной лимит переводов", result)
    }

    @Test
    fun transferMasterCardUpLimitMonth1() {
        val result = transfer("MasterCard", 645000, 1500)
        assertEquals("Превышен лимит переводов в месяц", result)
    }

    @Test
    fun transferMasterCardUpLimitAll() {
        val result = transfer("MasterCard", 645000, 251500)
        assertEquals("Превышен дневной лимит переводов и в месяц", result)
    }

    @Test
    fun transferMaestroUpLimitMonth() {
        val result = transfer("Maestro", 75001, 51000)
        assertEquals("326.0", result)
    }

    @Test
    fun transferMaestroDownLimitMonth() {
        val result = transfer("Maestro", 7400, 51000)
        assertEquals("0", result)
    }

    @Test
    fun transferMaestroUpLimitAll() {
        val result = transfer("Maestro", 645000, 251500)
        assertEquals("Превышен дневной лимит переводов и в месяц", result)
    }

    @Test
    fun transferMaestroUpLimitDay() {
        val result = transfer("Maestro", 5000, 215001)
        assertEquals("Превышен дневной лимит переводов", result)
    }

    @Test
    fun transferMaestroUpLimitMonth1() {
        val result = transfer("Maestro", 645000, 1500)
        assertEquals("Превышен лимит переводов в месяц", result)
    }

    @Test
    fun transferVisaUpMinCommission() {
        val result = transfer("Visa", 5000, 10000)
        assertEquals("75.0", result)
    }

    @Test
    fun transferVisaDownMinCommission() {
        val result = transfer("Visa", 500, 510)
        assertEquals("35", result)
    }

    @Test
    fun transferVisaUpLimitAll() {
        val result = transfer("Visa", 645000, 251500)
        assertEquals("Превышен дневной лимит переводов и в месяц", result)
    }

    @Test
    fun transferVisaUpLimitDay() {
        val result = transfer("Visa", 5000, 215001)
        assertEquals("Превышен дневной лимит переводов", result)
    }

    @Test
    fun transferVisaUpLimitMonth1() {
        val result = transfer("Visa", 645000, 1500)
        assertEquals("Превышен лимит переводов в месяц", result)
    }

    @Test
    fun transferMirUpMinCommission() {
        val result = transfer("Mir", 5000, 10000)
        assertEquals("75.0", result)
    }

    @Test
    fun transferMirDownMinCommission() {
        val result = transfer("Mir", 500, 510)
        assertEquals("35", result)
    }

    @Test
    fun transferMirUpLimitAll() {
        val result = transfer("Mir", 645000, 251500)
        assertEquals("Превышен дневной лимит переводов и в месяц", result)
    }

    @Test
    fun transferMirUpLimitDay() {
        val result = transfer("Mir", 5000, 215001)
        assertEquals("Превышен дневной лимит переводов", result)
    }

    @Test
    fun transferMirUpLimitMonth1() {
        val result = transfer("Mir", 645000, 1500)
        assertEquals("Превышен лимит переводов в месяц", result)
    }

    @Test
    fun transferNonPay() {
        val result = transfer("Union Pay", 500, 510)
        assertEquals("Invalid typeCard name", result)
    }

    @Test
    fun calcCommissionNonPay() {
        val result = calcCommission("Union Pay", 500, 510)
        assertEquals("Invalid typeCard name", result)
    }

    @Test
    fun transfer() {
        val result = transfer(sumTransfer = 15000)
        assertEquals("0", result)
    }

}