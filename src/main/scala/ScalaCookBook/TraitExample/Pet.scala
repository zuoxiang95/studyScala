package ScalaCookBook.TraitExample

/**
	* Created by hp on 2016/12/17.
	*/
trait Pet {
  def speak { println("Yo") }
	def comeToMaster
}

class Dog extends Pet{
	//覆写特质中的抽象方法时可以不用添加override关键词
	def comeToMaster = { println("I am coming!") }
}

class Cat extends Pet{
	//覆写特质中的非抽象方法时需要添加override关键字
	override def speak { println("meow") }
	def comeToMaster = { println("Nothing happen.") }
}

//如果一个类继承了一个特质，但是没有实现特质中的抽象方法，该类就必须得被声明为抽象类
abstract class FlyingPet extends Pet{
	def fly { println("I am flying!") }
}
