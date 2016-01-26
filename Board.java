import java.util.Random;
public abstract class Board {
  protected int xSize, ySize; //dimensions for the Board
  protected int numMines; //number of mines
  protected int numKnown; //number of revealed cells
  protected int numBlank; //number of unknown cells
  protected boolean[][] mines; //tells where the mines are
  protected int[][] board; //current board state

  //cells
  public static final int Blank = -1;
  public static final int Known = -2;
  public static final int Mine = -3;

//time: O(N^2)
//preconditions: int xSize, int ySize, int numMines
//postconditions: instance variables are defined; 
//                boolean array mines is created with random mines 
//                int array board is created with blank-value cells
  public Board(int xSize, int ySize, int numMines) {

    //instance variables
    this.xSize = xSize;
    this.ySize = ySize;
    this.numMines = numMines;
    this.numKnown = 0;
    this.numBlank = xSize * ySize;

    mines = new boolean[xSize][ySize];
    board = new int[xSize][ySize];

    // Clear the board
    for (int i = 0; i < xSize; i++) {
      for (int j = 0; j < ySize; j++) {
        mines[i][j] = false;
        board[i][j] = Blank;
      }
    }

    int cells = xSize * ySize; //area
    Random rand = new Random();

    for (int temp = 0; temp < numMines; temp++){  //while there are still mines
      int randX = (int) (Math.random() * xSize);
      int randY = (int) (Math.random() * ySize);

      //if there isn't already a mine there put one there
      if (!mines[randX][randY]) {
        mines[randX][randY] = true;
      }
    }
  }

  public abstract void draw();
  
  //time: O(!)
  //preconditions: int x, y
  //postconditions: cell at (x, y) is revealed
  //reveal cell at (x,y)
  public int reveal(int x, int y) {
    switch (board[x][y]) {
      case Known:
        numKnown--;
      case Blank:
        numBlank--;
      if (mines[x][y]) {
        board[x][y] = Mine;
      }
      else{
        board[x][y] = closeMines(x, y);
      }
      break;
    }
    return board[x][y];
  }
  
  //runtime: O(N^2)
  //preconditions: int x,y
  //postconditions: the 8 cells surrounding the cell at (x, y) are revealed
  //reveal more cells
  public void revealMore(int x, int y) {
    int minX, minY, maxX, maxY;

    //boundaries
     if (x <= 0) minX = 0;
     else minX = x - 1;

     if (y <= 0) minY = 0;
     else minY = y - 1;

     if (x >= xSize - 1) maxX = xSize;
     else maxX = x + 2;

     if (y >= ySize - 1) maxY = ySize;
     else maxY = y + 2;

    //surrounding cells
    for (int i = minX; i < maxX; i++) {
      for (int j = minY; j < maxY; j++) {
        if (!mines[i][j] && board[i][j] == Blank) {
          reveal(i, j);
          if (board[i][j] == 0) {
            //recursive call
            revealMore(i, j);
          }
        }
      }
    }
  }
  
  //time: O(1)
  //precondition: int x,y
  //postcondition: cell at (x, y) is marked
  public boolean mark(int x, int y) {
    if ((numMines - numKnown) > 0 && board[x][y] == Blank) {
      board[x][y] = Known;
      numKnown++;
      return true;
    }
    else return false;
  }

  //time: O(1)
  //precondition: int x,y
  //postcondition: cell at (x, y) is unmarked
  public boolean unmark(int x, int y) {
    if (board[x][y] == Known) {
      board[x][y] = Blank;
      numKnown--;
      return true;
    }
    else return false;
  }
  
  //gets width
  public int getWidth() {
    return xSize;
  }
  
  //gets height
  public int getHeight() {
    return ySize;
  }

  //gets number of mines
  public int getMines() {
    return numMines;
  }
  
  //gets number of known cells 
  public int getKnown() {
    return numKnown;
  }

  //gets number of unknown cells
  public int getBlank() {
    return numBlank;
  }

  //time: O(N^2)
  //preconditions: int x,y
  //postconditions: checks surroudning 8 cells for mines to find # of mines near 
  //                returns the number of mines near
  private int closeMines(int x, int y) {
    int minX, minY, maxX, maxY;
    int result = 0;

      //boundaries
     if (x <= 0) minX = 0;
     else minX = x - 1;

     if (y <= 0) minY = 0;
     else minY = y - 1;

     if (x >= xSize - 1) maxX = xSize;
     else maxX = x + 2;

     if (y >= ySize - 1) maxY = ySize;
     else maxY = y + 2;

    //checking surrounding cells for mines
    for (int i = minX; i < maxX; i++) {
      for (int j = minY; j < maxY; j++) {
        if (mines[i][j]) {
          result++;
        }
      }
    }
    return result;
  }
}
