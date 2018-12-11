package com.vc.easy

class StringIterator(str: String) {

  val n = str.length
  var ch = ' '
  var i = 0
  var count = 0

  def next(): Char = {
    if(count == 0) {
      if(i >= n) return ' '
      ch = str(i)
      i += 1
      while(i < n && str(i) >= '0' && str(i) <= '9') {
        count = count * 10 + (str(i) - '0')
        i += 1
      }
    }
    count -= 1
    ch
  }

  def hasNext(): Boolean = i < n || count > 0

}

/**
  * Your StringIterator object will be instantiated and called as such:
  * var obj = new StringIterator(compressedString)
  * var param_1 = obj.next()
  * var param_2 = obj.hasNext()
  */
