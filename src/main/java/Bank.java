import java.text.DecimalFormat;

class Bank {
    static double getYearlyCreditPayment(Bid bid){
        DecimalFormat df = new DecimalFormat("##.###");
        double sum=0;

        if(arePrimaryRequirementsMet(bid)){
            double multiplier =    getTargetsMultiplier(bid.target)+
                            getRatingMultiplier(bid.creditRating)+
                            getMoneySourcesMultiplier(bid.moneySources)+
                            getRequestMoneyMultiplier(bid.requestedMoney);
            sum = calculateYearlyCreditPayment(bid.requestedMoney,bid.paymentTime,multiplier);
            int limit = howMuchMoneyCanClientTake(bid.moneySources,bid.creditRating);
            if(sum>bid.lastYearIncome/2){
                System.out.println("Годовой платёж в размере "+df.format(sum)+" превышает половину годового дохода. Кредит нельзя оформить");
                sum = 0;
            } else if(bid.requestedMoney*1000000>limit){
                System.out.println("Запрашиваемая сумма "+bid.requestedMoney+" млн. превышает допустимую: "+limit+". Кредит нельзя оформить");
                sum = 0;
            }
        };
        return sum;
    }
    private static boolean arePrimaryRequirementsMet(Bid bid) {
        boolean result = true;

        if (!bid.adulthood) {
            result = false;
            System.out.println("Кредит нельзя оформить, будучи несовершеннолетним");
        } else if (bid.paymentTime < 1 || bid.paymentTime > 20) {
            result = false;
            System.out.println("Кредит нельзя оформить, срок погашения должен быть от 1 до 20 лет");
        } else if (bid.isPaymentOverlaysOnRetirement()) {
            result = false;
            System.out.println("Кредит нельзя оформить, если до погашения возраст превышает пенсионный");
        } else if (bid.requestedMoney < 0.1) {
            result = false;
            System.out.println("Кредит нельзя оформить, запрашиваемая сумма меньше допустимой");
        } else if (bid.creditRating <= -2 || bid.moneySources == MoneySources.JOBLESS) {
            result = false;
            System.out.println("Кредит нельзя оформить, имея низкий кредитный рейтинг или будучи безработным");
        } else if (bid.requestedMoney / bid.paymentTime >= bid.lastYearIncome / 3) {
            result = false;
            System.out.println("Кредит нельзя оформить, запрашиваемые условия не соответствуют доходу клиента");
        }
            return result;
    }

    private static double calculateYearlyCreditPayment(double creditMoney, double paymentTime, double multiplier){
        return (creditMoney * (1 + paymentTime * (10 + multiplier)/100)) / paymentTime;
    }
    static int howMuchMoneyCanClientTake(MoneySources moneySources, int creditRating){
        int sourcesLimit=0;
        int ratingLimit=0;
        switch (moneySources){
            case PASSIVE:
                sourcesLimit = 1000000;
                break;
            case BUSINESS:
                sourcesLimit = 10000000;
                break;
            case HIRED:
                sourcesLimit = 5000000;
                break;
        }
        switch (creditRating){
            case -1:
                ratingLimit = 1000000;
                break;
            case 0:
                ratingLimit = 5000000;
                break;
            case 1:
            case 2:
                ratingLimit = 10000000;
                break;
        }
        return Math.min(sourcesLimit,ratingLimit);
    }
    static double getTargetsMultiplier(CreditTargets target){
        double multiplier=0;
        switch (target){
            case MORTGAGE:
                multiplier = -2;
                break;
            case BUSINESS:
                multiplier = -0.5;
                break;
            case CONSUMER:
                multiplier = 1.5;
                break;
        }
        return multiplier;
    }
    static double getRatingMultiplier(int rating) {
        double multiplier = 0;
        switch (rating) {
            case -1:
                multiplier = 1.5;
                break;
            case 1:
                multiplier = -0.25;
                break;
            case 2:
                multiplier = -0.75;
                break;
        }
        return multiplier;
    }
    static double getMoneySourcesMultiplier(MoneySources moneySources) {
        double multiplier = 0;
        switch (moneySources) {
            case PASSIVE:
                multiplier = 0.5;
                break;
            case BUSINESS:
                multiplier = 0.25;
                break;
            case HIRED:
                multiplier = -0.25;
                break;
        }
        return multiplier;
    }
    static double getRequestMoneyMultiplier(double requestedMoney) {
        return -Math.log10(requestedMoney);
    }
}
