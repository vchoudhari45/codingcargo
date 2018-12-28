package com.vc.easy

object L204 {
  def countPrimes(n: Int): Int = {
    if(n == 0 || n == 1) return 0

    val isNotPrime = new Array[Boolean](n)
    isNotPrime(0) = true
    isNotPrime(1) = true
    val sqrt = Math.sqrt(n)

    var i = 0
    var j = 0
    while(i < sqrt) {
      j = 2
      if(!isNotPrime(i)) {
        while(i * j < n) {
          isNotPrime(i * j) = true
          j += 1
        }
      }
      i += 1
    }
    isNotPrime.count(_ == false)
  }
}
