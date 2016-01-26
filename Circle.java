public class Circle implements GeometricObject{

  private double _radius;
  
  public Circle(){
    _radius = 0.0;
  }
  
  public Circle(double r){
    _radius = r;
  }
  
  publiv getRadius(){
    return _radius;
  }
  
  public double getPerimeter(){
    return (getRadius() * 2.0 * Math.PI);
  }
  
  public double getArea(){
    return (getRadius() * getRadius() * Math.PI);
  }
  
}
