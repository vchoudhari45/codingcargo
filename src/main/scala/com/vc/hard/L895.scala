package com.vc.hard

class FreqStack() {

  import scala.collection.mutable
  var maxFreq = 0
  val freqMap = new java.util.TreeMap[Int, mutable.Stack[Int]]
  val elementMap = new mutable.HashMap[Int, Int]()

  def push(x: Int) {
    elementMap.put(x, elementMap.getOrElse(x, 0) + 1)
    val freq = elementMap(x)
    maxFreq = Math.max(maxFreq, freq)
    if(!freqMap.containsKey(freq)) {
      freqMap.put(freq, new mutable.Stack[Int]())
    }
    freqMap.get(freq).push(x)
  }

  def pop(): Int = {
    val e = freqMap.get(maxFreq).pop
    elementMap.put(e, elementMap(e) - 1)
    if(freqMap.get(maxFreq).isEmpty) maxFreq -= 1
    e
  }

}

/**
  * Your FreqStack object will be instantiated and called as such:
  * var obj = new FreqStack()
  * obj.push(x)
  * var param_2 = obj.pop()
  */