public class TestPolyline{
 public static void main(String[] args){
  Polyline l1 = new Polyline();
  System.out.println(l1);
  l1.appendPoint(new Point(1,1));
  l1.appendPoint(new Point(2,2));
  l1.appendPoint(new Point(3,3));
  System.out.println(l1);
 }
}