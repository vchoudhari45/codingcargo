package com.vc.easy

object L14 {
  def longestCommonPrefix(arr: Array[String]): String = {
    val n = arr.length
    if(n == 0) return ""
    val prefix = arr(0)
    val m = prefix.length
    var i = 0
    while(i < m) {
      var j = 0
      while(j < n) {
        if(arr(j).length > i && arr(j)(i) == prefix(i)) j += 1
        else return prefix.substring(0, i)
      }
      i += 1
    }
    prefix
  }
}
