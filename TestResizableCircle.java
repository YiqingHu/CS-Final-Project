public class TestResizableCircle{

  public static void main(String [] args){
  
    ResizableCircle x = new ResizableCircle(1.0);
    System.out.println(x);
    double radius = x.getRadius();
    System.out.println("The original radius is: " + radius);
    double newRadius = x.resize(50);
    System.out.println("The new radius is: " + newRadius);
  }
}
