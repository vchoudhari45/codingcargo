package com.vc.medium

class ListNodeL725(var _x: Int = 0) {
  var next: ListNodeL725 = null
  var x: Int = _x
}

object L725 {
  def splitListToParts(root: ListNodeL725, k: Int): Array[ListNodeL725] = {
    var n = 0
    var current = root
    while(current != null) {
      n += 1
      current = current.next
    }

    val arr = new Array[ListNodeL725](k)
    if(root == null || n == 0) return arr

    val width = n / k
    val mod = n % k
    var idx = 0
    var i = 0
    current = root
    while(current != null) {
      var takeElement = width
      if(idx < mod) {
        takeElement += 1
      }
      var res = current
      var prev = current
      while(takeElement > 0) {
        prev = current
        current = current.next
        takeElement -= 1
      }
      prev.next = null
      arr(i) = res
      i += 1
      idx += 1
    }
    arr
  }
}
