class Bid {
    int age;
    Genders gender;
    MoneySources moneySources;
    double lastYearIncome;
    int creditRating;
    double requestedMoney;
    int paymentTime;
    CreditTargets target;
    boolean retirement;
    boolean adulthood;

    Bid(int age,
        Genders gender,
        MoneySources moneySources,
        double lastYearIncome,
        int creditRating,
        double requestedMoney,
        int paymentTime,
        CreditTargets target)
    {
        this.age = age;
        this.gender = gender;
        this.moneySources = moneySources;
        this.lastYearIncome = lastYearIncome;
        this.creditRating = creditRating;
        this.requestedMoney = requestedMoney;
        this.paymentTime = paymentTime;
        this.target = target;

        this.retirement = isRetirement();
        this.adulthood = isAdulthood();
    }

    private boolean isAdulthood(){
        return this.age>=18;
    }
    private boolean isRetirement(){
        return (this.gender==Genders.F && this.age>60 || this.gender==Genders.M && this.age>65);
    }
}
