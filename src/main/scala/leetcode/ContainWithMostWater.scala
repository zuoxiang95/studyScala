package leetcode

/**
	* Created by ZX on 2016/11/21.
	*
	* Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
	* n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
	* Find two lines, which together with x-axis forms a container,
	* such that the container contains the most water.
	*
	*/
object ContainWithMostWater extends App {
	/**
		*
 		* @param numList 输入列表
		* @return 由输入列表与索引配对称为的坐标(i, ai)，求得该坐标和(i, 0)连线构成的最大容器
		*/
	def maxArea(numList: List[Int]): Int = {
		var containerList: List[Int] = Nil
		for(i <- 1 to numList.length ){
			for(j <- i + 1 to numList.length){
				containerList = math.min(numList(i - 1), numList(j - 1)) * (j - i) :: containerList
			}
		}
		containerList.max
	}

	maxArea(List(1, 3, 2, 4))
}
