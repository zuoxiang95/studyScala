package ScalaCookBook.TraitExample

/**
	* Created by hp on 2016/12/17.
	* 设计一个类混入多个特质，获得更强大的功能！
	*/
trait Tail {
  def wagTail { println("tail is wagging!") }
	def stopTail { println("tail is stopped!") }
}
abstract class MyPet(var name: String){
	def speak
	def ownerIsHome {println("excited")}
	def jumpForJoy { println("jumping for joy")}
}

class MyDog(name: String) extends MyPet(name) with Tail{
	def speak { println("woof")}
	override def ownerIsHome: Unit = {
		wagTail
		speak
	}
}

object Test extends App{
	val zeus = new MyDog("Zeus")
	zeus.ownerIsHome
	zeus.jumpForJoy
}