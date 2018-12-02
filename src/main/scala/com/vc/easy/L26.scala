package com.vc.easy

object L26 {
  def removeDuplicates(arr: Array[Int]): Int = {
    val n = arr.length
    if(n == 0) return 0
    var lastUniqueIndex = 0
    var i = 0
    while(i < n - 1) {
      if(arr(i) != arr(i + 1)) {
        arr(lastUniqueIndex + 1) = arr(i + 1)
        lastUniqueIndex += 1
      }
      i += 1
    }
    lastUniqueIndex + 1
  }
}
