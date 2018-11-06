package com.vc.easy

object L800 {
  def similarRGB(color: String): String = {
    import scala.collection.mutable
    val str = new mutable.StringBuilder()
    str.append("#")
    (1 until color.length - 1 by 2).foreach(i => {
      val decimalValue = Integer.parseInt(color.substring(i, i + 2), 16)
      val roundingToMultipleOf17 = Math.round(decimalValue.toFloat / 17)
      if(roundingToMultipleOf17 == 0) str.append("00")
      else str.append(Integer.toHexString(roundingToMultipleOf17 * 17))
    })
    str.toString
  }
}
