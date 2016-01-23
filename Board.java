import java.util.Random;
public abstract class Board {
  protected int xSize, ySize; //dimensions for the Board
  protected int numMines; //number of mines
  protected int numKnown; //number of revealed cells
  protected int numBlank; //number of unknown cells
  protected boolean[][] mines; //tells where the mines are
  protected int[][] board; //current board state

  //cells
  public static final int Blank = 0;
  public static final int Known = 1;
  public static final int Mine = 2;

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
    int temp = 0;
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
     else maxY = y + 2

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

  public boolean mark(int x, int y) {
    if ((numMines - numKnown) > 0 && board[x][y] == Blank) {
      board[x][y] = Known;
      numKnown++;
      return true;
    }
    else return false;
  }

  public boolean unmark(int x, int y) {
    if (board[x][y] == Known) {
      board[x][y] = Blank;
      numKnown--;
      return true;
    }
    else return false;
  }

  public int getWidth() {
    return xSize;
  }

  public int getHeight() {
    return ySize;
  }

  public int getMines() {
    return numMines;
  }

  public int getKnown() {
    return numKnown;
  }

  public int getBlank() {
    return numBlank;
  }

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
     else maxY = y + 2

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
