import java.util.*;

/**
 * abstract Shape Class which contains 
 * nessasary operations related to Shapes
 * Utility.
 * 2 abstract method
 * 2 static method
 */

abstract class Shape{
    static String name;

    abstract public void printShapeDetail();

    abstract public void takeShapeDetail(Scanner sc);

    // Used To Select Shape from Menu
    public static void chooseShapes(Scanner sc){
        name=sc.nextLine().trim();
        System.out.println("You Chossed Shape : "+name);
    }

    // Providing Shape Objects
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
            else if(name.equalsIgnoreCase("Square")){
              obj=new Square();
           }
            else if(name.equalsIgnoreCase("Sphere")){
              obj=new Sphere();
           }
            else if(name.equalsIgnoreCase("Cylinder")){
              obj=new Cylinder();
           } 
           else{
               obj=null;
           }
        return obj;
    } 
}


/**
 * Traingle class 
 * which extends Shape class 
 * and Overiding abstract methods
 * and printing ShapeDetail
 */
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
       int area=(base*height)/2;
       System.out.println("        Area of Traingle :"+area);
   }

}

/**
 * Circle class 
 * which extends Shape class 
 * and Overiding abstract methods
 * and printingShapeDetail
 */

class Circle extends Shape{
    private int radius;

    @Override
    public void takeShapeDetail(Scanner sc){
       System.out.println("Enter the Radius-: ");
       this.radius=sc.nextInt();sc.nextLine();
    } 

    @Override
    public void printShapeDetail(){
         pAreaCircle();
         pCircumferenceCircle();
    } 

    public void pAreaCircle(){
      int area=(int)(Math.PI*this.radius*this.radius);
      System.out.println("        Area of Circle :"+area);
    }

    public void pCircumferenceCircle(){
       int Circumference=(int)(2*Math.PI*this.radius);
       System.out.println("        Area of Circumference :"+Circumference);
    }  
}

/**
 * Rectangle class 
 * which extends Shape class 
 * and Overiding abstract method
 * and printing ShapeDetail
 */
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
      pPerimeterRectangle();
    } 

    public void pAreaRectangle(){
        int area=length*breadth;
        System.out.println("        Area of rectangle is:"+area);
    }

    public void pPerimeterRectangle(){
        int perimeter=2*(length+breadth);
        System.out.println("        Perimeter of rectangle is:"+perimeter);
    }

}

/**
 * Square class 
 * which extends Shape class 
 * and Overiding abstract method
 * and printing ShapeDetail
 */
class Square extends Shape{
    private int side;

    @Override
    public void takeShapeDetail(Scanner sc){
        System.out.println("Enter the side of Square:");
        this.side=sc.nextInt();sc.nextLine();
    }

    @Override
    public void printShapeDetail(){
      pAreaSquare();
      pPerimeterSquare();
    } 

    public void pAreaSquare(){
       int area=side*side;
       System.out.println("        Area of square is:"+area);
    }

    public void pPerimeterSquare(){
       int perimeter=4*(side);
       System.out.println("        Perimeter of square is:"+perimeter);
    }
}

/**
 * Sphere class 
 * which extends Shape class 
 * and Overiding abstract method
 * and printing ShapeDetail
 */
class Sphere extends Shape{
    private int radius;

    @Override
    public void takeShapeDetail(Scanner sc){
        System.out.println("Enter the radius of Sphere:");
        this.radius=sc.nextInt();sc.nextLine();
    }

    @Override
    public void printShapeDetail(){
      pAreaSphere();
      pVolumeSphere();
    } 
    
    public void pAreaSphere(){
        int surfaceArea=(int)(4*Math.PI*radius*radius);
        System.out.println("        Surface-Area of sphere is: "+surfaceArea);
    }

    public void pVolumeSphere(){
        int volume=(int)((4/3)*Math.PI*Math.pow(radius,3));
        System.out.println("        Volume of sphere is: "+volume);
    }
}

/**
 * Cylinder class 
 * which extends Shape class 
 * and Overiding abstract method
 * and printing ShapeDetail
 */
class Cylinder extends Shape{
    private int radius;
    private int height;

    @Override
    public void takeShapeDetail(Scanner sc){
        System.out.println("Enter the radius of Cylinder:");
        this.radius=sc.nextInt();
        System.out.println("Enter the height of Cylinder:");
        this.height=sc.nextInt();sc.nextLine();
    }

    @Override
    public void printShapeDetail(){
      pAreaCylinder();
      pVolumeCylinder();
    } 

    public void pAreaCylinder() {
        int surfaceArea=(int)((2*Math.PI*radius)*(height+radius));
        System.out.println("        Surface-Area of Cylinder is: "+surfaceArea);
    }

    public void pVolumeCylinder() {
        int volume=(int)(Math.PI*radius*radius*height);
        System.out.println("        Volume of Cylinder is: "+volume);
    }

}

/**
 * ShapesDetailMenu
 * class Which interacts with the User and shows Menu of Shapes
 * and uses Shape Class for chossing and interacting 
 * with diffrent shape class
 */

public class ShapesDetailMenu{

    void  showShapeMenu(){
        System.out.println("Chosse Shape Whose info You Want............");
        System.out.println("1) Circle");
        System.out.println("2) Rectangle");
        System.out.println("3) Triangle");
        System.out.println("4) Square");
        System.out.println("5) Sphere");
        System.out.println("6) Cylinder");

     }

     void greetingMessage(){
         System.out.println("Thankyu for Comming............");
     }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ShapesDetailMenu startApp=new ShapesDetailMenu();
        do{
            startApp.showShapeMenu();
            try {
                // Shape choosen by user here
                Shape.chooseShapes(sc);

                // Taking instance of Shape according to user choice
                Shape eShape= Shape.provideShape();

                // taking parameter for Selected Shape
                eShape.takeShapeDetail(sc);

                // Printing Shape Related operation done on them. 
                eShape.printShapeDetail();

            } catch (NumberFormatException | NullPointerException e) {
                 System.out.println("Entered Value is Wrong");
            }
            System.out.println("\nDo you Want to Continue YES/NO............");
             
        }while(! sc.nextLine().trim().equalsIgnoreCase("No"));

        startApp.greetingMessage();
    }
}

