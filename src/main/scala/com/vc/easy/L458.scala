package com.vc.easy

object L458 {
  def poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int = {
    val time = minutesToTest / minutesToDie
    val attempt = time + 1
    var pigs = 0
    while(Math.pow(attempt, pigs) < buckets) pigs += 1
    pigs
  }
}
