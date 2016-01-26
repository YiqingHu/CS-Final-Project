public class ResizableCircle extends Circle implements Resizable{

  
  //time: O(1)
  //preconditions: r is a double
  //postconditions: _radius is assigned the value of r
  public ResizableCircle(double radius){
    super(radius);
  }
  //time: O(1)
  //preconditions: getRadius returns a double, percent is an int
  //postconditions: returns double
  public double resize(int percent){
    return (percent * 0.01 * getRadius());
  }
}
