import java.util.*;

class AccountOverdrawDemo {
    public static void main(String[] args) {
        Account jointAccount=new Account("BoB",1000);
        // Thread by using Runnable interface and lambda expression
        Thread accountHolder1=new Thread(()->{
             jointAccount.withdraw(200);
             jointAccount.withdraw(100);
             jointAccount.withdraw(50);

        },"Ram");
        Thread accountHolder2=new Thread(()->{
             jointAccount.withdraw(300);
             jointAccount.withdraw(700);
             jointAccount.withdraw(5);

        },"Shyam");
       
        accountHolder1.start();
        accountHolder2.start();

    }
}