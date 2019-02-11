package com.vc.medium

object L484 {
  def findPermutation(s: String): Array[Int] = {
    val str = s + "."
    val n = str.length
    //DDI
    val arr = new Array[Int](n)
    var arrIndex = 0
    var strIndex = 0
    var number = 1
    while(strIndex < n) {
      if(str(strIndex) == 'I') {
        arr(arrIndex) = number
        strIndex += 1
        arrIndex += 1
        number += 1
      }
      else {
        while(str(strIndex) == 'D') {
          strIndex += 1
          number += 1
        }
        val diff = strIndex - arrIndex
        while(arrIndex <= strIndex) {
          arr(arrIndex) = number
          arrIndex += 1
          number -= 1
        }
        number = number + diff + 2
        strIndex += 1
      }
    }
    arr
  }
}
