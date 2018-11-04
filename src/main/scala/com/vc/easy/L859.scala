package com.vc.easy

object L859 {
  import scala.collection.mutable
  def buddyStrings(A: String, B: String): Boolean = {
    if(A.length != B.length) return false
    if(A == B) {
      val set = new mutable.HashSet[Char]()
      A.foreach(x => set += x)
      set.size < A.length
    }
    else {
      val index = new mutable.ArrayBuffer[Int]()
      var count = 0
      A.indices.foreach(i => {
        if(count > 2) return false
        if(A(i) != B(i)) {
          index += i
          count += 1
        }
      })
      A(index(0)) == B(index(1)) && B(index(0)) == A(index(1))
    }
  }
}
