package leetcode

/**
  * Created by ZX on 2017/3/9.
  */
object GetCountString {
  def main(args: Array[String]): Unit = {
    val str = "aaabbccd"
    println(getCountString(str))
  }

  /**
    * 压缩字符串： 将aaabbccd -> a3b2c2d1
    *
    * @param str 需要压缩的字符串
    * @return 压缩后的字符串
    */
  def getCountString(str: String): String = {
    // 将字符串转化为字符数组
    val strArray = str.toCharArray
    // 定义结果变量
    var result: String = ""
    // 定义相同字符出现的次数
    var time: Int = 1
    // 循环遍历数组
    for (i <- 0 until strArray.length) {
      // 判断是否到达数组的最后一个，到达后直接输出字符和出现次数
      if (i == strArray.length - 1) {
        result = result + strArray(i) + time
        //判断当前字符串与后一个字符串是否相等，相等出现次数加1，不相等的情况将字符与出现次数添加到结果的后端
      } else if (strArray(i) == strArray(i + 1)) {
        time = time + 1
      } else {
        result = result + strArray(i) + time
        time = 1
      }
    }
    result
  }
}