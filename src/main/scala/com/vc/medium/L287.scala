package com.vc.medium

object L287 {
  def findDuplicate(arr: Array[Int]): Int = {
    var hare = arr(arr(0))
    var tortoise = arr(0)
    while(hare != tortoise) {
      hare = arr(arr(hare))
      tortoise = arr(tortoise)
    }

    tortoise = 0
    while(hare != tortoise) {
      tortoise = arr(tortoise)
      hare = arr(hare)
    }
    tortoise
  }
}

