package com.vc.hard

object L834 {
  def sumOfDistancesInTree(N: Int, edges: Array[Array[Int]]): Array[Int] = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, mutable.HashSet[Int]]()

    edges.foreach(x => {
      val from = x(0)
      val to = x(1)
      val fromList = map.getOrElse(from, new mutable.HashSet[Int]())
      val toList = map.getOrElse(to, new mutable.HashSet[Int]())
      fromList += to
      toList += from
      map.put(from, fromList)
      map.put(to, toList)
    })

    val res = new Array[Int](N)
    val count = new Array[Int](N)

    def fromRootToChild(root: Int, pre: Int): Unit = {
      if(map.contains(root)) {
        map(root).foreach(child => {
          if(child != pre) {
            fromRootToChild(child, root)
            count(root) += count(child)
            res(root) += res(child) + count(child)
          }
        })
      }
      count(root) += 1
    }

    def fromChildToRoot(root: Int, pre: Int): Unit = {
      if(map.contains(root)) {
        map(root).foreach(child => {
          if(child != pre) {
            res(child) = res(root) - count(child) + N - count(child)
            fromChildToRoot(child, root)
          }
        })
      }
    }

    fromRootToChild(0, -1)
    fromChildToRoot(0, -1)
    res
  }
}