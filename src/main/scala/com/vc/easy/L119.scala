package com.vc.easy

object L119 {
  def getRow(rowIndex: Int): List[Int] = {
    var i = 1
    var j = 1
    var arrOld = new Array[Int](i)
    arrOld(0) = 1
    while(i <= rowIndex) {
      val arr = new Array[Int](i + 1)
      j = 1
      arr(0) = 1
      arr(i) = 1
      while(j < i) {
        arr(j) = arrOld(j - 1)+ arrOld(j)
        j += 1
      }
      arrOld = arr
      i += 1
    }
    arrOld.toList
  }
}
