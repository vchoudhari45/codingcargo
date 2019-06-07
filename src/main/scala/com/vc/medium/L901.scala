package com.vc.medium

class StockSpanner() {
  import scala.collection.mutable
  val st = new mutable.Stack[(Int, Int)]()
  def next(price: Int): Int = {
    var res = 0
    while(st.nonEmpty && st.head._1 < price) {
      val e = st.pop
      res += e._2
    }
    st.push((price, res))
    res
  }
}

/**
  * Your StockSpanner object will be instantiated and called as such:
  * var obj = new StockSpanner()
  * var param_1 = obj.next(price)
  */
