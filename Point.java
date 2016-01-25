public class Point {
	//intance varibles
  	private int _x;
  	private int _y;
  	
  	//constructor
  	//precondition: x and y are integers
  	//postcondition: create a class point with instance variables
  	//               _x, x, and _y, y;
  	//O(0)
 	public Point(int x, int y){
  		_x = x;
  		_y = y;
  	}

  	//precondition: _x and _y are integers
  	//postcondition: when class Point is printed, iot will appear
  	//               as (_x,_y)
  	//O(0)
  	public String toString() {
  		return "(" + _x + "," + _y + ")";
  	}
}
