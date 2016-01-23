public class TextBoard extends Board {
  private int colLength, rowLength;
  private String[] colNums, rowNums;
  private String spacer;
  public TextBoard(int xSize, int ySize, int numMines) {
    super(xSize, ySize, numMines);
    colLength = Integer.toString(xSize-1).length();
    rowLength = Integer.toString(ySize-1).length();
    colNums = new String[xSize];
    rowNums = new String[ySize];
    for (int i = 0; i < xSize; i++) {
      StringBuffer col = new StringBuffer(Integer.toString(i));
      while (col.length() < colLength) {
        col.insert(0, ' ');
      }
      colNums[i] = col.toString();
    }
    StringBuffer spaces = new StringBuffer();
    for (int i = 0; i < rowLength + 2; i++) {
      spaces.append(' ');
    }
    spacer = spaces.toString();
    for (int i = 0; i < ySize; i++) {
      StringBuffer row = new StringBuffer(Integer.toString(i));
      while (row.length() <= rowLength) {
        row.insert(0, ' ');
      }
      row.append(' ');
      rowNums[i] = row.toString();
    }
  }
  public void draw() {
    System.out.println();
    for (int i = 0; i < colLength; i++) {
      System.out.print(spacer);
      for (int j = 0; j < xSize; j++) {
        System.out.print(colNums[j].charAt(i));
      }
      System.out.println();
    }
    System.out.println();
    for (int i = 0; i < ySize; i++) {
      System.out.print(rowNums[i]);
      for (int j = 0; j < xSize; j++) {
        switch (board[j][i]) {
          case Blank:
            System.out.print("#");
            break;
          case Known:
            System.out.print("X");
            break;
          case Mine:
            System.out.print("*");
            break;
          case 1:
          case 2:
          case 3:
          case 4:
          case 5:
          case 6:
          case 7:
          case 8:
          case 9:
            System.out.print(board[j][i]);
            break;
          case 0:
            System.out.print(".");
            break;
        }
      }
      System.out.println(rowNums[i]);
    }
    System.out.println();
    for (int i = 0; i < colLength; i++) {
      System.out.print(spacer);
      for (int j = 0; j < xSize; j++) {
        System.out.print(colNums[j].charAt(i));
      }
      System.out.println();
    }
    System.out.println();
    System.out.println("Mines remaining: " + (getMines() - getKnown()));
    System.out.println();
  }
}
