import java.util.*;

class AccountOverdrawSafeDemo {
    public static void main(String[] args) {
        Account jointAccount=new Account("BoB",1000);
        // Thread by using Runnable interface and lambda expression
        Thread accountHolder1=new Thread(()->{
             jointAccount.safeWithdraw(200);
             jointAccount.safeWithdraw(100);
             jointAccount.safeWithdraw(50);

        },"Ram");
        Thread accountHolder2=new Thread(()->{
             jointAccount.safeWithdraw(300);
             jointAccount.safeWithdraw(700);
             jointAccount.safeWithdraw(5);

        },"Shyam");
       
        accountHolder1.start();
        accountHolder2.start();

    }
}