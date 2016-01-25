import java.util.ArrayList;
import java.util.List;

public class Polyline{
	private List<Point> points = new ArrayList<Point> ();

	public Polyline(){

	}

	public void appendPoint(int x, int y){
		Point newPoint = new Point(x,y);
		points.add(newPoint);
	}

	public void appendPoint(Point point){
		points.add(point);
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (Point aPoint : points){
			sb.append(aPoint.toString());
		}
		return sb.toString();
	}

}