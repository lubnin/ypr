import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static jdk.nashorn.internal.objects.NativeString.trim;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class SomeTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams(){
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void test(){
        CreditCalculator.main(new String[]{"65","M","BUSINESS","5.2","0","4","7","MORTGAGE"});
        assertEquals("Кредит выдаётся; \nГодовой платёж: 0,846 млн/год",outContent.toString().trim());
    }
    @After
    public void restoreStreams(){
        System.setOut(originalOut);
    }
}
