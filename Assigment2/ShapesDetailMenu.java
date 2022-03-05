abstract class Shape{
    static String name;

    abstract public void printShapeDetail();

    abstract public void takeInputShapes();

    public static void chooseShapes(Scanner sc){
        name=sc.nextLine();
        System.out.print("You Chossed Shape"+name);
    }
   
    public static Shape provideShape(){
        Shape obj;
           if(name.equalsIgnoreCase("Traingle")){
               obj=new Traingle();
           }
           else if(name.equalsIgnoreCase("Circle")){
              obj=new Circle();
           }
           else if(name.equalsIgnoreCase("Rectangle")){
              obj=new Rectangle();
           }
           else{
               obj=null;
           }
        return obj;
    } 
}

class ShapesDetailMenu{
    void  showShapeMenu(){
        System.out.println("Chosse Shape Whose info You Want............");
        System.out.println("1) Circle");
        System.out.println("2) Rectangle");
        System.out.println("3) Triangle");
        System.out.println("4) Square");
        System.out.println("5) Sphere");
        System.out.println("5) Cylinder");

     }

     void greetingMessage(){
         System.out.println("Thankyu for Coming............");
     }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ShapesDetailMenu startApp=new ShapesDetailMenu();
        do{
            startApp.showShapeMenu();
            Shape.chooseShapes(sc);
            Shape eShape= Shape.provideShape();
            eShape.takeInputShapes();
            eShape.printShapeDetail();
            System.out.println("Do you Want to Continue YES/NO............");
            String uResponse=sc.nextLine(); 
        }while(!uResponse.equalsIgnoreCase("No"));

        startApp.greetingMessage();
    }
}

