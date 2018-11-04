package com.vc

object L811 {
  /**
  ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]

        com -> 951
        mail.com -> 901
        google.mail.com -> 900
        yahoo.com -> 50
        intel.mail.com -> 1
        org -> 5
        wiki.org -> 5
    */
  def subdomainVisits(cpdomains: Array[String]): List[String] = {
    import scala.collection.mutable
    val map = new mutable.HashMap[String, Int]()
    cpdomains.foreach(x => {
      val arr = x.split(" ")
      val count = arr(0).toInt
      val str = arr(1)
      var i = str.length
      while(i >= 0) {
        if(str(i) == '.' || i == 0) {
          val s = if(i == 0) str.substring(i) else str.substring(i + 1)
          map.put(s, map.getOrElse(s, 0) + count)
        }
        i -= 1
      }
    })
    val out = mutable.ListBuffer[String]()
    map.foreach(x => {
      out += s"${x._2} ${x._1}"
    })
    out.toList
  }
}


