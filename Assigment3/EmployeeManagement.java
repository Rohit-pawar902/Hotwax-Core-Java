import java.io.*;
import java.util.*;

/**
 * EmployeeManagement class
 * empList - stores the all data of employee from emp.csv
 * empFile - BufferedReader instance used to read data from .csv
 * latestIdAllocated - which initially set to last id allocated to employee
 * location - represents file location initialized in constructor
 * saveEmp - used to save data in file .csv
 * changeStatus - it used to detect is there any changes made in data by add/delete/update operation
 */
class EmployeeManagement{
    private HashMap<Integer,Employee> empList;
    private BufferedReader empFile;
    private int latestIdAllocated;
    private File location;
    private BufferedWriter saveEmp;
    private boolean changeStatus; 

    EmployeeManagement(){
        changeStatus=false;
        location=new File("./emp.csv");
        getAllEmployeeData();
        showAllEmployee();
    }

    /**Feaching all data from file and Storing in a empList DS */
    public void getAllEmployeeData(){
        this.empList=new HashMap<>();
        try {
            // connecting with file
            FileReader fr=new FileReader(this.location);
            // class instance
            this.empFile=new BufferedReader(fr);

            // started reading empdata
            String empData=this.empFile.readLine(); 
            while(empData!=null){
                Employee tempEmp=getEmployeeByString(empData);
                empList.put(tempEmp.getUid() , tempEmp);
                this.latestIdAllocated=tempEmp.getUid();
                empData=this.empFile.readLine();
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
        for(Employee temp:empList.values()){
            System.out.println(temp);
        }
    }
    
    /**Showing menu for interaction */
    public void showMenu(){
        System.out.println("Choose/Enter Operation id to perform.....");
        System.out.println("1).Add an Employee");
        System.out.println("2).Delete an Employee");
        System.out.println("3).Search an Employee");
        System.out.println("4).Update an Employee by its ID");
        System.out.println("5).exit");
    }

    /**Add opertion using this method to take input from user*/
    public Employee takeInputEmployeeData(Scanner sc) {
        int id =latestIdAllocated+1;
        System.out.println("Enter the Employee Name :");
        String name=sc.nextLine();
        System.out.println("Enter the Employee Email :");
        String email=sc.nextLine();
        System.out.println("Enter the Employee Age :");
        int age=sc.nextInt();sc.nextLine();
        System.out.println("Enter the Employee Date :");
        String date=sc.nextLine();
        String csvFormate=""+id+","+name+","+email+","+age+","+date+",";
        return getEmployeeByString(csvFormate);
    }

    public void add(Scanner sc) {
        Employee insertedEmp =takeInputEmployeeData(sc);
        // locally storing employee into hashmap
        this.empList.put(insertedEmp.getUid(),insertedEmp);
        
        this.changeStatus=true;
        latestIdAllocated++;
    }

    /**
     * It updates the file emp.csv file when add/delete/update
     * operation apply by user it is detected by changeStatus
     */
    private boolean updateEmployeeFile(){
        // connecting with writer
        try {
            this.saveEmp=new BufferedWriter(new FileWriter(this.location));
            // push all data into the file because some changes is detected
            String data="";
            for(Employee emp:empList.values()){
                String csvFormate=""+emp.getUid()+","+emp.getName()+","+emp.getEmailAddress()+","+emp.getAge()+","+emp.getDob()+",";
                data=data+csvFormate+"\n";
            }
            this.saveEmp.write(data);
            this.saveEmp.flush();
            return true;     
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return false;
    }

    public void delete(){

    }

    public void search() {
        
    }

    public void update() {
        
    }

    public void saveAndFreeAllResourses(){
        // if true then push all data so that changes got persisted into the file
        if(this.changeStatus){
            if(updateEmployeeFile()){
                System.out.println("Changes done...");
            }
            else{
                System.out.println("No Changes...");
            }
        }

        try {
            empFile.close();
            saveEmp.close();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("Thankyu Come Again.....");
        
    }

    public static void main(String[] args)throws Exception {
        Scanner sc=new Scanner(System.in);
        EmployeeManagement employeeManager=new EmployeeManagement();
        while(true){
           employeeManager.showMenu();
           int Choice=sc.nextInt();sc.nextLine();
           switch (Choice) {
               case 1:employeeManager.add(sc);
                    break;
               case 2:employeeManager.delete();
                    break;
               case 3:employeeManager.search();
                    break;
               case 4:employeeManager.update();
                    break;
               case 5:employeeManager.saveAndFreeAllResourses();
                    System.exit(0);
                    break;                                    
               default:System.out.println("You entered Wrong Choice plz enter right choice");
                   continue;
           }
           
        }
    }

}

