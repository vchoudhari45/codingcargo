package com.vc.medium

object L553 {
  def optimalDivision(arr: Array[Int]): String = {
    val n = arr.length
    if(n == 1) arr(0).toString
    else if(n == 2) s"${arr(0)}/${arr(1)}"
    else {
      import scala.collection.mutable
      val str = new mutable.StringBuilder
      str.append(arr(0)).append("/(").append(arr(1))
      (2 until n).foreach(i => {
        str.append("/").append(arr(i))
      })
      str.append(")")
      str.toString
    }
  }
}
