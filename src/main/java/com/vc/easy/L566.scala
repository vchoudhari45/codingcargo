package com.vc.easy

object L566 {
  def matrixReshape(nums: Array[Array[Int]], r: Int, c: Int): Array[Array[Int]] = {
    val ro = nums.length
    val co = nums(0).length

    if(ro * co != r * c) return nums

    var i = 0
    var j = 0
    val arr = Array.ofDim[Int](r, c)
    nums.indices.foreach(io => {
      nums(io).indices.foreach(jo => {
        arr(i)(j) = nums(io)(jo)
        j += 1
        if(j == c) {
          j = 0
          i += 1
        }
      })
    })
    arr
  }
}
