public class Circle implements GeometricObject{

  private double _radius;
  
  public Circle(){
    _radius = 0.0;
  }
  
  publiv getRadius(){
    return _radius;
  }
  
  public double getPerimeter(){
    return (getRadius() * 2 * Math.PI);
  }
  
}
