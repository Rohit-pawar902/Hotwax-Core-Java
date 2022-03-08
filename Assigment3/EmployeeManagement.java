import java.io.*;
import java.util.*;

class EmployeeManagement{
    private HashMap<Integer,Employee> EmpList;
    
    EmployeeManagement(){
        getAllEmployeeData();
        showAllEmployee();
    }

    /**Feaching all data from file and Storing in a EmpList DS */
    public void getAllEmployeeData(){
        this.EmpList=new HashMap<>();
        try {
            File location=new File("./emp.csv");
            FileReader fr=new FileReader(location);
            BufferedReader empFile=new BufferedReader(fr);
            String empData=empFile.readLine();
             
            while(empData!=null){
                Employee tempEmp=getEmployeeByString(empData);
                EmpList.put(tempEmp.getUid() , tempEmp);
                empData=empFile.readLine();
            }

        } catch (Exception e) {
             e.printStackTrace();
        }
        
    }

    /**Just converting String data into an Employee object */
    private Employee getEmployeeByString(String tEmployee){
        String empField[]=tEmployee.split(",");
        int id=Integer.parseInt(empField[0]);
        int age=Integer.parseInt(empField[3]);
        Employee newEmp=new Employee(id,empField[1],empField[2],age,empField[4]);
        return newEmp;
    }
    
    /**Showing all Employee detail stored in CSV file */
    public void showAllEmployee(){
        System.out.println("All Employee Detail are showed here.....\n");
        for(Employee temp:EmpList.values()){
            System.out.println(temp);
        }
    }
    
    public void showMenu(){
        System.out.println("Choose/Enter Operation id to perform.....");
        System.out.println("1).Add an Employee");
        System.out.println("2).Delete an Employee");
        System.out.println("3).Search an Employee");
        System.out.println("4).Update an Employee by its ID");
        System.out.println("5).exit");
    }

    public static void main(String[] args)throws Exception {
        EmployeeManagement employeeManager=new EmployeeManagement();
    }

}

