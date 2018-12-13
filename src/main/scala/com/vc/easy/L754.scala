package com.vc.easy

object L754 {
  //if different between target and sum until now is even
  //We can flip the sign of one the previous number to make it equal to difference
  //For e.g. target = 5
  //1 2 3 4 5 = Sum will be 15 difference is 10 we can flip the sign of 5 to make sum 5
  //1 + 2 + 3 + 4 - 5 = 5
  def reachNumber(target: Int): Int = {
    var start = 0
    val tPositive = Math.abs(target)
    var steps = 0
    while(start < tPositive || (start - tPositive) % 2 != 0) {
      steps += 1
      start += steps
    }
    steps
  }
}
