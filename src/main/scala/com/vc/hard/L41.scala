package com.vc.hard

object L41 {
  def firstMissingPositive(arr: Array[Int]): Int = {
    if(arr.length == 0) return 1
    def swap(k: Int, i: Int): Unit = {
      if(k != i) {
        arr(k) ^= arr(i)
        arr(i) ^= arr(k)
        arr(k) ^= arr(i)
      }
    }
    //Push all the neg numbers to the end of the array
    var k = -1
    arr.indices.foreach(i => {
      if(arr(i) > 0) {
        k += 1
        swap(k, i)
      }
    })

    //Input: [3,4,-1,1]
    //After pushing all neg to end of the array [3,4,1,-1]
    //Now find the first missing number from [3, 4, 1] where k = 2
    var i = 0
    while(i <= k) {
      val index = Math.abs(arr(i)) - 1
      if(index <= k && arr(index) > 0) arr(index) = -1 * arr(index)
      i += 1
    }
    println(arr.mkString(", "))

    i = 0
    var first_index = Math.min(k + 1, arr.length)
    while(i <= k) {
      if(arr(i) > 0) {
        first_index = i
        i = Int.MaxValue - 1
      }
      i += 1
    }
    return first_index + 1
  }
}