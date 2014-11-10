// ****************************************************************
// Square.java
//
// Define a Square class with methods to create and read in
// info for a square matrix and to compute the sum of a row,
// a col, either diagonal, and whether it is magic.
//          
// ****************************************************************
import java.io.*;
import java.util.Scanner;

public class Square
{
    int[][] square;
    //--------------------------------------
    //create new square from a data file
    //--------------------------------------
    public Square(String filename) throws IOException
    {
        square = readSquare(filename);
    }

    //-----------------------------------
    //return size of the square
    //-----------------------------------
    public int size()
    {
        return square.length;
    }
    //--------------------------------------
    //return the sum of the values in the given row
    //--------------------------------------
    public int sumRow(int row)
    {
        int sum = 0;
        for (int col = 0; col < square.length; col++)
        {
            sum += square[row][col];
        }
        return sum;
    }

    //--------------------------------------
    //return the sum of the values in the given column
    //--------------------------------------
    public int sumCol(int col)
    {
        int sum = 0;
        for (int row = 0; row < square.length; row++)
        {
            sum += square[row][col];
        }
        return sum;
    }

    //--------------------------------------
    //return the sum of the values in the main diagonal
    //--------------------------------------
    public int sumMainDiag()
    {
        int sum = 0;
        for (int row = 0, col = 0; row < square.length; row++, col++)
        {
            sum += square[row][col];
        }
        return sum;
    }

    //--------------------------------------
    //return the sum of the values in the other ("reverse") diagonal
    //--------------------------------------
    public int sumOtherDiag()
    {
        int sum = 0;
        for (int row = 0, col = square.length; row < square.length; row++, col--)
        {
            sum += square[row][col];
        }
        return sum;
    }

    //--------------------------------------
    //return true if the square is magic (all rows, cols, and diags have
    //same sum), false otherwise
    //--------------------------------------
    public boolean magic()
    {
        return false;
    }

    //--------------------------------------
    //read info into the square from a file
    //--------------------------------------
    public int[][] readSquare(String fileName) throws IOException
    {
        Scanner scan = new Scanner (new File(fileName));
        int size = scan.nextInt();
        int [][] readSquare = new int[size][size];
        for (int row = 0; row < readSquare.length; row++)
            for (int col = 0; col < readSquare.length; col ++)
                readSquare[row][col] = scan.nextInt();
        return readSquare;
    }

    //--------------------------------------
    //print the contents of the square, neatly formatted
    //--------------------------------------
    public void printSquare()
    {

    }

}