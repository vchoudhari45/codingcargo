package com.vc.easy

object L246 {
  def isStrobogrammatic(num: String): Boolean = {
    val map = Map(
      '0' -> '0',
      '1' -> '1',
      '6' -> '9',
      '8' -> '8',
      '9' -> '6'
    )

    var i = num.length - 1
    import scala.collection.mutable
    val str = new mutable.StringBuilder
    while(i >= 0) {
      if(map.contains(num(i))) str.append(map(num(i)))
      else return false
      i -= 1
    }
    str.toString == num
  }
}
