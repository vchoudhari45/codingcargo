package com.vc.medium

object L650 {
  def minSteps(n: Int): Int = {
    val dp = new Array[Int](n + 1)
    (2 to n).foreach(i => {
      dp(i) = i
      import scala.util.control.Breaks._
      breakable {
        (i - 1 until 0 by -1).foreach(j => {
          if(i % j == 0) {
            dp(i) = dp(j) + i / j
            break
          }
        })
      }
    })
    dp(n)
  }
}
