import java.io.*;
import java.util.*;

class EmployeeManagement{
    private HashMap<Long,Employee> EmpList;
    
    EmployeeManagement(){
        
    }
    
    public void showMenu(){
        System.out.println("Choose/Enter Operation id to perform.....");
        System.out.println("1).Add an Employee");
        System.out.println("2).Delete an Employee");
        System.out.println("3).Search an Employee");
        System.out.println("4).Update an Employee by its ID");
        System.out.println("5).exit");
    }

    public static void main(String[] args) {
        
    }

}

