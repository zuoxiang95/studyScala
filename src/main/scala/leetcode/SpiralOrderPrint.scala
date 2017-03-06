package leetcode

/**
	* Created by hp on 2017/3/6.
	*/
object SpiralOrderPrint extends App {
	/**
		* 转圈打印矩阵
		*
		* @param matrix 需要打印的矩阵
		* @return 打印输出矩阵外圈的所有元素
		*/
	def spiralOrderPrint(matrix: Array[Array[Int]]) = {
		//定义矩阵的第一个元素的索引（0， 0）
		var mr: Int = 0
		var mc: Int = 0
    //定义矩阵的右下角的元素
		var dr: Int = matrix(0).length - 1
		var dc: Int = matrix.length - 1
		//当矩阵的左上角元素不等于右下角元素时，按照环形输出矩阵外圈的元素；输出完成后继续打印内圈元素，知道打印出整个矩阵
		while(mr <= dr && mc <= dc){
			assist(matrix, mr, mc, dr, dc)
			mr = mr + 1
			mc = mc + 1
			dr = dr - 1
			dc = dc - 1
		}
		/**
			* 辅助函数，用于输出矩阵的外圈函数
			*
			* @param matrix 需要打印的矩阵
			* @param mr     需要打印的左上角元素的行数
			* @param mc     需要打印的左上角元素的列数
			* @param dr     需要打印的右下角元素的行数
			* @param dc     需要打印的右下角元素的列数
			* @return 打印输出矩阵外圈的所有元素
			*/
		def assist(matrix: Array[Array[Int]], mr: Int, mc: Int, dr: Int, dc: Int) = {
			//判断当左上角元素和右下角是否在同一行，如果是说明此事的矩阵只剩一行，只需要将这一行打印即可
			if(mr == dr){
				for(i <- mc to dc){
					print(matrix(mr)(i))
				}
			}else if(mc == dc){  /**判断当左上角元素和右下角是否在同一列**/
				for(i <- mr to dr){
					print(matrix(i)(mc))
				}
			}else{  /**一般情况**/
				var tempRow: Int = mr
				var tempCol: Int = mc
				/**
					* 第一种情况：
					* 指针所在的列数不等于右下角元素的列数，此时循环打印出指针所在行的所有元素，知道指针与右下角元素在同一列
					*/
				while(tempCol != dc){
					print(matrix(tempRow)(tempCol))
					tempCol = tempCol + 1
				}
				/**
					* 第二种情况：
					* 指针所在的行数不等于右下角元素的行数，此时循环打印出指针所在列的所有元素，知道指针与右下角元素在同一行
					*/
				while(tempRow != dr){
					print(matrix(tempRow)(tempCol))
					tempRow = tempRow + 1
				}
				/**
					* 第三种情况：
					* 指针所在的列数不等于左上角元素的列数，此时循环打印出指针所在行的所有元素，知道指针与左上角元素在同一列
					*/
				while(tempCol != mc){
					print(matrix(tempRow)(tempCol))
					tempCol = tempCol - 1
				}
				/**
					* 第四种情况：
					* 指针所在的行数不等于左上角元素的行数，此时循环打印出指针所在列的所有元素，知道指针与左上角元素在同一行
					*/
				while(tempRow != mr){
					print(matrix(tempRow)(tempCol))
					tempRow = tempRow - 1
				}
			}
		}
	}

  //创建二维矩阵
	val myMatrix = Array.ofDim[Int](4, 4)
	for (i <- 0 to 3) {
		for ( j <- 0 to 3) {
			myMatrix(i)(j) = j
		}
	}

	spiralOrderPrint(myMatrix)
}
