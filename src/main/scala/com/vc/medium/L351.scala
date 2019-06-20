package com.vc.medium

object L351 {
  def numberOfPatterns(m: Int, n: Int): Int = {
    val skip = Array.ofDim[Int](10, 10)

    skip(1)(3) = 2
    skip(3)(1) = 2

    skip(3)(9) = 6
    skip(9)(3) = 6

    skip(7)(9) = 8
    skip(9)(7) = 8

    skip(1)(7) = 4
    skip(7)(1) = 4

    skip(1)(9) = 5
    skip(9)(1) = 5

    skip(3)(7) = 5
    skip(7)(3) = 5

    skip(2)(8) = 5
    skip(8)(2) = 5

    skip(4)(6) = 5
    skip(6)(4) = 5

    import scala.collection.mutable
    val visited = new mutable.HashSet[Int]()
    def dfs(cur: Int, remain: Int): Int = {
      if(remain < 0) return 0
      if(remain == 0) return 1
      var res = 0
      visited += cur
      (1 to 9).foreach(i => {
        if(!visited(i) && (skip(cur)(i) == 0 || visited.contains(skip(cur)(i)))) {
          res += dfs(i, remain - 1)
        }
      })
      visited.remove(cur)
      res
    }

    var res = 0
    (m to n).foreach(i => {
      res += dfs(1, i - 1) * 4
      res += dfs(2, i - 1) * 4
      res += dfs(5, i - 1)
    })
    res
  }
}