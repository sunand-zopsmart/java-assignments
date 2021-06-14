package me.sunand.assignment2.core;
import java.util.Scanner;
public class MatrixOperations{
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);// Scanner object for taking input
        int r1,c1;//Rows and columns for matrix A
        System.out.println("Enter the details of Matrix A");
        System.out.print("Enter the number of rows- ");
        r1=sc.nextInt();
        System.out.print("Enter the number of columns- ");
        c1=sc.nextInt();
        System.out.println("Enter the elements of Matrix A");
        int[][] A= new int[r1][c1];
        A=input(r1,c1);
        int r2,c2;//Rows and columns for matrix B
        System.out.println("Enter the details of Matrix B");
        System.out.print("Enter the number of rows- ");
        r2=sc.nextInt();
        System.out.print("Enter the number of columns- ");
        c2=sc.nextInt();
        System.out.println("Enter the elements of Matrix B");
        int[][] B= new int[r2][c2];
        B=input(r2,c2);

        add(r1,c1,r2,c2,A,B);

        subtract(r1,c1,r2,c2,A,B);

        multiply(r1,c1,r2,c2,A,B);
        System.out.println("Which matrix you want to pass for scalar multiplication: Enter A or B");
        char c=sc.next().charAt(0);
        if(c=='A')
            scalar(r1,c1,A);
        else if(c=='B')
            scalar(r2,c2,B);
        else //If the chosen matrix is neither A nor B
            System.out.println("Invalid Matrix");
        System.out.println("Which matrix you want to pass for transpose: Enter A or B");
        c=sc.next().charAt(0);
        if(c=='A')
            transpose(r1,c1,A);
        else if(c=='B')
            transpose(r2,c2,B);
        else //If the chosen matrix is neither A nor B
            System.out.println("Invalid Matrix");
    }
    private static int[][] input(int r,int c){
        //This function returns 2D matrix
        int[][] M= new int[r][c];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++)
                M[i][j]=sc.nextInt();
        }
        return M;
    }
    private static void add(int r1,int c1,int r2,int c2,int[][] A,int[][] B){
        //This function adds two matrices
        if((r1!=r2)||(c1!=c2))
            System.err.println("Matrices not compatible for addition");
        else
        {
            System.out.println("Addition Result: ");
            for(int i=0;i<r1;i++){
                for(int j=0;j<c1;j++)
                    System.out.print(A[i][j]+B[i][j]+" ");
                System.out.println();
            }
        }
    }
    private static void subtract(int r1,int c1,int r2,int c2,int[][] A,int[][] B){
        //This function subtracts two matrices
        if((r1!=r2)||(c1!=c2))
            System.err.println("Matrices not compatible for subtraction");
        else
        {
            System.out.println("Subtraction Result: ");
            for(int i=0;i<r1;i++){
                for(int j=0;j<c1;j++)
                    System.out.print(A[i][j]-B[i][j]+" ");
                System.out.println();
            }
        }
    }
    private static void multiply(int r1,int c1,int r2,int c2,int[][] A,int[][] B){
        //This function multiplies two matrices
        if(c1!=r2)
            System.err.println("Matrices not compatible for multiplication");
        else
        {
            System.out.println("Multiplication Result: ");
            for(int i=0;i<r1;i++){
                for(int j=0;j<c2;j++) {
                    int sum=0;
                    for (int k = 0; k < c1; k++)
                        sum+=A[i][k]*B[k][j];
                    System.out.print(sum+" ");
                }
                System.out.println();
            }
        }
    }
    private static void scalar(int r,int c,int[][] M){
        //This function performs scalar multiplication
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the scalar");
        int k=sc.nextInt();
        System.out.println("Scalar multiplication result: ");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++)
                System.out.print(k*M[i][j]+" ");
            System.out.println();
        }
    }
    private static void transpose(int r,int c,int[][] M){
        //This function returns the transpose of the matrix.
        System.out.println("Transpose Result: ");
        for(int j=0;j<c;j++){
            for(int i=0;i<r;i++)
                System.out.print(M[i][j]+" ");
            System.out.println();
        }
    }
}
