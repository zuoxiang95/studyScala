package FPInScala.dataStructure
/**
	* Created by hp on 2017/2/23.
	*/
object SelectSort extends App{
	/**
		* 使用简单选择排序对数组进行排序
		* @param array 需要排序的数列
		* @param dec 布尔值，是否为降序
		* @return 排序好的数组
		*/
	def easySelectSort(array: Array[Int], dec: Boolean): Array[Int] = {
		for(i <- 0 to (array.length - 1)){
			var temp = array(i)
			var j: Int = i + 1
			//对第i+1个起的元素进行遍历，选出最小的与第i个进行交换
			while(j < array.length){
				if(temp < array(j) && dec){
					array(i) = array(j)
					array(j) = temp
					temp = array(i)
				}
				j = j + 1
			}
		}
		array
	}
	val x = Array(1,2,3,5,6,7)
	easySelectSort(x, false).foreach(println(_))
}

