import java.io.*;
import java.util.*;

class EmployeeManagement{
    private HashMap<Integer,Employee> EmpList;
    private BufferedReader empFile;
    EmployeeManagement(){
        getAllEmployeeData();
        showAllEmployee();
    }

    /**Feaching all data from file and Storing in a EmpList DS */
    public void getAllEmployeeData(){
        this.EmpList=new HashMap<>();
        try {
            // connecting with file
            File location=new File("./emp.csv");
            FileReader fr=new FileReader(location);
            // class instance
            this.empFile=new BufferedReader(fr);

            // started reading empdata
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

    public void add() {
        
    }

    public void delete(){

    }

    public void search() {
        
    }

    public void update() {
        
    }

    public void closeOrFreeAllResourses(){

    }

    public static void main(String[] args)throws Exception {
        Scanner sc=new Scanner(System.in);
        EmployeeManagement employeeManager=new EmployeeManagement();
        while(true){
           employeeManager.showMenu();
           int Choice=sc.nextInt();
           switch (Choice) {
               case 1:employeeManager.add();
                    break;
               case 2:employeeManager.delete();
                    break;
               case 3:employeeManager.search();
                    break;
               case 4:employeeManager.update();
                    break;
               case 5:employeeManager.closeOrFreeAllResourses();
                    System.exit(0);
                    break;                                    
               default:System.out.println("You entered Wrong Choice plz enter right choice");
                   continue;
           }
           
        }
    }

}

