class Bank {
    static double getYearlyCreditPayment(Bid bid){
        double sum=0;
        double multiplier=0;

        if(arePrimaryRequirementsMet(bid)){
            multiplier =    getTargetsMultiplier(bid.target)+
                            getRatingMultiplier(bid.creditRating)+
                            getMoneySourcesMultiplier(bid.moneySources)+
                            getRequestMoneyMultiplier(bid.requestedMoney);
            sum = calculateYearlyCreditPayment(bid.requestedMoney,bid.paymentTime,multiplier);
            int limit = howMuchMoneyCanClientTake(bid.moneySources,bid.creditRating);
            if(sum>bid.lastYearIncome/2){
                System.out.println("Годовой платёж в размере "+sum+" превышает половину годового дохода. Кредит нельзя оформить");
                sum = 0;
            } else if(bid.requestedMoney>limit){
                System.out.println("Запрашиваемая сумма "+bid.requestedMoney+" превышает допустимую: "+limit+". Кредит нельзя оформить");
                sum = 0;
            }
        };
        return sum;
    }
    private static boolean arePrimaryRequirementsMet(Bid bid){
        boolean result = true;
        if(!bid.adulthood || bid.retirement){
            result = false;
            System.out.println("Кредит нельзя оформить, будучи несовершеннолетним или достигшим пенсионного возраста");
        } else if(bid.creditRating==-2 || bid.moneySources==MoneySources.JOBLESS){
            result = false;
            System.out.println("Кредит нельзя оформить, имея низкий кредитный рейтинг или будучи безработным");
        } else if(bid.requestedMoney/bid.paymentTime > bid.lastYearIncome/3) {
            result = false;
            System.out.println("Запрашиваемые условия не соответствуют доходу клиента, кредит оформить нельзя");
        }
        return result;
    }
    private static double calculateYearlyCreditPayment(double creditMoney,int paymentTime, double multiplier){
        return (creditMoney * (1 + paymentTime * (10 + multiplier)/100)) / paymentTime;
    }
    private static int howMuchMoneyCanClientTake(MoneySources moneySources,int creditRating){
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
    private static double getTargetsMultiplier(CreditTargets target){
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
    private static double getRatingMultiplier(int raiting) {
        double multiplier = 0;
        switch (raiting) {
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
    private static double getMoneySourcesMultiplier(MoneySources moneySources) {
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
    private static double getRequestMoneyMultiplier(double requestedMoney) {
        return -Math.log(requestedMoney);
    }
    static String getAnswerValue(double val){
        String str = "Кредит не выдаётся";
        if (val>0){
            str = "Кредит выдаётся";
        }
        return str;
    };
}
