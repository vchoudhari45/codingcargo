package com.vc.easy

object L443 {
  def compress(arr: Array[Char]): Int = {
    var i = 0
    var j = 0
    var count = 0
    val n = arr.length
    while(i < n) {
      val ch = arr(i)
      count = 0
      while(i < n && ch == arr(i)) {
        count += 1
        i += 1
      }
      arr(j) = ch
      j += 1
      if(count > 1) {
        count.toString.foreach(ch => {
          arr(j) = ch
          j += 1
        })
      }
    }
    j
  }
}
