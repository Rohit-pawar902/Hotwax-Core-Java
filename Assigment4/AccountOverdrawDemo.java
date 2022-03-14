import java.util.*;

class AccountOverdrawDemo {
    public static void main(String[] args) {
        Account jointAccount=new Account("BoB",1000);
        // Thread by using Runnable interface and lambda expression
        Thread accountHolder1=new Thread(()->{
             jointAccount.unsafeWithdraw(200);
             jointAccount.unsafeWithdraw(100);
             jointAccount.unsafeWithdraw(50);

        },"Ram");
        Thread accountHolder2=new Thread(()->{
             jointAccount.unsafeWithdraw(300);
             jointAccount.unsafeWithdraw(700);
             jointAccount.unsafeWithdraw(500);
             jointAccount.unsafeWithdraw(5);

        },"Shyam");
       
        accountHolder1.start();
        accountHolder2.start();

    }
}