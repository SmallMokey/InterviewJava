/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题13：机器人的运动范围
 * // 题目：地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它
 * // 每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和
 * // 大于k的格子。例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。
 * // 但它不能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
package com.jchanghong.code;

public class Java13_RobotMove {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0)
            return 0;

        boolean[] visited = new boolean[rows * cols];
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;

            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited) +
                    movingCountCore(threshold, rows, cols, row + 1, col, visited) +
                    movingCountCore(threshold, rows, cols, row, col - 1, visited) +
                    movingCountCore(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }

    private boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && getDigSum(row) + getDigSum(col) <= threshold && !visited[row * cols + col])
            return true;
        return false;
    }

    private int getDigSum(int numbers) {
        int sum = 0;
        while (numbers > 0) {
            sum += numbers % 10;
            numbers /= 10;
        }
        return sum;
    }


}
