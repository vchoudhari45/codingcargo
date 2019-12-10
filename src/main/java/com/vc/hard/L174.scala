package com.vc.hard

object L174 {
  def calculateMinimumHP(arr: Array[Array[Int]]): Int = {
    /**
             0  1  2
           0 7  5  2
           1 6 11  5
           2 1  1  6
      */
    val n = arr.length
    val m = arr(0).length
    val dp = Array.ofDim[Int](n, m)
    (n - 1 to 0 by -1).foreach(i => {
      (m - 1 to 0 by -1).foreach(j => {
        if(i == n - 1 && j == m - 1) {
          //Start where princess is i = n - 1 & j = m - 1
          //At this location you need to have at least health = 1
          //Or 1 + Health you will lose while killing the demon i.e. arr(i)(j)
          dp(i)(j) = Math.max(1, 1 - arr(i)(j))
        }
        else if(i == n - 1) {
          //i = n - 1 you only have room on your right
          //At this location you need to have at least health = 1
          //Or minimumHealth to enter the room on your right
          //+ Health you will lose or gain in this room
          //So let's say this is magic room in that case dp(i)(j + 1) - arr(i)(j) will actually be give you neg answer
          dp(i)(j) = Math.max(1, dp(i)(j + 1) - arr(i)(j))
        }
        else if(j == m - 1) {
          //Same as n - 1 but you can only have room below you so i + 1
          dp(i)(j) = Math.max(1, dp(i + 1)(j) - arr(i)(j))
        }
        else {
          //You have room below you or to your right
          //Take minimumHealth requirement from below or from room on your right
          //And then add or substract current room's requirement
          //If current room is magic room then it will give you neg answer
          //If current room is demon room then it will give you pos answer
          dp(i)(j) = Math.max(1, Math.min(dp(i)(j + 1), dp(i + 1)(j)) - arr(i)(j))
        }
      })
    })
    dp(0)(0)
  }
}