package com.vc.easy

class TreeNode501(var _value: Int) {
  var value: Int = _value
  var left: TreeNode501 = null
  var right: TreeNode501 = null
}

object L501 {
  def findMode(root: TreeNode501): Array[Int] = {
    import scala.collection.mutable
    val st = new mutable.Stack[TreeNode501]()
    val map = mutable.Map[Int, Int]()
    var current = root
    while(current != null || st.nonEmpty) {
      if(current != null) {
        map.put(current.value, map.getOrElse(current.value, 0) + 1)
        st.push(current)
        current = current.left
      }
      else current = st.pop.right
    }
    if(map.isEmpty) return Array()
    val maxCnt = map.maxBy(_._2)._2
    map.filter(_._2 == maxCnt).keys.toArray
  }
}