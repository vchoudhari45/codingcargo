package com.vc.easy

object L541 {
  def reverseStr(s: String, k: Int): String = {
    val arr = s.toCharArray
    val n = arr.length
    var start = 0
    var end = 0
    def reverse(from:Int, to:Int): Unit = {
      var fromVar = from
      var toVar = to
      while(fromVar < toVar) {
        val tmp = arr(fromVar)
        arr(fromVar) = arr(toVar)
        arr(toVar) = tmp
        fromVar += 1
        toVar -= 1
      }
    }

    while(start < n) {
      end = Math.min(start + k - 1, n -1)
      reverse(start, end)
      start += 2 * k
    }
    arr.mkString("")
  }
}
