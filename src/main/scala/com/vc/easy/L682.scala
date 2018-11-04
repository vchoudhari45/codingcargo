package com.vc.easy

object L682 {
  /**
    * Integer (one round's score): Directly represents the number of points you get in this round.
    * "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
    * "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
    * "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be
    **/
  def calPoints(ops: Array[String]): Int = {
    import scala.collection.mutable
    val st = new mutable.Stack[Int]()
    ops.foreach(op => op match {
      case "+" => {
        val d1 = st.pop()
        val d2 = st.pop()
        st.push(d2)
        st.push(d1)
        st.push(d1 + d2)
      }
      case "D" => st.push(st.head * 2)
      case "C" => st.pop
      case _ =>  st.push(op.toInt)
    })
    st.sum
  }
}
