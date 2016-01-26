public class Circle implements GeometricObject{

  private double _radius;
  
  //time: O(1)
  //preconditions: r is a double
  //postconditions: _radius is assigned the value of r
  public Circle(double r){
    _radius = r;
  }
  
  //time: O(1)
  //preconditions: _radius is a double
  //postconditions: return double _radius
  public double getRadius(){
    return _radius;
  }
  
  //time: O(1)
  //preconditions: getRadius returns a double 
  //postconditions: returns double
  public double getPerimeter(){
    return (getRadius() * 2.0 * Math.PI);
  }
  
  //time: O(1)
  //preconditions: getRadius returns a double
  //postconditions: returns a double
  public double getArea(){
    return (getRadius() * getRadius() * Math.PI);
  }
  
}
