package com.holelin.others;

/**
 * ClassName: Print_Matrix_By_ZHI
 * "之"形打印矩阵
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/28
 */

public class Print_Matrix_By_ZHI {

	public static void printMatrixByZHI(int[][] matrix) {
		// a,b两点都从(0,0)开始
		// a 由左向右移动,当a的横坐标越界则向下移动
		// b 由上向下移动,当b的纵坐标越界则向右移动
		int ax = 0;
		int ay = 0;
		int bx = 0;
		int by = 0;
		// 结束点
		int endX = matrix.length - 1;
		int endY = matrix[0].length - 1;
		// 控制对角线由上向下打印还是由下向下打印
		boolean fromUp = false;
		while (ax != endX + 1) {
			printLine(matrix, ax, ay, bx, by, fromUp);
			// 当未越界之前,ax的值是不动的,ay的值需要++
			ax = ay == endY ? ax + 1 : ax;
			ay = ay == endY ? ay : ay + 1;
			// 当未越界之前,by的值是不动的,bx的值需要++
			by = bx == endX ? by + 1 : by;
			bx = bx == endX ? bx : bx + 1;
			fromUp = !fromUp;
		}
		System.out.println();
	}

	/**
	 * 打印有(ax,ay)---(bx,by)之间的所有点
	 *
	 * @param matrix 矩阵
	 * @param ax     a的横坐标
	 * @param ay     a的纵坐标
	 * @param bx     b的横坐标
	 * @param by     b的纵坐标
	 * @param fromUp fromUp为true--由上向下打印,反之由下向上打印
	 */
	private static void printLine(int[][] matrix, int ax, int ay, int bx, int by, boolean fromUp) {
		if (fromUp) {
			// 由上向下打印
			while (ax != bx + 1) {
				System.out.print(matrix[ax++][ay--] + " ");
			}
		} else {
			// 由下向上打印
			while (bx != ax - 1) {
				System.out.print(matrix[bx--][by++] + " ");
			}
		}

	}

	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		printMatrixByZHI(matrix);


	}

}
