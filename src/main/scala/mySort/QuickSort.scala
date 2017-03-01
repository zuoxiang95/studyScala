package mySort

/**
	* Created by hp on 2017/3/1.
	*/
object QuickSort extends App {
	/**
		* 使用快速排序对数组进行排序
		* @param array 需要排序的数列
		* @param star  数组开始排序的索引
		* @param end   数组结束排序的索引
		* @return 排序好的数组
		*/
	def quickSort(array: Array[Int], star: Int, end: Int): Array[Int] = {
    //判断当前开始索引是否大于等于结束索引，如果大于，则此时排序已完成，返回排好序的数组
		if(star >= end) return array
		var i: Int = star //定义首指针
		var j: Int = end  //定义尾指针
		var temp: Int = 0
		temp = array(i)
    //对数组进行遍历
		while(i < j){
			//在首指针小于尾指针的情况下，判断当前的temp与尾指针指向的数字大小，如果当前的temp小于尾指针所在的数字，则将尾指针向前移动
			while(i < j && temp < array(j)) j = j - 1
      //当跳出上述while循环后，证明已经找到一个数字比当前temp大，则将这个数复制给首指针所在的数字
			array(i) = array(j)
			i = i + 1
			//在在首指针小于尾指针的情况下，判断当前的temp与首指针指向的数字大小，如果当前的temp小于首指针所在的数字，则将首指针向后移动
			while(i < j && temp > array(i)) i = i + 1
			//当跳出上述while循环后，证明已经找到一个数字比当前temp大，则将这个数复制给尾指针所在的数字
			array(j) = array(i)
			j = j + 1
		}
		//遍历完成后将当前的temp值复制给第i个位置
		array(i) = temp
		//对余下的两个部分进行递归使用快速排序的方法
		quickSort(array, star, i - 1)
		quickSort(array, i + 1, end)
	}
	val x = Array(6, 3, 8, 1, 5, 2, 7)
	quickSort(x, 0, x.length-1) foreach println
}
