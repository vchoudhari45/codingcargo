package com.vc.medium

object L241 {
  def diffWaysToCompute(input: String): List[Int] = {
    import scala.collection.mutable
    val res = new mutable.ListBuffer[Int]()
    val map = new mutable.HashMap[String, mutable.ListBuffer[Int]]()
    input.indices.foreach(i => {
      val c = input(i)
      if(c == '+' || c == '-' || c == '*') {
        val p1 = input.substring(0, i)
        val p2 = input.substring(i + 1)
        val p1List = map.getOrElse(p1, diffWaysToCompute(p1))
        val p2List = map.getOrElse(p2, diffWaysToCompute(p2))
        p1List.foreach(p1Value => {
          p2List.foreach(p2Value => {
            val r = c match {
              case '+' => p1Value + p2Value
              case '-' => p1Value - p2Value
              case '*' => p1Value * p2Value
            }
            res += r
          })
        })
      }
    })
    if(res.isEmpty) res += input.toInt
    map.put(input, res)
    res.toList
  }
}
