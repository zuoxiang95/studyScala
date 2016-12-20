package FPInScala

/**
	* Created by hp on 2016/12/20.
	*/
object Fib extends App {

	/**
		* function: 利用递归返回斐波拉契数列的第n个数字
		* @param n 第n个
		* @return 斐波拉契数列的第n个数字
		*/
	def fib(n: Int): Int = {
		def go(n: Int): Int ={
			if(n > 2) go(n-1) + go(n-2)
			else if(n == 2) 1
			else 0
		}
		go(n)
	}

	println(fib(7))
}
