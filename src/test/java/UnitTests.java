import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UnitTests extends Bank {

    @Test
    public void howMuchMoneyCanClientTakeTests(){
        assertEquals(1000000, Bank.howMuchMoneyCanClientTake(MoneySources.BUSINESS, -1));
        assertEquals(5000000, Bank.howMuchMoneyCanClientTake(MoneySources.BUSINESS, 0));
        assertEquals(10000000, Bank.howMuchMoneyCanClientTake(MoneySources.BUSINESS, 1));
        assertEquals(1000000, Bank.howMuchMoneyCanClientTake(MoneySources.HIRED, -1));
        assertEquals(5000000, Bank.howMuchMoneyCanClientTake(MoneySources.HIRED, 0));
        assertEquals(5000000, Bank.howMuchMoneyCanClientTake(MoneySources.HIRED, 2));
        assertEquals(1000000, Bank.howMuchMoneyCanClientTake(MoneySources.PASSIVE, -1));
        assertEquals(1000000, Bank.howMuchMoneyCanClientTake(MoneySources.PASSIVE, 0));
        assertEquals(1000000, Bank.howMuchMoneyCanClientTake(MoneySources.PASSIVE, 1));
    }

    @Test
    public void getTargetsMultiplierTests(){
        assertEquals(-0.5, Bank.getTargetsMultiplier(CreditTargets.BUSINESS), 0.0);
        assertEquals(1.5, Bank.getTargetsMultiplier(CreditTargets.CONSUMER), 0.0);
        assertEquals(-2, Bank.getTargetsMultiplier(CreditTargets.MORTGAGE), 0.0);
        assertEquals(0, Bank.getTargetsMultiplier(CreditTargets.AUTO), 0.0);
    }
    @Test
    public void getRatingMultiplierTests(){
        assertEquals(1.5, Bank.getRatingMultiplier(-1), 0.0);
        assertEquals(0, Bank.getRatingMultiplier(0), 0.0);
        assertEquals(-0.25, Bank.getRatingMultiplier(1), 0.0);
        assertEquals(-0.75, Bank.getRatingMultiplier(2), 0.0);
    }
    @Test
    public void getMoneySourcesMultiplierTests(){
        assertEquals(0.5, Bank.getMoneySourcesMultiplier(MoneySources.PASSIVE), 0.0);
        assertEquals(-0.25, Bank.getMoneySourcesMultiplier(MoneySources.HIRED), 0.0);
        assertEquals(0.25, Bank.getMoneySourcesMultiplier(MoneySources.BUSINESS), 0.0);
    }
    @Test
    public void getRequestMoneyMultiplierTests(){
        assertEquals(1.0, Bank.getRequestMoneyMultiplier(0.1), 0.0);
        assertEquals(0, Bank.getRequestMoneyMultiplier(1), 0.0);
        assertEquals(-1, Bank.getRequestMoneyMultiplier(10), 0.0);
    }
}
