package com.vc.medium

class LogSystem() {

  import scala.collection.mutable
  val map = new mutable.HashMap[String, Int]()
  def put(id: Int, timestamp: String): Unit = {
    map.put(timestamp, id)
  }

  def retrieve(s: String, e: String, gra: String): List[Int] = {
    var x = 0
    //Year:Month:Day:Hour:Minute:Second
    gra match {
      case "Year"   => x = 4
      case "Month"  => x = 7
      case "Day"    => x = 10
      case "Hour"   => x = 13
      case "Minute" => x = 16
      case "Second" => x = 19
    }
    val start = s.substring(0, x)
    val end = e.substring(0, x)
    val list = new mutable.ListBuffer[Int]()
    map.foreach(t => {
      val tGra = t._1.substring(0, x)
      if(tGra >= start && tGra <= end) list += t._2

    })
    list.toList
  }

}

/**
  * Your LogSystem object will be instantiated and called as such:
  * var obj = new LogSystem()
  * obj.put(id,timestamp)
  * var param_2 = obj.retrieve(s,e,gra)
  */
