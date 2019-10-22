import java.io.PrintStream;
import java.util.Scanner;

public class CreditCalculator extends Bank {
//    private final Scanner scanner;
//    private final PrintStream out;

    public static void main(String[] args) {

        Bid bid = new Bid(65,Genders.M,MoneySources.BUSINESS,5.2,0,4,7,CreditTargets.MORTGAGE);
        double yearlyPayment = getYearlyCreditPayment(bid);

        System.out.println(getAnswerValue(yearlyPayment));
        System.out.println(yearlyPayment);
    }
}
