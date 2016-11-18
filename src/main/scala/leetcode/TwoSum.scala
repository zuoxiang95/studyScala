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

	twoSum(Array(1, 2, 3), 8)
}
