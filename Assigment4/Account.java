class Account{
    private String name;
    private int balance;

    Account(String bankName,int curBalance){
        this.name=bankName;
        this.balance=curBalance;
    }

    public void unsafeWithdraw(int amount){
        String s=Thread.currentThread().getName();
        System.out.println(s +" :came...");
        if(amount>this.balance){
            System.out.println(s +" :You have insufficent balance withdraw not possible"+this.balance);
            return;
        }
        else{
            System.out.println(s +" :You have Sufficient Balance to withdraw"+this.balance);
            System.out.println(s +" :"+amount +" amount is withdraw from your Account");
            this.balance = this.balance - amount;
            if(this.balance<0){
                System.out.println(s +"Incosistent State");
            }
        }
        System.out.println(s +" :Remaining balance" + this.balance);
    }

     synchronized public void safeWithdraw(int amount){
        String s=Thread.currentThread().getName();
        System.out.println(s +" :came...");
        if(amount>this.balance){
            System.out.println(s +" :You have insufficent balance withdraw not possible"+this.balance);
            return;
        }
        else{
            System.out.println(s +" :You have Sufficient Balance to withdraw"+this.balance);
            System.out.println(s +" :"+amount +" amount is withdraw from your Account");
            this.balance = this.balance - amount;
            if(this.balance<0){
                System.out.println(s +"Incosistent State");
            }
        }
        System.out.println(s +" :Remaining balance" + this.balance);
    }
    
}