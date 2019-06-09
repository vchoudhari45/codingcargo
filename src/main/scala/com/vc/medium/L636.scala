package com.vc.medium

class L636 {
  def exclusiveTime(n: Int, logs: List[String]): Array[Int] = {
    case class Log(logString: String) {
      val splitArr = logString.split(":")
      val id = splitArr(0).toInt
      val isStart = splitArr(1).toUpperCase == "START"
      val time = splitArr(2).toInt
    }
    import scala.collection.mutable
    val st = new mutable.Stack[Log]()
    val res = new Array[Int](n)
    logs.indices.foreach(i => {
      val log = Log(logs(i))
      if(log.isStart) st.push(log)
      else {
        val prevLog = st.pop
        val timeDuration = log.time - prevLog.time + 1
        res(log.id) += timeDuration
        if(st.nonEmpty) {
          val prevToPrevLog = st.head
          res(prevToPrevLog.id) -= timeDuration //Remove that timeDuration from prevToPrev log
        }
      }
    })
    res
  }
}
