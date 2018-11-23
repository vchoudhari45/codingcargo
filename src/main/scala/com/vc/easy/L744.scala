package com.vc.easy

object L744 {
  def nextGreatestLetter(letters: Array[Char], target: Char): Char = {
    var lo = 0
    var hi = letters.length - 1
    while(lo <= hi) {
      val mid = lo + (hi - lo) / 2
      if(letters(mid) <= target) lo = mid + 1
      else hi = mid - 1
    }
    //if you don't find greater element return 0th element
    if(lo < letters.length) letters(lo) else letters(0)
  }
}
