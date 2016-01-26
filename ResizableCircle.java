public class ResizableCircle extends Circle implements Resizable{

  public ResizeableCircle(double radius){
    super(radius);
  }
  
  public double resize(int percent){
    return (percent * 0.01 * getRadius());
  }
}
