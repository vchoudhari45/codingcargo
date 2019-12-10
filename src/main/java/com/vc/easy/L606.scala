package com.vc.easy

class TreeNode606(var _value: Int) {
  var value: Int = _value
  var left: TreeNode606 = null
  var right: TreeNode606 = null
}

object L606 {
  def tree2str(t: TreeNode606): String = {
    import scala.collection.mutable
    if(t == null) return ""
    val st = new mutable.Stack[Any]()
    val str = new mutable.StringBuilder()
    st.push(t)
    while(st.nonEmpty) {
      val e = st.pop
      e match {
        case "(" => str.append("(")
        case ")" => str.append(")")
        case treeNode: TreeNode606 => {
          str.append(treeNode.asInstanceOf[TreeNode606].value)
          if(treeNode.right != null) {
            st.push(")")
            st.push(treeNode.right)
            st.push("(")
          }
          if(treeNode.left != null || treeNode.right != null) {
            st.push(")")
            if(treeNode.left != null) st.push(treeNode.left)
            st.push("(")
          }
        }
      }
    }
    str.toString
  }
}
