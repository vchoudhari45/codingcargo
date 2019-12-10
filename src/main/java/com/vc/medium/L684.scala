package com.vc.medium

object L684 {
  def findRedundantConnection(edges: Array[Array[Int]]): Array[Int] = {
    val pArr = new Array[Int](edges.length + 1)
    pArr.indices.foreach(i => {
      pArr(i) = i
    })
    def union(x: Int, y: Int): Unit = pArr(x) = y
    def find(x: Int): Int = if(pArr(x) == x) x else find(pArr(x))
    edges.foreach(e => {
      val x = find(e(0))
      val y = find(e(1))
      if(x == y) return e
      union(x, y)
    })
    Array.empty[Int]
  }
}
