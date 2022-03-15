import java.io.Serializable;

class Student implements Serializable{
    private String firstName;
    private String dateOfBirth;
    private Address address;
    
    Student(String fname,String dateOfBirth,String city,String state,int pinCode,String country){
       this.firstName=fname;
       this.dateOfBirth=dateOfBirth;
       this.address=new Address(city,state,pinCode,country);
    }
    
    @Override
    public String toString() {
        return ""+this.firstName+","+this.dateOfBirth+","+this.address.toString()+",";
    }

}