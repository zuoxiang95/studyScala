package leetcode

/**
	* Created by hp on 2017/3/1.
	*/
object TopK extends App {
	/**
		* 使用快速排序思想，任取数组中的一个数，把大于该数的放在该数的后面；小于这个数的数放在前面
		*
		* @param array 需要排序的数列
		* @param k     想要前k个数
		* @return 返回数组中最小的k个数
		*/
	def topK(array: Array[Double], k: Int): Array[Double] = {
		/**
			* 使用快速排序思想，任取数组中的一个数，把大于该数的放在该数的后面；小于这个数的数放在前面
			*
			* @param array 需要排序的数列
			* @param star  数组开始排序的索引
			* @param end   数组结束排序的索引
			* @return 排序好的数组和取的数的索引
			*/
		def quick(array: Array[Double], star: Int, end: Int): (Array[Double], Int) = {
			var i: Int = star
			var j: Int = end
			var key: Double = 0
			key = array(i)
			while (i < j) {
				while (i < j && key < array(j)) j = j - 1
				array(i) = array(j)
				while (i < j && key > array(i)) i = i + 1
				array(j) = array(i)
			}
			array(i) = key
			(array, i)
		}


		//进行一次快速排序
		val sortResult = quick(array, 0, array.length - 1)
		//将排序后的索引复制给index
		var index = sortResult._2
		//判断index是否等于k，如果小于k，则对index后面的数组继续使用快速排序；如果index大于k，则对index前面的数组使用快速排序，直到index值等于k
		while (index != k) {
			if (index < k) {
				val smallResult = quick(array, index + 1, array.length - 1)
				index = smallResult._2
			} else {
				val bigResult = quick(array, 0, index - 1)
				index = bigResult._2
			}
		}
    //取数组的前k个即为该数组中最小的k个数
		array.take(k)
	}

	val x: Array[Double] = Array(6, 3, 8, 1, 5, 2, 7)
	topK(x, 5) foreach println
}
