import java.text.DecimalFormat;

public class CreditCalculator extends Bank {

    public static void main(String[] args) {

        int age = Integer.parseInt(args[0]);
        Genders gender = Genders.valueOf(args[1]);
        MoneySources moneySources = MoneySources.valueOf(args[2]);
        double lastYearIncome = Double.parseDouble(args[3]);
        int creditRating = Integer.parseInt(args[4]);
        double requestedMoney = Double.parseDouble(args[5]);
        int paymentTime = Integer.parseInt(args[6]);
        CreditTargets target = CreditTargets.valueOf(args[7]);

        Bid bid = new Bid(age,gender,moneySources,lastYearIncome,creditRating,requestedMoney,paymentTime,target);

        double yearlyPayment = getYearlyCreditPayment(bid);

        DecimalFormat df = new DecimalFormat("##.###");
        System.out.println(getAnswerValue(yearlyPayment)+"; \nГодовой платёж: "+df.format(yearlyPayment)+" млн/год");
    }
}
