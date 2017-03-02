package mySort

/**
	* Created by hp on 2017/3/2.
	*/
object BinaryInsertSort extends App {
	/**
		* 使用折半插入排序对数组进行排序
		*
		* @param array 需要排序的数列
		* @return 排序好的数组
		*/
	def binaryInsertSort(array: Array[Int]): Array[Int] = {
		var temp: Int = 0
		val length = array.length - 1
		//遍历循环数组
		for (i <- 1 to length) {
			temp = array(i)
			var m: Int = 0
			//定义折半插入的起点
			var n: Int = i - 1           //定义折半插入的终点
			while (m <= n) {
				val p: Int = (m + n) / 2   //定义中点
				//比较temp和当前中点的大小，如果小于中点的大小，则将折半插入的终点定位到中点的前一个位置；如果大于中点的大小，则将折半插入的起点定位到中点的后一个位置
				if (temp < array(p)) {
					n = p - 1
				} else {
					m = p + 1
				}
			}
			var j: Int = i
			//将折半插入位置的后面数都往后平移
			while (j > m) {
				array(j) = array(j - 1)
				j = j - 1
			}
			//插入数据
			array(m) = temp
		}
		array
	}

	val x = Array(6, 8, 3, 9, 1, 13, 11)
	binaryInsertSort(x) foreach println
}
