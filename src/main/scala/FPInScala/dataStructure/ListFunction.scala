package FPInScala.dataStructure


/**
	* Created by hp on 2016/12/21.
	*/
object ListFunction extends App {

	/**
		* Function：去除列表中第一个元素
		*
		* @param input 输入列表
		* @tparam A 列表类型定为泛型A
		* @return 返回将输入列表去除第一个元素的结果
		*/
	  def tailFunc[A](input: List[A]): List[A] ={

		  //我的实现
		  if(input.isEmpty) sys.error("the input is an empty list!")
		  else input.drop(1)

		  //答案方法
		  input match{
			  case List(_, t) => List(t)
			  case Nil => sys.error("the input is an empty list!")
		  }
	  }

	/**
		* 将列表的第一个元素替换
		*
		* @param input 输入的列表
		* @param value 要替换的值
		* @tparam A 列表类型为泛型A
		* @return 返回替换第一个元素后的列表
		*/
	def setHead[A](input: List[A], value: A): List[A] = {
		if (input.isEmpty) Nil
		else input.updated(0, value)
	}

	/**
		* 删除列表中的前n个元素
		*
		* @param l 输入的列表
		* @param n 要删除前n个
		* @tparam A 列表类型为泛型A
		* @return 返回删除前n个元素后的列表
		*/
	def drop[A](l: List[A], n: Int): List[A] = {
		if (n <= 0) l
		else l match {
			case Nil => Nil
			case List(_, t) => drop(List(t), n - 1)
		}
	}

	/**
		* 删除列表中的不满足判定条件的数据
		*
		* @param l 输入的列表
		* @param f 判定符合条件
		* @tparam A 列表类型为泛型A
		* @return 返回删除不满足条件的元素后的列表
		*/
	def dropWhile[A](l: List[A]) (f: A => Boolean): List[A] = {
		l match {
			case List(h, t) if f(h) => dropWhile[A](List(t))(f)
			case _ => l
		}
	}

	def foldRight[A, B](as: List[A], z: B)(f :(A, B) => B): B = {
		as match {
			case Nil => z
			case List(x, xs) => f(x, foldRight(List(xs), z) (f))
		}
	}

	def sum2(ns: List[Int]) = foldRight(ns, 0)((x, y) => x + y)
	def product(ns: List[Double]) = foldRight(ns, 1.0)((x, y) => x * y)
  def length1[A](ns: List[A]): Int = {
	  var len: Int = 0
	  foldRight(ns, len)((x, y) => {
		  len = len + 1
		  len
	  })
  }

	val x = List(1, 2, 3, 4, 5)
	println(tailFunc(x))
	println(setHead(x, 3))
}
