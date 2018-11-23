package com.vc.easy

object L504 {
  def convertToBase7(num: Int): String = {
    def convert(num: Int): Int = {
      if(num > -7 && num < 7) num
      else convert(num / 7) * 10 + num % 7
    }
    convert(num).toString
  }
}