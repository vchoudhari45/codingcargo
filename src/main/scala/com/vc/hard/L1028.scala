package com.vc.hard


class TreeNode1028(var _value: Int) {
  var value: Int = _value
  var left: TreeNode1028 = null
  var right: TreeNode1028 = null
}

object L1028 {
  def recoverFromPreorder(s: String): TreeNode1028 = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, TreeNode1028]()
    var i = 0
    val n = s.length
    while(i < n) {
      var level = 0
      while(s(i) == '-'){
        level += 1
        i += 1
      }

      var num = 0
      while(i < n && s(i) != '-') {
        num = num * 10 + s(i) - '0'
        i += 1
      }
      val child = new TreeNode1028(num)
      if(level != 0) {
        val parent = map(level - 1)
        if(parent.left == null) parent.left = child
        else parent.right = child
      }
      map.put(level, child)
    }
    map(0)
  }
}
