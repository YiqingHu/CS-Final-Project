import java.io.*;
public class Minesweeper {

  //instance variables
  private Board board;
  private StreamTokenizer tok; // Tokenizer for commands
  private boolean done, quit, win;
  private int lastCell;

  //time: O(1)
  //constructor
  //preconditions: xSize, ySize, and mines are integers.
  //               mines < xSize * ySize
  //postconditions: board of size xSize * ySize is created with (mines) mines hidden
  //                command tokenizer (will read input) is set up
  //                booleans done, win, and quit are set to falae
  public Minesweeper(int xSize, int ySize, int mines) {
    board = new TextBoard(xSize, ySize, mines);
    tok = new StreamTokenizer(new InputStreamReader(System.in));
    done = win = quit = false;
  }

  //time: O(N^2); 
  //preconditions: done, win, quit are false
  //postconditions: done will be true; win may be true
  public void play() throws IOException {
    long startTime = System.currentTimeMillis();
    while (!done) {
      board.draw();
      System.out.print("Command: ");
      System.out.flush();
      tok.nextToken();
      switch (tok.ttype) {
        case StreamTokenizer.TT_WORD:
          doCommand();
          break;
        case StreamTokenizer.TT_EOL:
          continue;
        case StreamTokenizer.TT_EOF:
          done = quit = true;
          break;
        default:
          System.out.println("Unknown command -- try 'help'");
      }
        if (board.getBlank() == board.getMines()) {
          done = win = true;
        }
        else if (lastCell == Board.Mine) {
          done = true;
        }
        System.in.skip(System.in.available());
    }
    long elapsedTime = System.currentTimeMillis() - startTime;
    for (int i = 0; i < board.getWidth(); i++) {
      for (int j = 0; j < board.getHeight(); j++) {
        board.reveal(i, j);
      }
    }
    board.draw();
    if (win) {
      System.out.println("Congratulations, you found all the mines!");
    }
    else if (!quit) {
      System.out.println("Bad luck. You stepped on a mine.");
    }
    System.out.println("Total game time: "+(elapsedTime/1000)+" seconds");
  }
  //time: O(1)
  //preconditions: the board is blank; quit is false
  //postconditions: some tiles have been marked/unmarked or revealed
  //                quit may be true
  private void doCommand() throws IOException {
    int x, y;
    if (tok.sval.equals("reveal")) {
      tok.nextToken();
      x = (int)tok.nval;
      tok.nextToken();
      y = (int)tok.nval;
      lastCell = board.reveal(x, y);
      if (lastCell == 0) {
        board.revealMore(x, y);
      }
    }
    else if (tok.sval.equals("mark")) {
      tok.nextToken();
      x = (int)tok.nval;
      tok.nextToken();
      y = (int)tok.nval;
      board.mark(x, y);
    }
    else if (tok.sval.equals("unmark")) {
      tok.nextToken();
      x = (int)tok.nval;
      tok.nextToken();
      y = (int)tok.nval;
      board.unmark(x, y);
    }
    else if (tok.sval.equals("help")) {
      System.out.println("Possible commands:")
      System.out.println("reveal a b");
      System.out.println("mark a b");
      System.out.println("unmark a b");
      System.out.println("help");
      System.out.println("quit");
    }
    else if (tok.sval.equals("quit")) {
      quit = done = true;
    }
    else {
      System.out.println("Unknown command. Try 'help' for a list of all possible commands.");
    }
  }


  public static void main(String[] args) throws IOException {
    Minesweeper game;
    if (args.length < 3) {
      System.out.println("Usage: java Minesweeper xLength yLength numMines");
      System.exit(0);
    }
    else {
      int xSize = Integer.parseInt(args[0]);
      int ySize = Integer.parseInt(args[1]);
      int mines = Integer.parseInt(args[2]);
      game = new Minesweeper(xSize, ySize, mines);
      game.play();
    }
  }
}
