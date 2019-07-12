package com.vc.hard

object L45 {
  def jump(arr: Array[Int]): Int = {
    var curEnd = 0
    var curFarthest = 0
    var jumps = 0
    (0 until arr.length - 1).foreach(i => {
      curFarthest = Math.max(i + arr(i), curFarthest)
      if(i == curEnd) {
        jumps += 1
        curEnd = curFarthest
      }
    })
    jumps
  }
}