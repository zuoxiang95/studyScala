package leetcode


/**
	* Created by hp on 2017/2/26.
	* 将数组进行旋转，从第k个位置开始
	* Given inputVector = [1, 2, 3, 4, 5], k = 2,
	* *
	* return [4, 5, 1, 2, 3].
	*
	*/
object ArrayReverse extends App {
	/**
		* 通过修改数组，对数组进行三次反转，达到目的
		*
		* @param inputVector : 输入数组
		* @param      k      : 旋转开始的索引位置
		* @return 返回旋转完成后的数组
		*/
	def arrayReverse(inputVector: Array[Int], k: Int): Array[Int] = {
		// 判断输入的数组是否为空，以及旋转的位置是否大于数组的长度
		if (inputVector.isEmpty || k > inputVector.length - 1) sys.error("Input is illegal!!")
		// 第一次将整个数组进行反转
		reverse(inputVector, 0, inputVector.length - 1)
		// 第二次将数组的前k个进行反转
		reverse(inputVector, 0, k - 1)
		// 第三次将剩余的n-k个进行反转
		reverse(inputVector, k, inputVector.length - 1)

		/**
			* 对数组进行反转的函数
			*
			* @param  input : 输入数组
			* @param  start : 旋转开始的索引位置
			* @param   end  : 旋转结束的索引位置
			*
			*/
		def reverse(input: Array[Int], start: Int, end: Int): Unit = {
			var i = start
			var j = end
			while (i < j) {
				// 将第i个与第j个数字进行互换
				val temp = input(i)
				input(i) = input(j)
				input(j) = temp
				i = i + 1
				j = j - 1
			}
		}

		inputVector
	}

	val data = Array(1, 2, 3, 4, 5)
	arrayReverse(data, 3) foreach print
}
