public class TestResizableCircle.java{

  public static void main(String [] args){
  
    Circle x = new Circle(1.0);
    double radius = x.getRadius();
    System.out.println("The original radius is: " + radius);
    double newRadius = x.resize(50);
    System.out.println("The new radius is: " + newRadius);
  }
}
