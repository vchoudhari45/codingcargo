package com.vc.medium

class L384(arr: Array[Int]) {

  val random = scala.util.Random

  /** Resets the array to its original configuration and return it. */
  def reset(): Array[Int] = arr

  /** Returns a random shuffling of the array. */
  def shuffle(): Array[Int] = {
    val arrClone = arr.clone
    def swap(i: Int, j: Int): Unit = {
      val tmp = arrClone(i)
      arrClone(i) = arrClone(j)
      arrClone(j) = tmp
    }
    arrClone.indices.foreach(i => {
      val j = random.nextInt(i + 1)
      swap(i, j)
    })
    arrClone
  }

}

/**
  * Your Solution object will be instantiated and called as such:
  * var obj = new Solution(nums)
  * var param_1 = obj.reset()
  * var param_2 = obj.shuffle()
  */
