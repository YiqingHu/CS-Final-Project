import java.util.ArrayList;
import java.util.List;

public class Polyline{
	//instance variable	
 	private List<Point> points = new ArrayList<Point> ();

 	//initial constructor
 	public Polyline(){
 	}

 	//precondition: x and y are integers
 	//postcondition: append item point (x,y) to the list points
 	//O(n)
 	public void appendPoint(int x, int y){
  		Point newPoint = new Point(x,y);
  		points.add(newPoint);
 	}

 	//precondition: point is a point
 	//postcondition: append point to the list points
 	//O(1)
	public void appendPoint(Point point){
  		points.add(point);
 	}

 	//precondition: all items in list points are point
 	//postcondition: return a string with all the points in the list
 	//               points
 	//O(n)
 	public String toString(){
 		StringBuilder sb = new StringBuilder();
 		for (Point aPoint : points){
   			sb.append(aPoint.toString());
  		}
  		return sb.toString();
 	}
}
