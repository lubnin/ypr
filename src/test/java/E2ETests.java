import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.AllureJunit4;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import io.qameta.allure.junit4.Tags;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class E2ETests {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams(){
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test 1")
    public void positiveTest01() {
        CreditCalculator.main(new String[]{"45", "M", "BUSINESS", "9", "2", "10", "20", "BUSINESS"});
        assertEquals("Кредит выдаётся; \nПлатёж: 1,3 млн./год", outContent.toString().trim());
    }
    @Test
    @Tag("Positive")
    @DisplayName("Test 2")
    public void positiveTest02() {
        CreditCalculator.main(new String[]{"52", "F", "BUSINESS", "9", "2", "7", "7.7", "AUTO"});
        assertEquals("Кредит выдаётся; \nПлатёж: 1,515 млн./год", outContent.toString().trim());
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test 3")
    public void positiveTest03() {
        CreditCalculator.main(new String[]{"18","F","BUSINESS","9","1","7","20","MORTGAGE"});
        assertEquals("Кредит выдаётся; \nПлатёж: 0,851 млн./год",outContent.toString().trim());
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test 4")
    public void positiveTest04() {
        CreditCalculator.main(new String[]{"45","M","BUSINESS","9","1","0.1","1","CONSUMER"});
        assertEquals("Кредит выдаётся; \nПлатёж: 0,113 млн./год",outContent.toString().trim());
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test 5")
    public void positiveTest05() {
        CreditCalculator.main(new String[]{"18","F","HIRED","12.1","2","4","1","MORTGAGE"});
        assertEquals("Кредит выдаётся; \nПлатёж: 4,256 млн./год",outContent.toString().trim());
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test 6")
    public void positiveTest06() {
        CreditCalculator.main(new String[]{"45","M","HIRED","12.1","1","4","1","AUTO"});
        assertEquals("Кредит выдаётся; \nПлатёж: 4,356 млн./год",outContent.toString().trim());
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test 7")
    public void positiveTest07() {
        CreditCalculator.main(new String[]{"18","F","HIRED","9","0","1","20","AUTO"});
        assertEquals("Кредит выдаётся; \nПлатёж: 0,148 млн./год",outContent.toString().trim());
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test 8")
    public void positiveTest08() {
        CreditCalculator.main(new String[]{"45","M","BUSINESS","9","0","0.1","20","BUSINESS"});
        assertEquals("Кредит выдаётся; \nПлатёж: 0,016 млн./год",outContent.toString().trim());
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test 9")
    public void positiveTest09() {
        CreditCalculator.main(new String[]{"45","M","PASSIVE","9","2","1","1","CONSUMER"});
        assertEquals("Кредит выдаётся; \nПлатёж: 1,113 млн./год",outContent.toString().trim());
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test 10")
    public void positiveTest10() {
        CreditCalculator.main(new String[]{"18","F","PASSIVE","9","2","1","20","AUTO"});
        assertEquals("Кредит выдаётся; \nПлатёж: 0,148 млн./год",outContent.toString().trim());
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test 11")
    public void positiveTest11() {
        CreditCalculator.main(new String[]{"45","M","PASSIVE","9","-1","0.7","7.7","AUTO"});
        assertEquals("Кредит выдаётся; \nПлатёж: 0,176 млн./год",outContent.toString().trim());
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test 12")
    public void positiveTest12() {
        CreditCalculator.main(new String[]{"18","F","PASSIVE","9","1","0.7","1","BUSINESS"});
        assertEquals("Кредит выдаётся; \nПлатёж: 0,769 млн./год",outContent.toString().trim());
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test 13")
    public void positiveTest13() {
        CreditCalculator.main(new String[]{"18","F","PASSIVE","9","0","0.7","1","MORTGAGE"});
        assertEquals("Кредит выдаётся; \nПлатёж: 0,761 млн./год",outContent.toString().trim());
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test 14")
    public void positiveTest14() {
        CreditCalculator.main(new String[]{"18","F","PASSIVE","9","0","0.1","7.7","CONSUMER"});
        assertEquals("Кредит выдаётся; \nПлатёж: 0,026 млн./год",outContent.toString().trim());
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test 15")
    public void positiveTest15() {
        CreditCalculator.main(new String[]{"18","F","HIRED","9","-1","0.7","7.7","CONSUMER"});
        assertEquals("Кредит выдаётся; \nПлатёж: 0,181 млн./год",outContent.toString().trim());
    }
    @Test
    @Tag("Positive")
    @DisplayName("Test 16")
    public void positiveTest16() {
        CreditCalculator.main(new String[]{"45","M","HIRED","9","-1","0.7","7.7","BUSINESS"});
        assertEquals("Кредит выдаётся; \nПлатёж: 0,167 млн./год",outContent.toString().trim());
    }
    @Test
    @Tag("Positive")
    @DisplayName("Test 17")
    public void positiveTest17() {
        CreditCalculator.main(new String[]{"45","M","BUSINESS","9","-1","0.1","7.7","MORTGAGE"});
        assertEquals("Кредит выдаётся; \nПлатёж: 0,024 млн./год",outContent.toString().trim());
    }
    @Test
    @Tag("Negative")
    @DisplayName("Test 01")
    public void negativeTest01() {
        CreditCalculator.main(new String[]{"17","M","BUSINESS","9","2","10","20","BUSINESS"});
        assertEquals("Кредит нельзя оформить, будучи несовершеннолетним",outContent.toString().trim());
    }
    @Test
    @Tag("Negative")
    @DisplayName("Test 02")
    public void negativeTest02() {
        CreditCalculator.main(new String[]{"0","M","BUSINESS","9","2","10","20","BUSINESS"});
        assertEquals("Кредит нельзя оформить, будучи несовершеннолетним",outContent.toString().trim());
    }
    @Test
    @Tag("Negative")
    @DisplayName("Test 03")
    public void negativeTest03() {
        CreditCalculator.main(new String[]{"-1","M","BUSINESS","9","2","10","20","BUSINESS"});
        assertEquals("Кредит нельзя оформить, будучи несовершеннолетним",outContent.toString().trim());
    }
    @Test
    @Tag("Negative")
    @DisplayName("Test 04")
    public void negativeTest04() {
        CreditCalculator.main(new String[]{"105","F","HIRED","9","-1","0.7","7.7","CONSUMER"});
        assertEquals("Кредит нельзя оформить, если до погашения возраст превышает пенсионный",outContent.toString().trim());
    }
    @Test
    @Tag("Negative")
    @DisplayName("Test 05")
    public void negativeTest05() {
        CreditCalculator.main(new String[]{"46","M","BUSINESS","9","2","10","20","BUSINESS"});
        assertEquals("Кредит нельзя оформить, если до погашения возраст превышает пенсионный",outContent.toString().trim());
    }
    @Test
    @Tag("Negative")
    @DisplayName("Test 06")
    public void negativeTest06() {
        CreditCalculator.main(new String[]{"53","F","BUSINESS","9","2","7","7.7","AUTO"});
        assertEquals("Кредит нельзя оформить, если до погашения возраст превышает пенсионный",outContent.toString().trim());
    }
    @Test
    @Tag("Negative")
    @DisplayName("Test 07")
    public void negativeTest07() {
        CreditCalculator.main(new String[]{"45","M","PASSIVE","9","2","1","0","CONSUMER"});
        assertEquals("Кредит нельзя оформить, срок погашения должен быть от 1 до 20 лет",outContent.toString().trim());
    }
    @Test
    @Tag("Negative")
    @DisplayName("Test 08")
    public void negativeTest08() {
        CreditCalculator.main(new String[]{"45","M","PASSIVE","9","2","1","21","CONSUMER"});
        assertEquals("Кредит нельзя оформить, срок погашения должен быть от 1 до 20 лет",outContent.toString().trim());
    }
    @Test
    @Tag("Negative")
    @DisplayName("Test 09")
    public void negativeTest09() {
        CreditCalculator.main(new String[]{"18","F","HIRED","9","-1","1.1","7.7","CONSUMER"});
        assertEquals("Запрашиваемая сумма 1.1 млн. превышает допустимую: 1000000. Кредит нельзя оформить",outContent.toString().trim());
    }
    @Test
    @Tag("Negative")
    @DisplayName("Test 10")
    public void negativeTest10() {
        CreditCalculator.main(new String[]{"45","M","BUSINESS","9","-2","10","20","BUSINESS"});
        assertEquals("Кредит нельзя оформить, имея низкий кредитный рейтинг или будучи безработным",outContent.toString().trim());
    }
    @Test
    @Tag("Negative")
    @DisplayName("Test 11")
    public void negativeTest11() {
        CreditCalculator.main(new String[]{"45","M","JOBLESS","9","2","10","20","BUSINESS"});
        assertEquals("Кредит нельзя оформить, имея низкий кредитный рейтинг или будучи безработным",outContent.toString().trim());
    }
    @Test
    @Tag("Negative")
    @DisplayName("Test 12")
    public void negativeTest12() {
        CreditCalculator.main(new String[]{"45","M","BUSINESS","9","2","10","3.2","BUSINESS"});
        assertEquals("Кредит нельзя оформить, запрашиваемые условия не соответствуют доходу клиента",outContent.toString().trim());
    }
    @Test
    @Tag("Negative")
    @DisplayName("Test 13")
    public void negativeTest13() {
        CreditCalculator.main(new String[]{"45","M","BUSINESS","9","2","0.05","5","BUSINESS"});
        assertEquals("Кредит нельзя оформить, запрашиваемая сумма меньше допустимой",outContent.toString().trim());
    }

    @After
    public void restoreStreams(){
        System.setOut(originalOut);
    }
}
