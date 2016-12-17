package ScalaCookBook.TraitExample

/**
	* Created by hp on 2016/12/17.
	*/
trait PizzaTrait {
  val maxNumToppings: Int
	var size = 14
}

class Pizza extends PizzaTrait{
	//覆写val字段时，需要加override
	override val maxNumToppings: Int = 10
	//覆写var字段时，不需要添加override
	size = 15
}
