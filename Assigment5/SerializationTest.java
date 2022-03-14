
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class SerializationTest{
    
    


    public static void main(String[] args) {
        ArrayList<Student> studentList=new ArrayList();
        Student s1=new Student("Ayan bhai","22/11/2000","indore","M.P",452005,"india");
        Student s2=new Student("Furkan bhai","22/11/2000","indore","M.P",452005,"india");
        Student s3=new Student("Abhishek bhai","22/11/2000","indore","M.P",452005,"india");
        Student s4=new Student("Goku bhai","22/11/2000","indore","M.P",452005,"india");
        Student s5=new Student("Doramon bhai","22/11/2000","indore","M.P",452005,"india");
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);

        try {
            File location=new File("./StudentList.txt");
            FileOutputStream connectFile = new FileOutputStream(location);
            ObjectOutputStream  savingList = new ObjectOutputStream(connectFile);
            savingList.writeObject(studentList);
            connectFile.close();
            savingList.close();
             
        } catch (IOException io) {
            //TODO: handle exception
            io.printStackTrace();
            System.out.print("Some Problem Ocuured");
        }
        
        System.out.print("Done....");
    }
}