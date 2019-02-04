package com.vc.medium


class TreeNode889(var _value: Int) {
  var value: Int = _value
  var left: TreeNode889 = null
  var right: TreeNode889 = null
}

object L889 {
  def constructFromPrePost(pre: Array[Int], post: Array[Int]): TreeNode889 = {
    /**
      *          1
      *       2     3
      *     4  5  6  7
      *
      *   //Pre : 1 2 4 5 3 6 7
      *   //Post: 4 5 2 6 7 3 1
      **/
      def solve(preStart: Int, preEnd: Int, postStart: Int, postEnd: Int): TreeNode889 = {
        if(preStart > preEnd || postStart > postEnd) return null
        val tree = new TreeNode889(pre(preStart))
        if(preStart == preEnd) return tree
        var index = postStart
        var found = false
        while(!found && index < postEnd) {
          if(pre(preStart + 1) == post(index)) found = true
          else index += 1
        }
        if(!found) return tree
        tree.left = solve(preStart + 1, preStart + 1 + index - postStart, postStart, index)
        tree.right = solve(preStart + 1 + index - postStart + 1, preEnd, index + 1, postEnd)
        tree
      }
      solve(0, pre.length - 1, 0, post.length - 1)
  }
}

