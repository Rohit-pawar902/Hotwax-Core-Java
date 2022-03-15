import java.util.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.IOException;
import java.io.*;
 

class DeserializationTest{

    public static void main(String[] args) {
        ArrayList<Student> data;
        try {
            FileInputStream connectInputStreamWithFile=new FileInputStream("./StudentList.txt");
            ObjectInputStream getObject=new ObjectInputStream(connectInputStreamWithFile);
            data=(ArrayList<Student>)getObject.readObject();
            System.out.println(data);
        } catch( NotSerializableException n){
           n.printStackTrace();
        }  catch (IOException | ClassNotFoundException e) {
            //TODO: handle exception
            e.printStackTrace();
        }    
          
        System.out.println("Deserialization Done...");
    }
}