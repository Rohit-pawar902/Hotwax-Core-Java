import java.util.*;

abstract class Shape{
    static String name;

    abstract public void printShapeDetail();

    abstract public void takeShapeDetail(Scanner sc);

    public static void chooseShapes(Scanner sc){
        name=sc.nextLine();
        System.out.println("You Chossed Shape"+name);
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

class Traingle extends Shape{
   private int base;
   private int height;

   @Override
   public void takeShapeDetail(Scanner sc){
       System.out.println("Enter the base-:");
       this.base=sc.nextInt();
       System.out.println("Enter the height-:");
       this.height=sc.nextInt();sc.nextLine();
   } 

   @Override
   public void printShapeDetail(){
      pAreaTraingle();
   } 

   public void pAreaTraingle(){
       int area=base*height/2;
       System.out.println(area);
   }

}

class Circle extends Shape{
    private int radius;

    @Override
    public void takeShapeDetail(Scanner sc){
       System.out.println("Enter the Radius-:");
       this.radius=sc.nextInt();sc.nextLine();
    } 

    @Override
    public void printShapeDetail(){
         pAreaCircle();
         pCircumferenceCircle();
    } 

    public void pAreaCircle(){
      int area=(int)(Math.PI*this.radius*this.radius);
      System.out.println("Area of Circle :"+area);
    }
    public void pCircumferenceCircle(){
       int Circumference=(int)(2*Math.PI*this.radius);
       System.out.println("Area of Circumference :"+Circumference);
    }  
}

class Rectangle extends Shape{
    private int length;
    private int breadth;
    @Override
    public void takeShapeDetail(Scanner sc){
       System.out.println("Enter the length:");
       this.length=sc.nextInt();
       System.out.println("Enter the breadth:");
       this.breadth=sc.nextInt();sc.nextLine();
    } 

    @Override
    public void printShapeDetail(){
      pAreaRectangle();
    } 

    public void pAreaRectangle(){
        int area=length*breadth;
        System.out.println("Area of rectangle is:"+area);
    }
}

public class ShapesDetailMenu{
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
        // String uResponse="";
        do{
            startApp.showShapeMenu();
            Shape.chooseShapes(sc);
            Shape eShape= Shape.provideShape();
            eShape.takeShapeDetail(sc);
            eShape.printShapeDetail();
            System.out.println("Do you Want to Continue YES/NO............");
             
        }while(! sc.nextLine().equalsIgnoreCase("No"));

        startApp.greetingMessage();
    }
}

