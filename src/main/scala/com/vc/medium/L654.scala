package com.vc.medium


class TreeNode654(var _value: Int) {
  var value: Int = _value
  var left: TreeNode654 = null
  var right: TreeNode654 = null
}

object L654 {
  def constructMaximumBinaryTree(nums: Array[Int]): TreeNode654 = {
    if(nums.length > 0) {
      val maxIdx = getMaxIdx(nums)
      val root = new TreeNode654(nums(maxIdx))
      root.left = constructMaximumBinaryTree(nums.slice(0, maxIdx))
      root.right = constructMaximumBinaryTree(nums.slice(maxIdx + 1, nums.length))
      return root
    }
    null
  }

  def getMaxIdx(nums: Array[Int]): Int = {
    var max = Int.MinValue
    var maxIdx = -1
    nums.indices.foreach(i => {
      if(nums(i) > max) {
        max = nums(i)
        maxIdx = i
      }
    })
    maxIdx
  }

}