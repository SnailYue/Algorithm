package com.snail.basics;

public class PathInMatrix {

    /**
     * 题目：设计一个函数，用来判断在一个矩阵中，是否存在一条包含某个字符串的路径
     * <p>
     * 解题思路: 这是一个寻找路径的问题，需要判断矩阵中的每一个节点是否都能够走一条路径。
     * 在寻找的过程中，设置一个和矩阵大小相同的布尔型矩阵来记录是否已经访问。
     * 如果该节点已经访问，则将这个节点的状态值置为true,每一次遍历，使用递归向上下左右四个方向遍历。
     *
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || str == null || matrix.length < 1 || matrix.length < str.length) {
            return false;
        }
        boolean[] visited = new boolean[rows * cols];
        int currentLen = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (coreHasPath(matrix, rows, cols, i, j, str, visited, currentLen)) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean coreHasPath(char[] matrix, int rows, int cols, int row, int col, char[] str, boolean[] visited, int currentLen) {
        if (currentLen == str.length) {
            return true;
        }
        boolean hasPath;
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col] && matrix[row * cols + col] == str[currentLen]) {
            ++currentLen;
            visited[row * cols + col] = true;
            hasPath = coreHasPath(matrix, rows, cols, row - 1, col, str, visited, currentLen) ||
                    coreHasPath(matrix, rows, cols, row + 1, col, str, visited, currentLen) ||
                    coreHasPath(matrix, rows, cols, row, col + 1, str, visited, currentLen) ||
                    coreHasPath(matrix, rows, cols, row, col - 1, str, visited, currentLen);
            if (!hasPath) {
                visited[row * cols + col] = false;
            }
        } else {
            return false;
        }
        return hasPath;
    }

    public static void testInstance() {
        char[] matrix = new char[]{'A', 'B', 'C', 'E', 'S', 'F', 'C', 'S', 'A', 'D', 'E', 'E'};

        char[] str = new char[]{'A', 'B', 'C', 'C', 'E', 'D'};
        PathInMatrix pathInMatrix = new PathInMatrix();
        System.out.println("result = " + pathInMatrix.hasPath(matrix, 3, 4, str));
    }


}
