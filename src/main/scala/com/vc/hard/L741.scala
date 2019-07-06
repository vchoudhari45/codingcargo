package com.vc.hard

object L741 {
  def cherryPickup(grid: Array[Array[Int]]): Int = {
    /* Idea here is to maintain the state of forward path & backward path at the same time
       because cherries picked up during the forward path will not be available on the backward path

       so let's maintain 4 dimensional array of state and max at that state
            dp[x1][y1][x2][y2]
       but since we can
            move only right & down on the forward path &
            move only left & up on the backward path
       we can reduce the time complexity to n3 because x1 + y1 = x2 + y2 and so state array will be
            dp[x1][y1][x2]

       Max value at dp[x1][y1][x2] will be max of previous state and previous states are as below
        dp[x1 - 1][y1][x2 - 1]  <- Forward path is coming from above & Backward Path is coming from below
        dp[x1 - 1][y1][x2]      <- Forward path is coming from above & Backward Path is coming from right
        dp[x1][y1 - 1][x2 - 1]  <- Forward path is coming from left & Backward Path is coming below
        dp[x1][y1 -1][x2]       <- Forward path is coming from left & Backward Path is coming right

       Add grid(x1)(y1) value to Max from above
       if (x1, y1) & (x2, y2) are different positions then add grid(x2, y2) as well

       build this and return dp(n)(m)(n)
    */
    val n = grid.length
    if(n == 0) return 0
    val m = grid(0).length
    val dp = Array.ofDim[Int](n + 1, m + 1, n + 1) // +1 to avoid corner cases

    dp.indices.foreach(i => {
      dp(i).indices.foreach(j => {
        dp(j).indices.foreach(k => {
          dp(i)(j)(k) = Int.MinValue
        })
      })
    })

    dp(1)(1)(1) = grid(0)(0)
    (1 to n).foreach(x1 => {
      (1 to m).foreach(y1 => {
        (1 to n).foreach(x2 => {
          val y2 = x1 + y1 - x2
          if(
            y2 > 0 && y2 <= m &&
              dp(x1)(y1)(x2) <= 0 &&          //We already know the max of this state
              grid(x1 - 1)(y1 - 1) != -1 &&  //No thorn on x1 & y1
              grid(x2 - 1)(y2 - 1) != -1     //No thorn on x2 & y2
          ) {
            var max = Math.max(
              dp(x1 - 1)(y1)(x2 - 1),
              dp(x1 - 1)(y1)(x2)
            )
            max = Math.max(
              max,
              dp(x1)(y1 -1)(x2)
            )
            max = Math.max(
              max,
              dp(x1)(y1 -1)(x2 - 1)
            )
            if(max >= 0) {
              max += grid(x1 - 1)(y1 - 1) //Cherries at that position
              if(x1 != x2 && y1 != y2) max += grid(x2 - 1)(y2 - 1)
              dp(x1)(y1)(x2) = max
            }
          }
        })
      })
    })
    if(dp(n)(m)(n) == Int.MinValue) 0 else dp(n)(m)(n)
  }
}
