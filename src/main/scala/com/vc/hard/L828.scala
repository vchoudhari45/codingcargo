package com.vc.hard

object L828 {
  def uniqueLetterString(str: String): Int = {
    val mod = 1000000007

    var res = 0
    val n = str.length

    //Keep track of last two indexes of element
    //ABA
    str.indices.foreach(i => {
      val ch = str(i)

      //search for an element in left direction
      var l = i - 1
      while(l >= 0 && str(l) != ch) l -= 1

      //search for an element in right direction
      var r = i + 1
      while(r < n && str(r) != ch) r += 1

      //here we multiple left length with right length
      //because let's say we have AXAXA -> A(XAX)A
      //Two elements to left right & Two elements to right side
      //Which makes possible substrings as X, XA, AX, XA
      //add length to final output
      res += ((i - l) * (r - i)) % mod
    })
    res
  }
}