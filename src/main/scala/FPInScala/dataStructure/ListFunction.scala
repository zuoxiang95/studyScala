package FPInScala.dataStructure


/**
	* Created by hp on 2016/12/21.
	*/
object ListFunction extends App {

	/**
		* Function：去除列表中第一个元素
		* @param input 输入列表
		* @tparam A 列表类型定为泛型A
		* @return 返回将输入列表去除第一个元素的结果
		*/
  def tailFunc[A](input: List[A]): List[A] ={
	  if(input.isEmpty) Nil
	  else input.drop(1)
  }

	/**
		* 将列表的第一个元素替换
		* @param input 输入的列表
		* @param value 要替换的值
		* @tparam A 列表类型为泛型A
		* @return 返回替换第一个元素后的列表
		*/
	def setHead[A](input: List[A], value: A): List[A] = {
		if(input.isEmpty) Nil
		else input.updated(0, value)
	}

	val x = List(1, 2, 3)
	println(tailFunc(x))
	println(setHead(x, 3))
}
