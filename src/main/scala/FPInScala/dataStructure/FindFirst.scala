package FPInScala.dataStructure

/**
	* Created by hp on 2016/12/20.
	*/
object FindFirst extends App {

	/**
		* 在数组中查询字符串的单态函数
		* @param ss 类型为字符串的数组
		* @param key 要查询的字符串
		* @return 若该数组中存在要查询的字符串，则返回该字符串在数组中的索引，否则返回-1
		*/
	def findFirst(ss: Array[String], key: String): Int = {
		@annotation.tailrec
		def loop(n: Int): Int = {
			if (n >= ss.length) -1
			else if (ss(n) == key) n
			else loop(n + 1)
		}
		loop(0)
	}

	/**
		* 在数组中查询值的多态函数
		* @param as 类型为A的数组
		* @param p 函数，接收A类型，返回Boolean类型
		* @tparam A 泛型A代替上面单态函数的String类型，
		* @return 返回数组中要查询的值的索引，若不存在则返回-1
		*/
	def findFirst[A](as: Array[A], p: A => Boolean): Int ={
		@annotation.tailrec
		def loop(n: Int): Int = {
			if(n >= as.length) -1
			else if (p(as(n))) n
			else loop(n + 1)
		}
		loop(0)
	}

	println(findFirst(Array("a", "b", "c"), "b"))
}
