package com.vc

object L905 {
  def sortArrayByParity(A: Array[Int]): Array[Int] = {
    var evenIdx = 0
    var oddIdx = A.length - 1
    while(evenIdx < oddIdx) {
      while(evenIdx < oddIdx && A(evenIdx) % 2 == 0) evenIdx += 1
      while(evenIdx < oddIdx && A(oddIdx) % 2 != 0) oddIdx -= 1
      val tmp = A(evenIdx)
      A(evenIdx) = A(oddIdx)
      A(oddIdx) = tmp
    }
    A
  }
}
