package com.vc.easy

object L819 {
  def mostCommonWord(paragraph: String, banned: Array[String]): String = {
    import scala.collection.mutable
    val map = new mutable.HashMap[String, Int]()
    val set = new mutable.HashSet[String]()
    banned.foreach(word => set += word.toLowerCase)

    paragraph.replaceAll("\\W+", " ").toLowerCase.split(" ").foreach(word => {
      val cleaned = word.replaceAll("[^A-Za-z]", "")
      if(!set.contains(cleaned)) {
        map.put(cleaned, map.getOrElse(cleaned, 0) + 1)
      }
    })
    map.maxBy(_._2)._1
  }
}
