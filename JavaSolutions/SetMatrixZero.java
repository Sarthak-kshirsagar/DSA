package JavaSolutions;

public class SetMatrixZero {
    public static void main(String args[]) {
        int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        int[][] result = setMatrixZero(matrix);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.println(matrix[i][j]);
            }
        }

    }

    static void setZeros(int[][] matrix, int i, int j) {
        int temp = i;
        // upwards
        while (i <= 0) {
            matrix[i][j] = 0;
            i--;
        }
        // downwards
        while (temp <= matrix.length - 1) {
            matrix[temp][j] = 0;
            temp++;
        }

        // go left
        int jTemp = j;
        while (j <= 0) {
            matrix[i][j] = 0;
            j--;
        }
        // go right
        while (jTemp <= matrix.length - 1) {
            matrix[i][jTemp] = 0;
        }
    }

    static int[][] setMatrixZero(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    setZeros(matrix, i, j);
                }
            }
        }
        return matrix;
    }
}
