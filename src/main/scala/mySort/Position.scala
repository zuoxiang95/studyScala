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

		/**
			* 使用折半查找对价格数组进行查找
			*
			* @param itemPriceList 价格列表
			* @param itemPrice     查询的价格
			* @return 返回与查询价格相等的索引区间，如果未找到与商品价格相等的，则返回（-1，-1）
			*/
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

		/**
			* 通过查询的价格相等区间中查找与商品id相等的商品
			*
			* @param itemList      商品ID列表
			* @param start         查询起始索引
			* @param end           商品结束索引
			* @param itemID        商品ID
			* @return 返回商品ID与商品所在的索引，如果商品没有查找到则返回（商品ID，-1）
			*/
		def findID(itemList: List[String], start: Int, end: Int, itemID: String): (String, Int) ={
			for(i <- start to end){
				if(itemList(i) == itemID) return (itemID, i)
			}
			(itemID, -1)
		}
		val priceRange = findPrice(itemPriceList, itemPrice)
		findID(itemList, priceRange._1, priceRange._2, itemID)
	}
}
