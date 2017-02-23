package FPInScala.dataStructure

/**
	* Created by hp on 2017/2/23.
	*/
object InsertSort extends App {
	/**
		* 使用直接插入排序对数组进行排序
		* @param array 需要排序的数列
		* @param dec 布尔值，是否为降序
		* @return 排序好的数组
		*/
  def directInsertSort(array: Array[Int], dec: Boolean): Array[Int] = {
	  for(i <- 1 to (array.length - 1)){
      val temp: Int = array(i)
		  var j = i - 1
		  while(j >= 0){
			  if(temp < array(j) && dec){
				  array(j + 1) = array(j)
				  array(j) = temp
			  }
			  j = j -1
		  }
	  }
	  array
  }
	val x = Array(6, 3, 8, 1, 5, 2, 7)
	directInsertSort(x, true).foreach(println(_))
}
