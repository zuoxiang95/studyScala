package leetcode

/**
	* Created by hp on 2017/3/5.
	*/
object GetMinOfRotation extends App {
	/**
		* 获取一个有序数组的旋转数组的最小值
		*
		* @param array 需要查找最小值的数组
		* @return 数组的最小值
		*/
	def getMinOfRotation(array: Array[Int]): Int = {
		// 定义起点、终点以及中位点
		var start: Int = 0
		var end: Int = array.length - 1
		var mid: Int = 0
		// 定义最小值
		var min: Int = array(start)
		// 循环数组
		while (start < end) {
			mid = (start + end) / 2
			min = math.min(array(mid), array(start))
			//		  如果二分点等于起点和终点，此时无法判断最小值，将起点向左平移一位
			if (array(mid) == array(start) && array(mid) == array(end)) {
				start = start + 1
			} else if (array(mid) >= array(start)) { //当二分点大于起点时，将起点指向二分点的后一个
				min = math.min(min, array(start))
				start = mid + 1
			} else { //当二分点小于终点时，将终点指向二分点的前一个
				min = math.min(min, array(end))
				end = mid - 1
			}
		}
		min
	}

	var test = Array(1, 1, 1, 1, 1, 0, 0, 1)
	println(getMinOfRotation(test))
}
