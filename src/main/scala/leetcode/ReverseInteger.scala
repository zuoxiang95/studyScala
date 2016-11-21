package leetcode
import scala.math._

/**
	* Created by ZX on 2016/11/21.
	*
	* Reverse digits of an integer.
	* Example1: x = 123, return 321
	* Example2: x = -123, return -321
	*/
object ReverseInteger extends App {
	/**
		*
		* @param num 需要转换的数值
		* @return 返回转化后的数值
		*/
  def reverseInteger(num: Int): Int = {
	  var splitArray : List[Int] = Nil
	  var i: Int = 1
	  var reverseInteger: Double = 0
    //	把每一位上的数字提取出来，放在一个List中
	  while ((num / math.pow(10, i) >= 0.1) || (num / math.pow(10, i) <= -0.1)){
		  val x = num - math.pow(10, i) * (num / math.pow(10, i)).toInt
		  splitArray = (x / math.pow(10, i - 1)).toInt :: splitArray
		  i += 1
	  }
	  //  对提取出来的每一位数字进行重新组合
	  for(i <- 1 to splitArray.length) yield reverseInteger = reverseInteger + (splitArray(i - 1) *  pow(10, i - 1))
	  reverseInteger.toInt
  }
	reverseInteger(13342)
}
