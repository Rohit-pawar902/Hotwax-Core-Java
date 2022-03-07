class Employee{
    private int uid;
    private String name;
    private String emailAddress;
    private int age;
    private String Dob;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String Dob) {
        this.Dob = Dob;
    }

    public Employee(int uid, String name, String emailAddress, int age, String Dob) {
        this.uid = uid;
        this.name = name;
        this.emailAddress = emailAddress;
        this.age = age;
        this.Dob = Dob;
    }
   
     @Override
    public String toString() {
        return "Employee{" + "uid=" + uid + ", name=" + name + ", emailAddress=" + emailAddress + ", age=" + age + ", Dob=" + Dob + '}';
    }


}