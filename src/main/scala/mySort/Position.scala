package mySort

/**
	* Created by hp on 2017/3/3.
	*/
object Position {
	def main(args: Array[String]): Unit = {
		val itemList = List("sdf", "def", "aaa", "abc", "asd", "qoq", "asf")
		val itemPriceList: List[Double] = List(1, 2, 3, 3, 3, 3, 6)
		println(findPosition(itemList, itemPriceList, "abc", 3))
	}


	def findPosition(itemList: List[String], itemPriceList: List[Double], itemID: String, itemPrice: Double): (String,
		Int) = {
		val key: Double = itemPrice
		val length: Int = itemPriceList.length - 1
		var mid: Int = 0
		//定义折半查找的起点
		var start: Int = 0
		//定义折半查找的终点
		var end: Int = length
		def findPrice(itemPriceList: List[Double], itemPrice: Double): (Int, Int) = {
			while (start <= end) {
				mid = (start + end) / 2
				//比较key和当前中点的大小，如果小于中点的大小，则将折半查找的终点定位到中点的前一个位置；如果大于中点的大小，则将折半查找的起点定位到中点的后一个位置
				if (key == itemPriceList(mid)) {
					start = mid
					end = mid
					while (itemPriceList(start) == key) {
						start = start - 1
					}
					start = start + 1
					while (itemPriceList(end) == key) {
						end = end + 1
					}
					end = end - 1
					return (start, end)
				} else if (key < itemPriceList(mid)) {
					end = mid - 1
				} else {
					start = mid + 1
				}
			}
			(-1, -1)
		}

		def findFinal(itemList: List[String], start: Int, end: Int, itemID: String): (String, Int) ={
			for(i <- start to end){
				if(itemList(i) == itemID) return (itemID, i)
			}
			(itemID, -1)
		}
		val priceRange = findPrice(itemPriceList, itemPrice)
		findFinal(itemList, priceRange._1, priceRange._2, itemID)
	}
}
