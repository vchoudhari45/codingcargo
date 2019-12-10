package com.vc.medium

object L12 {
  def intToRoman(num: Int): String = {
    val i = Array("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")
    val x = Array("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
    val c = Array("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
    val m = Array("", "M", "MM", "MMM")
    m(num / 1000) + c((num % 1000) / 100) + x((num % 100) / 10) + i(num % 10)
  }
}
