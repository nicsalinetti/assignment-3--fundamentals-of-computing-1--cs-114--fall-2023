import java.util.Scanner;

public class Matrix {

  /*Initialize variables that are needed throughout the program */
  public static int size;
  public static int[][] table;
  public static int row;
  public static int col;
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_RESET = "\u001B[0m";

  /*Request user input and create zero matrix */
  public static void matrix(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Input the size of the matrix: ");
    size = scan.nextInt();
    table = new int[size][size];
    System.out.println("Your Matrix is " + size + " x " + size);
    System.out.println();
    System.out.print("Printing matrix with default values:");
  }

  /*Print current matrix when this method is called */
  public static void printMatrix(){
    for(row = 0; row < size; row++){
      System.out.print('\n');
      for(int col = 0; col < size; col++){

        /*Change color to yellow if the number is on the diagonal of matrix */
        if(row + col == size - 1){
          System.out.print(ANSI_YELLOW);
          System.out.printf("%-6d",table[row][col]);
          System.out.print(ANSI_RESET);
        }

        /*Print current number with proper formatting to keep the columns aligned */
        else{
          System.out.printf("%-6d",table[row][col]);
        }
      }
    }
  }

  /*Fill the matrix with values counting up starting from 1 */
  public static void populateMatrix(){

    System.out.println();
    System.out.println();
    System.out.println("Populating matrix...matrix populated");
    System.out.println();
    System.out.print("Printing matrix:");

    for(row = 0; row < size; row++){
      for(int col = 0; col < size; col++){
        table[row][col] = (size * row) + col + 1;

      }
    }
  }

  /*Swap values in the matrix across the diagonal */
  private static void swap(int x1, int y1, int x2, int y2){
    int temp = table[x1][y1];
    table[x1][y1] = table[x2][y2];
    table[x2][y2] = temp;
  }

  /*Main method that flips the matrix across the diagonal */
  public static void flipMatrix(){
    int length = table.length;

    System.out.println();
    System.out.println();
    System.out.println("Flipping matrix...matrix flipped");
    System.out.println();
    System.out.print("Printing flipped matrix:");

    for(row = 0; row < length; row++){
      for(col = 0; col < length; col++){
        if(row + col < length - 1){
          swap(row, col, length - row - 1, length - col - 1);
        }
        else if(row + col == length){}
      }
    }
  }

}
