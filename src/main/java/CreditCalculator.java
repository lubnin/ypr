import java.text.DecimalFormat;

public class CreditCalculator extends Bank {

    public static void main(String[] args) {
        int age;
        Genders gender;
        MoneySources moneySources;
        double lastYearIncome;
        int creditRating;
        double requestedMoney;
        double paymentTime;
        CreditTargets target;

        try {
            age = Integer.parseInt(args[0]);
            gender = Genders.valueOf(args[1]);
            moneySources = MoneySources.valueOf(args[2]);
            lastYearIncome = Double.parseDouble(args[3]);
            creditRating = Integer.parseInt(args[4]);
            requestedMoney = Double.parseDouble(args[5]);
            paymentTime = Double.parseDouble(args[6]);
            target = CreditTargets.valueOf(args[7]);
        } catch (Exception e){
            System.out.println("При получении входных данных возникла ошибка." +
                    "\n Входные параметры должны быть введены через пробел в следующем порядке: " +
                    "\n     -Возраст, полных лет " +
                    "\n     -Пол, F или M " +
                    "\n     -Источник дохода: PASSIVE,HIRED,BUSINESS,JOBLESS " +
                    "\n     -Доход за последний год, млн " +
                    "\n     -Кредитный рейтинг: -2,-1,0,1,2 " +
                    "\n     -Запрошенная сумма, млн " +
                    "\n     -Срок погашения, лет" +
                    "\n     -Цель: MORTGAGE,BUSINESS,AUTO,CONSUMER");
            return;
        }

        Bid bid = new Bid(age,gender,moneySources,lastYearIncome,creditRating,requestedMoney,paymentTime,target);

        double yearlyPayment = getYearlyCreditPayment(bid);

        DecimalFormat df = new DecimalFormat("##.###");
        if (yearlyPayment!=0){
            System.out.println("Кредит выдаётся; \nПлатёж: "+df.format(yearlyPayment)+" млн./год");
        }
    }
}
