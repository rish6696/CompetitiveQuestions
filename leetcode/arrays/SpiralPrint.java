import java.util.ArrayList;
import java.util.*;

public class SpiralPrint {
    public static void main(String[] args) {

        // in this ques pattern is 
        // 1 1 2 2 3 3 4 4 5 5.........
        //
        // int[][] matrix={
        // { 1, 2, 3},
        // { 5, 6,7},
        // { 9,10,11},

        // };

        // List<Integer> ans=new ArrayList<>();
        // spiralSolution(ans, matrix);
        // System.out.println(ans);

        // int n=4;
        // int[][]matrix=new int[n][n];
        // spiralII(matrix);
        int[][] matrix = spiralIII(1, 4, 0, 0);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.println();

    }

    public static void spiralII(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int dir = 1;
        int counter = 1;
        while (left <= right && top <= bottom) {
            if (dir == 1) {
                for (int i = left; i <= right; i++) {
                    matrix[top][i] = counter;
                    counter++;
                }
                dir = 2;
                top++;
            } else if (dir == 2) {
                for (int i = top; i <= bottom; i++) {
                    matrix[i][right] = counter;
                    counter++;
                }
                dir = 3;
                right--;

            } else if (dir == 3) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = counter;
                    counter++;
                }
                dir = 4;
                bottom--;

            } else {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = counter;
                    counter++;
                }
                dir = 1;
                left++;
            }
        }
    }

    public static void spiralSolution(List<Integer> ans, int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int dir = 1;
        while (left <= right && top <= bottom) {
            if (dir == 1) {
                for (int i = left; i <= right; i++) {
                    ans.add(matrix[top][i]);
                }
                dir = 2;
                top++;
            } else if (dir == 2) {
                for (int i = top; i <= bottom; i++) {
                    ans.add(matrix[i][right]);
                }
                dir = 3;
                right--;

            } else if (dir == 3) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                dir = 4;
                bottom--;

            } else {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                dir = 1;
                left++;
            }
        }
    }

    public static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        final int totalCellsToVisit = R * C;
        final int[][] cells = new int[totalCellsToVisit][2];
        int cellsVisited = 0;
        int stepLength = 1;
        int stepsTaken = 0;
        int direction = 0;
        int row = r0, column = c0;

        while (cellsVisited < totalCellsToVisit) {
            // If we are inside the matrix, record the position
            if (row >= 0 && row < R && column >= 0 && column < C) {
                cells[cellsVisited][0] = row;
                cells[cellsVisited][1] = column;
                cellsVisited++;
            }

            // Move a step to correct direction (0=E, 1=S, 2=W, 3=N)
            if (direction == 0) {
                column++;
            } else if (direction == 1) {
                row++;
            } else if (direction == 2) {
                column--;
            } else if (direction == 3) {
                row--;
            }
            stepsTaken++;

            // If we are taken the correct amount of steps to the current direction,
            // change direction
            if (stepsTaken == stepLength) {
                stepsTaken = 0;
                direction++;
                // When going east or west increase the steps we take for each direction
                if (direction == 2) {
                    stepLength++;
                    stepsTaken = 0;
                } else if (direction == 4) {
                    direction = 0;
                    stepLength++;
                    stepsTaken = 0;
                }
            }
        }
        return cells;
    }

    public static int[][] spiralIII(int R, int C, int r0, int c0) {

        int[][] arr = new int[R * C][2];
        int visited = 0;
        int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int mainCounter = 1;
        int Iterator = 0;
        int cIterator = 0;
        int row = r0;
        int col = c0;
        int dir = 0;
        while (visited < R * C) {
            if (row >= 0 && row <= R - 1 && col >= 0 && col <= C - 1) {

                arr[visited][0] = row;
                arr[visited][1] = col;
                visited++;
            }
            row += direction[dir][0];
            col += direction[dir][1];
            Iterator++;
            if (Iterator == mainCounter) {
                dir++;
                dir = dir % 4;
                Iterator=0;
                cIterator++;

            }
            if (cIterator == 2) {
                cIterator=0;
                Iterator=0;
                mainCounter++;
            }

        }

        return arr;

    }
}