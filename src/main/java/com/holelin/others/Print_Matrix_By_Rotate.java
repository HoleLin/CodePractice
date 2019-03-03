package com.holelin.others;

/**
 * ClassName: Print_Matrix_By_Rotate
 * <p>
 * 给定一个整型矩阵matrix,请按照转圈的方式打印它
 * 如:
 * 1    2    3   4
 * 5    6    7   8
 * 9    10   11  12
 * 13   14   15  16
 * print : 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 * 要求:额外空间复杂度
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/28
 */

public class Print_Matrix_By_Rotate {


	public static void spiralOrderPrint(int[][] matrix) {
		int startX = 0;
		int startY = 0;
		int endX = matrix.length - 1;
		int endY = matrix[0].length - 1;
		while (startX <= endX && startY <= endX) {
			// 从边缘向中间逼近
			printEdge(matrix, startX++, startY++, endX--, endY--);
		}
	}

	/**
	 * 打印矩阵边缘
	 *
	 * @param matrix 原矩阵
	 * @param startX 开始点横坐标
	 * @param startY 开始点纵坐标
	 * @param endX   结束点横坐标
	 * @param endY   结束点纵坐标
	 */
	public static void printEdge(int[][] matrix, int startX, int startY, int endX, int endY) {
		// 只有一列
		if (startX == endX) {
			for (int i = startY; i < endX; i++) {
				System.out.print(matrix[startX][i]);
			}
		} else if (startY == endY) {
			// 只有一行
			for (int i = startX; i < endX; i++) {
				System.out.print(matrix[i][startY]);
			}
		} else {
			int curX = startX;
			int curY = startY;

			// 横坐标不变,纵坐标curY从startY开始向endY逼近
			while (curY != endY) {
				System.out.print(matrix[startX][curY] + " ");
				curY++;
			}
			// 纵坐标不变,横坐标curX从startX开始向endX逼近
			while (curX != endX) {
				System.out.print(matrix[curX][endY] + " ");
				curX++;
			}
			// 横坐标不变,纵坐标curY从endY向startY逼近
			while (curY != startY) {
				System.out.print(matrix[endX][curY] + " ");
				curY--;
			}
			// 横坐标不变,纵坐标curX从endX向startX逼近
			while (curX != startX) {
				System.out.print(matrix[curX][startY] + " ");
				curX--;
			}
		}

	}

	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20, 21}};
		spiralOrderPrint(matrix);
	}

}
