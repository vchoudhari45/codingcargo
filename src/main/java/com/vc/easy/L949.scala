package com.vc.easy

object L949 {
  def largestTimeFromDigits(arr: Array[Int]): String = {
    var max = ""
    arr.indices.foreach(i => {
      arr.indices.foreach(j => {
        arr.indices.foreach(k => {
          if(!(i == j || j == k || k == i)) {
            val h = "" + arr(i) + arr(j)
            val m = "" + arr(k) + arr(6 - i - j - k)
            val ans = h + ":" +m
            if(h.compareTo("24") < 0 && m.compareTo("60") < 0 && max.compareTo(ans) < 0) max = ans
          }
        })
      })
    })
    max
  }
}
