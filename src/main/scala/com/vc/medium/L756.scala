package com.vc.medium

object L756 {
  def pyramidTransition(bottom: String, allowed: List[String]): Boolean = {
    import scala.collection.mutable
    val level = new mutable.ArrayBuffer[Char]()
    val next = new mutable.ArrayBuffer[Char]()
    val map = new mutable.HashMap[String, mutable.ArrayBuffer[Char]]()
    bottom.foreach(ch => level += ch)
    allowed.foreach(str => {
      val key = str.substring(0, 2)
      val arr = map.getOrElse(key, new mutable.ArrayBuffer[Char]())
      arr += str(2)
      map.put(key, arr)
    })
    def solve(index: Int, level: mutable.ArrayBuffer[Char], next: mutable.ArrayBuffer[Char]): Boolean = {
      var indexVar = index
      var levelVar = level
      var nextVar = next
      if(levelVar.length - 1 == indexVar) {
        if(nextVar.length == 1) return true
        indexVar = 0
        levelVar = nextVar
        nextVar = new mutable.ArrayBuffer[Char]()
      }
      val x = levelVar(indexVar)
      val y = levelVar(indexVar + 1)
      val prefix = x+""+y
      if(!map.contains(prefix)) return false
      map(prefix).foreach(ch => {
        nextVar += ch
        if(solve(indexVar + 1, levelVar, nextVar)) return true
        nextVar.remove(nextVar.length - 1)
      })
      false
    }
    solve(0, level, next)
  }
}


