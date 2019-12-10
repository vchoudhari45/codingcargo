package com.vc.easy


class TreeNode100(var _value: Int) {
  var value: Int = _value
  var left: TreeNode100 = null
  var right: TreeNode100 = null
}

object L100 {
  def isSameTree(p: TreeNode100, q: TreeNode100): Boolean = {
    //(p ==null && q == null) || (p != null && q != null && p.value == q.value && isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
    import scala.collection.mutable
    val st = new mutable.Stack[TreeNode100]()
    st.push(p)
    st.push(q)
    while(st.nonEmpty) {
      val qe = st.pop
      val pe = st.pop
      if((pe == null && qe == null) || (pe != null && qe != null && pe.value == qe.value)) {
        if(pe != null && qe != null) {
          st.push(pe.right)
          st.push(qe.right)
          st.push(pe.left)
          st.push(qe.left)
        }
      }
      else return false
    }
    true
  }
}
