package com.vc.easy

object L401 {
  def readBinaryWatch(num: Int): List[String] = {
    import scala.collection.mutable
    val res = new mutable.ListBuffer[String]()
    (0 until 12).foreach(h => {
      (0 until 60).foreach(m => {
        if(Integer.bitCount(h * 64 + m) == num) { //64 here because 4 LEDs in top row
          res += String.format("%d:%02d", new Integer(h), new Integer(m))
        }
      })
    })
    res.toList
  }
}
