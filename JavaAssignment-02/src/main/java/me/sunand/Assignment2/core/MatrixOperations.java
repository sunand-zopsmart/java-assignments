package me.sunand.assignment2.core;

import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// Scanner object for taking input
        int r1, c1;//Rows and columns for matrix A
        System.out.println("Enter the details of Matrix A");
        System.out.print("Enter the number of rows- ");
        r1 = sc.nextInt();
        System.out.print("Enter the number of columns- ");
        c1 = sc.nextInt();
        System.out.println("Enter the elements of Matrix A");
        int[][] A = input(r1, c1);
        int r2, c2;//Rows and columns for matrix B
        System.out.println("Enter the details of Matrix B");
        System.out.print("Enter the number of rows- ");
        r2 = sc.nextInt();
        System.out.print("Enter the number of columns- ");
        c2 = sc.nextInt();
        System.out.println("Enter the elements of Matrix B");
        int[][] B = input(r2, c2);

        if ((r1 != r2) || (c1 != c2))
            System.err.println("Matrices not compatible for addition");
        else {
            int[][] resAdd = add(A, B);
        }


        if ((r1 != r2) || (c1 != c2))
            System.err.println("Matrices not compatible for subtraction");
        else {
            int[][] resSub = subtract(A, B);
        }


        if (c1 != r2)
            System.err.println("Matrices not compatible for multiplication");
        int[][] resMult = multiply(A, B);


        System.out.println("Which matrix you want to pass for scalar multiplication: Enter A or B");
        char c = sc.next().charAt(0);
        System.out.println("Enter the scalar");
        int k = sc.nextInt();
        if (c == 'A') {
            int[][] resScalar = new int[r1][c1];
            resScalar = scalar(A, k);
        } else if (c == 'B') {
            int[][] resScalar = new int[r2][c2];
            resScalar = scalar(B, k);
        } else //If the chosen matrix is neither A nor B
            System.out.println("Invalid Matrix");


        System.out.println("Which matrix you want to pass for transpose: Enter A or B");
        c = sc.next().charAt(0);
        if (c == 'A') {
            int[][] resTranspose = new int[c1][r1];
            transpose(A);
        } else if (c == 'B') {
            int[][] resTranspose = new int[c2][r2];
            transpose(B);
        } else //If the chosen matrix is neither A nor B
            System.out.println("Invalid Matrix");
    }

    private static int[][] input(int r, int c) {
        //This function returns 2D matrix
        int[][] M = new int[r][c];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                M[i][j] = sc.nextInt();
        }
        return M;
    }

    private static int[][] add(int[][] A, int[][] B) {
        //This function adds two matrices
        int r1 = A.length;
        int r2 = B.length;
        int c1 = A[0].length;
        int c2 = B[0].length;
        int[][] result = new int[r1][c1];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++)
                result[i][j] = A[i][j] + B[i][j];
        }
        return result;
    }

    private static int[][] subtract(int[][] A, int[][] B) {
        //This function subtracts two matrices
        int r1 = A.length;
        int r2 = B.length;
        int c1 = A[0].length;
        int c2 = B[0].length;
        int[][] result = new int[r1][c1];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++)
                result[i][j] = A[i][j] - B[i][j];

        }
        return result;
    }

    private static int[][] multiply(int[][] A, int[][] B) {
        //This function multiplies two matrices
        int r1 = A.length;
        int r2 = B.length;
        int c1 = A[0].length;
        int c2 = B[0].length;
        int[][] result = new int[r1][c1];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                int sum = 0;
                for (int k = 0; k < c1; k++)
                    sum += A[i][k] * B[k][j];
                result[i][j] = sum;
            }
        }
        return result;
    }

    private static int[][] scalar(int[][] M, int k) {
        //This function performs scalar multiplication
        int r = M.length;
        int c = M[0].length;
        int[][] result = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                result[i][j] = k * M[i][j];
        }
        return result;
    }

    private static int[][] transpose(int[][] M) {
        //This function returns the transpose of the matrix.
        int r = M.length;
        int c = M[0].length;
        int[][] result = new int[c][r];
        for (int j = 0; j < c; j++) {
            for (int i = 0; i < r; i++)
                result[j][i] = M[i][j];
        }
        return result;
    }
}