package com.vc.medium

object L841 {
  def canVisitAllRooms(rooms: List[List[Int]]): Boolean = {
    val n = rooms.length
    val visited = new Array[Boolean](n)
    visited(0) = true
    def dfs(n: Int): Unit = {
      if(!visited(n)) {
        visited(n) = true
        rooms(n).foreach(key => dfs(key))
      }
    }
    rooms.head.foreach(key => dfs(key))
    !visited.contains(false)
  }
}
