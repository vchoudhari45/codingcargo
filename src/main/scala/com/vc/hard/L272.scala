package com.vc.hard

class TreeNodeL272(var _value: Int) {
  var value: Int = _value
  var left: TreeNodeL272 = null
  var right: TreeNodeL272 = null
}

object L272 {
  def closestKValues(root: TreeNodeL272, target: Double, k: Int): List[Int] = {
    import scala.collection.mutable
    val st1 = new mutable.Stack[Int]()
    val st2 = new mutable.Stack[Int]()

    def traverse(root: TreeNodeL272, reverse: Boolean, st: mutable.Stack[Int]): Unit = {
      if(root != null) {
        traverse(if(!reverse) root.left else root.right, reverse, st)
        if((reverse && root.value < target) || (!reverse && root.value >= target)) return
        st.push(root.value)
        traverse(if(!reverse) root.right else root.left, reverse, st)
      }
    }

    traverse(root, true, st1)
    traverse(root, false, st2)
    val res = new Array[Int](k)
    var i = 0
    while(i < k) {
      if(st1.nonEmpty && st2.nonEmpty) {
        if(Math.abs(st1.head.toDouble - target) < Math.abs(st2.head.toDouble - target)) {
          res(i) = st1.pop
        }
        else res(i) = st2.pop
      }
      else if(st1.nonEmpty) res(i) = st1.pop
      else if(st2.nonEmpty) res(i) = st2.pop
      i += 1
    }
    res.toList
  }
}