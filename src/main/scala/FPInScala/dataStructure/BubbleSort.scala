package FPInScala.dataStructure

/**
	* Created by hp on 2017/3/1.
	*/
object BubbleSort extends App {
	/**
		* 使用冒泡排序对数组进行排序
		* @param array 需要排序的数列
		* @return 排序好的数组
		*/
	def bubbleSort(array: Array[Int]): Array[Int] ={
		//定义尾指针
		var j: Int = array.length - 1
		var temp: Int = 0
		while (j > 0){
			temp = array(0)
			for(i <- 1 to j){
				//判断当前数字是否小于相邻的数，如果小于则进行交换
				if(temp > array(i)){
					array(i - 1) = array(i)
					array(i) = temp
				}else{
					temp = array(i)
				}
			}
			//遍历完一次数组后移动尾指针
			j = j - 1
		}
		array
	}

	val x = Array(6, 3, 8, 1, 5, 2, 7)
	bubbleSort(x) foreach println
}
