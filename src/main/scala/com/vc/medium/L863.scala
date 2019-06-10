package com.vc.medium


class TreeNodeL863(var _value: Int) {
  var value: Int = _value
  var left: TreeNodeL863 = null
  var right: TreeNodeL863 = null
}

object L863 {
  def distanceK(root: TreeNodeL863, target: TreeNodeL863, K: Int): List[Int] = {
    import scala.collection.mutable
    val map = new mutable.HashMap[TreeNodeL863, Int]()
    def find(root: TreeNodeL863): Int = {
      if(root == null) return -1
      if(root == target) {
        map.put(root, 0)
        return 0
      }

      val left = find(root.left)
      if(left >= 0) {
        map.put(root, left + 1)
        return left + 1
      }

      val right = find(root.right)
      if(right >= 0) {
        map.put(root, right + 1)
        return right + 1
      }
      -1
    }
    val res = new mutable.ListBuffer[Int]()
    def dfs(root: TreeNodeL863, length: Int): Unit = {
      if(root != null) {
        var len = length
        if(map.contains(root)) len = map(root)
        if(len == K) res += root.value
        dfs(root.left, len + 1)
        dfs(root.right, len + 1)
      }
    }
    find(root)
    dfs(root, 0)
    res.toList
  }
}
