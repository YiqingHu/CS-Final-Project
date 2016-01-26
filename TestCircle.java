public class TestCircle{

  public static void main(String [] args){
  
    Circle x = new Circle(1.0);
    System.out.println(x);
    double radius = x.getRadius();
    System.out.println("The radius is: " + radius);
    double perimeter = x.getPerimeter();
    System.out.println("The perimeter is: " + perimeter);
    double area = x.getArea();
    System.out.println("The area is: " + area);
  }
}
