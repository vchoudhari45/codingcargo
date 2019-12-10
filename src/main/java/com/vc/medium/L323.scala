package com.vc.medium

object L323 {
  def countComponents(n: Int, edges: Array[Array[Int]]): Int = {
    val pArr = new Array[Int](n)
    pArr.indices.foreach(i => pArr(i) = i)
    def find(x: Int): Int = {
      if(pArr(x) == x) return x
      find(pArr(x))
    }
    edges.foreach(edge => {
      val x = find(edge(0))
      val y = find(edge(1))
      pArr(x) = y
    })
    pArr.indices.foreach(i => if(pArr(i) != i) pArr(i) = find(pArr(i)))
    pArr.distinct.length
  }
}
