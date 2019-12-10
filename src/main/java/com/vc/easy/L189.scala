package com.vc.easy

object L189 {
  def rotate(arr: Array[Int], k: Int): Unit = {
    val n = arr.length
    val kNew = k % n
    reverse(0, n - 1)
    reverse(0, kNew - 1)
    reverse(kNew, n - 1)
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
  }
}
