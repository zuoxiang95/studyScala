package leetcode

/**
	* Created by zx on 2016/11/18.
	*
	* Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
	*
	*/
object TwoSum extends App{

	/**
		* 暴力求解
		* @param inputVector : 输入数组
		* @param target      : 希望求和达到的值
		*
		* @return 返回数组中求和等于target的元素的索引
		*/
  def twoSum(inputVector: Array[Int], target: Int): Unit ={
	  val z = inputVector.flatMap{x =>
		  inputVector.filter(_ != x)
			  .filter(_ + x == target)
			  .map{p =>
				  (inputVector.indexOf(p), inputVector.indexOf(x))
			  }
	  }
	  if(z.isEmpty) println("there is no solution!") else z.foreach(println)
  }

	/**
		* 排序双指针
		* @param inputVector : 输入数组
		* @param target      : 希望求和达到的值
		*
		* @return 返回数组中求和等于target的元素的索引
		*/
	def twoSum2(inputVector: Array[Int], target: Int): Unit ={
		//先对数组进行排序
		val newArray = inputVector.sorted
		//定义i，j两个指针
		var i: Int = 0
		var j: Int = inputVector.length - 1
		// 对数组进行扫描，对两个数之和与目标值进行比较，
		// 当小于目标值时，将i+1；
		// 当大于目标值时，将j-1；
		// 等于目标值时，输出在原始数组中的索引
		while(i < j){
			if(newArray(i) + newArray(j) < target){
				i = i + 1
			}else if(newArray(i) + newArray(j) > target){
				j = j - 1
			}else{
				println((inputVector.indexOf(newArray(i)), inputVector.indexOf(newArray(j))))
				i = i + 1
			}
		}
	}

	//定义一个空的Hash Map
	val x = scala.collection.mutable.HashMap.empty[Int, Int]

	twoSum2(Array(1, 2, 3, 5), 6)
}
