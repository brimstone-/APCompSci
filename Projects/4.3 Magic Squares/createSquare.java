import java.util.Scanner;
public class createSquare {
    //--------------------------------------
    //create magic square based on inputted size
    //--------------------------------------
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int size = sc.nextInt();
        System.out.println();
        int [][] square1 = createSquare(size);
        for (int row = 0; row < square1.length; row++) {
            for (int col = 0; col < square1.length; col++) {
                System.out.print(square1[row][col] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] createSquare(int size) {
        int [][] newSquare = new int[size][size];
        int col = 0, row = 0;
        for (int ctr = 1; ctr <= size * size; ctr++) {
            col = ctr % size + 1;

            if (ctr > size - 1 && (ctr - 1) % size == 0) {
                row += 2;
                //col--;
                //col = (col + size) % size;
                //row = (row + size) % size;
            }

            if (row < 0) {
                row = size - 1;
            }

            if (row > size - 1) {
                row = 0;
            }

            if (col > size - 1) {
                col -= size;
            }

            newSquare[row][col] = ctr;
            row--;
        }
        return newSquare;
    }
}
