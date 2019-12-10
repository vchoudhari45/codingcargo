package com.vc.medium

object L869 {
  def reorderedPowerOf2(N: Int): Boolean = {
    import scala.util.Sorting._
    val inputArray = N.toString.toCharArray
    quickSort(inputArray)

    (0 until 31).foreach(i => {
      val matchArray = (1 << i).toString.toCharArray
      quickSort(matchArray)
      if(matchArray sameElements inputArray) return true
    })
    false
  }
}