package leetcode

/**
  * 将输入的字符串中特定的字符换为指定的字符
  * Created by ZX on 2017/3/9.
  */
object ReplaceString extends App {
  val input = "abc11abc"
  println(replaceString(findString(input, "abc"), "xx"))

  /**
    *
    * @param input : 输入字符串
    * @param str   ：  需要替换的字符串
    * @return 返回字符数组，将要替换的字符组更改为 0
    */
  def findString(input: String, str: String): Array[Char] = {
    val inputArray = input.toCharArray
    val strArray = str.toCharArray
    var i: Int = 0
    var j: Int = 0
    // 遍历字符数组，判断字符串中是否有等于替换的数组，有则将其换为0
    while (i <= inputArray.length - 1) {
      if (inputArray(i) == strArray(j) && j < strArray.length - 1) {
        i = i + 1
        j = j + 1
      } else if (inputArray(i) == strArray(j)) {
        if (j == strArray.length - 1) {
          var star = i - strArray.length + 1
          while (star <= i) {
            inputArray(star) = 0
            star = star + 1
          }
        }
      } else {
        i = i + 1
        j = 0
      }
    }
    inputArray
  }

  /**
    *
    * @param input   ：  输入的字符数组
    * @param replace ：替换的字符串
    * @return 返回替换完的字符串
    */
  def replaceString(input: Array[Char], replace: String): String = {
    var result: String = ""
    var temp: String = ""
    for (i <- 0 until input.length) {
      if (input(i) != 0.toChar) {
        temp = temp + input(i)
      }
      if (input(i) == 0.toChar && (i == 0 || input(i - 1) == 0.toChar)) {
        result = result + temp + replace
        temp = ""
      }
    }
    result
  }
}
