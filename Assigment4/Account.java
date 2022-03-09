class Account{
    private String name;
    private int balance;

    Account(String bankName,int curBalance){
        this.name=bankName;
        this.balance=curBalance;
    }

    public void withdraw(int amount){
        if(amount>this.balance){
            System.out.println("insufficent balance withdraw not possible"+this.balance);
            return;
        }
        
        System.out.println(amount +" amount is withdraw from your Account");
        this.balance -= amount;
    }
    
}