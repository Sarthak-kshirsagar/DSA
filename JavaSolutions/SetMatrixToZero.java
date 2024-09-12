package JavaSolutions;

import java.util.*;

class SetMatrixToZero {
    public static void main(String[] args) {
        System.out.println("=== SDE SHEET 1 -> Set Matrix to Zero===");
        int[][] inputMatrix = inputMatrix();
        System.out.println("==Input matrix==");
        printMat(inputMatrix);
        int result[][] = setMatrixZero(inputMatrix);
        System.out.println("==Printing the resultant Matrix==");
        printMat(result);

    }

    static void printMat(int[][] res) {
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }

    static int[][] inputMatrix() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int rows = sc.nextInt();
        System.out.println("Enter the number of columns");
        int col = sc.nextInt();
        int[][] inputMat = new int[rows][col];
        for (int i = 0; i < rows; i++) {
            System.out.println("Enter the elements for row " + i);
            for (int j = 0; j < col; j++) {
                int n = sc.nextInt();
                inputMat[i][j] = n;
            }
        }
        sc.close();

        return inputMat;
    }

    static int[][] setMatrixZero(int[][] mat) {
        // to keep the track of first element
        int col1 = 0;
        if (mat[0][0] == 0) {
            col1 = 1;
        }
        /*
         * keeping the track o zeros in first row and first col
         */
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    mat[0][j] = 0;
                    mat[i][0] = 0;
                }
            }
        }

        /*
         * traversing through the mat from 1,1 and marking the elements as 0s
         */

        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                if (mat[0][j] == 0 || mat[i][0] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        // first row trabersal from backside
        for (int i = mat[0].length - 1; i >= 1; i--) {
            if (mat[0][0] == 0 || mat[0][i] == 0) {
                mat[0][i] = 0;
            }
        }
        // first column traversal
        for (int i = 0; i < mat.length; i++) {
            if (col1 == 1) {
                mat[i][0] = 0;
            }
        }
        return mat;
    }
}
