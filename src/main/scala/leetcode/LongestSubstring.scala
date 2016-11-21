package leetcode

/**
	* Created by zx on 2016/11/18.
	*
	* Given "abcabcbb", the answer is "abc", which the length is 3.
	*
	* Given "bbbbb", the answer is "b", with the length of 1.
	*
	* Given "pwwkew", the answer is "wke", with the length of 3.
	*
	* Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
	*
	**/
object LongestSubstring extends App {
  def findLongestString(str: String) ={
	  val answer = for(i <- 0 to (str.length -1)) yield {
		  val indexString = str.substring(i + 1)

		  val endNumber = if (indexString.contains(str(i))){
			  indexString.indexOf(str(i))

		  } else if(indexString.length < 0)  1 else indexString.length

		  val q = str.substring(i, endNumber + i + 1)
		  val p = if(q.contains(q(q.length - 1))) q.indexOf(q(q.length - 1)) else q.length -1
		  q.substring(0, p + 1)
	  }
	  println(answer)
	  println(answer.map(_.length).max)

  }
	findLongestString("abcabcbb")

}
