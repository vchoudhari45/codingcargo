package com.vc.easy

object L734 {
  def areSentencesSimilar(words1: Array[String], words2: Array[String], pairs: Array[Array[String]]): Boolean = {
    import scala.collection.mutable
    if(words1.length != words2.length) return false

    val map = new mutable.HashMap[String, mutable.HashSet[String]]()
    pairs.foreach(arr => {
      val w1 = arr(0)
      val w2 = arr(1)

      val set1 = map.getOrElse(w1, new mutable.HashSet[String]())
      set1 += w2
      map.put(w1, set1)

      val set2 = map.getOrElse(w2, new mutable.HashSet[String]())
      set2 += w1
      map.put(w2, set2)
    })

    words1.indices.foreach(i => {
      val w1 = words1(i)
      val w2 = words2(i)
      if(!(
            (w1 == w2) ||
            (map.contains(w1) && map(w1).contains(w2)) ||
            (map.contains(w2) && map(w2).contains(w1))
        )) return false
    })
    true
  }
}
