package com.vc.easy

object L70 {
  def climbStairs(n: Int): Int = {
    if(n == 0) return 0
    else if(n == 1) return 1
    else if(n == 2) return 2

    var one_step_before = 2
    var two_step_before = 1
    var res = 0
    var i = 2
    while(i < n) {
      res = one_step_before + two_step_before
      two_step_before = one_step_before
      one_step_before = res
      i += 1
    }
    res
  }
}
