package ScalaCookBook.Collection

/**
	* Created by hp on 2017/2/20.
	*/
object SetOption extends App{
  val fruits = Array("apple", "orange", "banana")

	//普通for循环
	for(element <- fruits){
		println(s"element is $element")
	}

	//计数for循环
	for(i <- 0 until fruits.length){
		println(s"element $i is ${fruits(i)}")
	}

	//使用range进行计数循环
	for(i <- 1 to fruits.length){
		println(s"element $i is ${fruits(i)}")
	}

	//使用ZipWithIndex进行计数
	for((ele, count) <- fruits.view.zipWithIndex){
		println(s"element $count is $ele")
	}

	//在zip中使用Stream生成计数器
	for((ele, count) <- fruits.zip(Stream from 1)){
		println(s"element $count is $ele")
	}

	//for yield 结构
	val newFruits = for(ele <- fruits) yield ele.toUpperCase
}
