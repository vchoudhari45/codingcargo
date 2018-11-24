package com.vc.easy


class TreeNode270(var _value: Int) {
  var value: Int = _value
  var left: TreeNode270 = null
  var right: TreeNode270 = null
}

object L270 {
  def closestValue(root: TreeNode270, target: Double): Int = {
    var current = root
    var minDistance = Double.MaxValue
    var distance = 0.toDouble
    var res = 0
    while(current != null) {
      distance = Math.abs(current.value.toDouble - target)
      if(distance < minDistance) {
        minDistance = distance
        res = current.value
      }
      if(current.value > target) {
        current = current.left
      }
      else if(current.value < target) {
        current = current.right
      }
      else return current.value
    }
    res
  }
}
