package com.vc.medium

object L1040 {
  def numMovesStonesII(stones: Array[Int]): Array[Int] = {
    //[4, 7, 9]
    //4 _ _ 7 _ 9
    scala.util.Sorting.quickSort(stones)
    val numberOfStones = stones.length
    val range = stones(numberOfStones - 1) - stones(0)
    val totalSpaces = range - numberOfStones + 1
    val max = totalSpaces - Math.min(
      stones(1) - stones(0) - 1,
      stones(numberOfStones - 1) - stones(numberOfStones - 2) - 1
    )

    var min = numberOfStones
    var i = 0
    var j = 0
    while(i < numberOfStones) {
      while(stones(i) - stones(j) >= numberOfStones) j += 1
      if(i - j + 1 == numberOfStones - 1 && stones(i) - stones(j) == numberOfStones - 2) {
        min = Math.min(min, 2)
      }
      else {
        min = Math.min(min, numberOfStones - (i - j + 1))
      }
      i += 1
    }
    Array(min, max)
  }
}
