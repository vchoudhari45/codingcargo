package com.vc.medium

object L537 {
  def complexNumberMultiply(a: String, b: String): String = {
    val aArr = a.split('+')
    val bArr = b.split('+')

    val aReal = aArr(0).toInt
    val aImg = aArr(1).replace("i", "")toInt

    val bReal = bArr(0).toInt
    val bImg = bArr(1).replace("i", "").toInt

    val ansReal = aReal * bReal - (aImg * bImg)
    val ansImg = aImg * bReal + bImg * aReal

    val ans = ansReal.toString + "+" + ansImg.toString + "i"
    ans
  }
}
