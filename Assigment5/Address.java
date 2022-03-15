import java.io.Serializable;

class Address implements Serializable{
    private String city;
    private String state;
    private int pinCode;
    private String country;

    Address(String city,String state,int pinCode,String country ){
        this.city=city;
        this.state=state;
        this.pinCode=pinCode;
        this.country=country;
    }

    @Override
    public String toString() {
        return ""+this.city+","+this.state+","+this.pinCode+","+this.country+"";
    }
}