package com.vc.easy

import com.vc.hard.TreeNode

/**
  *     1
  *   2   3
  *     4
  **/
object TreeTraversal {
  import scala.collection.mutable

  def main(args: Array[String]): Unit = {
    val root = new TreeNode(1)
    val left = new TreeNode(2)
    left.right = new TreeNode(4)
    root.left = left
    root.right = new TreeNode(3)

    inOrder(root)
    println("=========")
    preOrder(root)
    println("=========")
    postOrder(root)
    println("=========")
  }

  def inOrder(root: TreeNode): Unit = {
    val st = new mutable.Stack[TreeNode]()
    var current = root
    while(current != null || st.nonEmpty) {
      if(current != null) {
        st.push(current)
        current = current.left
      }
      else {
        current = st.pop
        println(current.`val`)
        current = current.right
      }
    }
  }

  def preOrder(root: TreeNode): Unit = {
    val st = new mutable.Stack[TreeNode]()
    var current = root
    while(current != null || st.nonEmpty) {
      if(current != null) {
        println(current.`val`)
        st.push(current)
        current = current.left
      }
      else current = st.pop.right
    }
  }

  def postOrder(root: TreeNode): Unit = {
    val st = new mutable.Stack[TreeNode]()
    var current = root
    while(current != null || st.nonEmpty) {
      if(current != null) {
        st.push(current)
        current = current.left
      }
      else {
        var tmp = st.head.right
        if(tmp == null) {
          do {
            tmp = st.pop
            println(tmp.`val`)
          } while(st.nonEmpty && tmp == st.head.right)
        }
        else current = tmp
      }
    }
  }
}
