package FPInScala.dataStructure

/**
	* Created by hp on 2016/12/20.
	*/
object IsSorted extends App{

	def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
		@annotation.tailrec
		def loop(n: Int): Boolean = {
			if(n >= as.length) false
			else if(ordered(as(n-1), as(n))) true
			else loop(n + 1)
		}
		loop(1)
	}

	println(isSorted(Array(1, 2, 3, 4, 5), (x: Int, y: Int) => x < y))
}
