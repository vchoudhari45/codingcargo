package com.vc.easy

import scala.collection.mutable

class MyHashSet() {

  /** Initialize your data structure here. */
  var initialSize = 16
  var loadFactor = 0.75
  var size = 0
  var data = new Array[mutable.ListBuffer[Int]](initialSize)

  def add(key: Int): Unit = {
    if(size == loadFactor * initialSize) {
      initialSize = initialSize * 2
      val dataNew = new Array[mutable.ListBuffer[Int]](initialSize)
      data.filter(_ != null ).foreach(list => {
        list.foreach(x => insert(dataNew, x))
      })
      data = dataNew
    }
    insert(data, key)
    size += 1
  }

  private def insert(data: Array[mutable.ListBuffer[Int]], key: Int): Unit = {
    val idx = key.hashCode % initialSize
    if(data(idx) == null) {
      val list = new mutable.ListBuffer[Int]()
      list += key
      data(idx) = list
    }
    else {
      val list = data(idx)
      if(!list.contains(key)) list += key
    }
  }

  def remove(key: Int): Unit = {
    val idx = key.hashCode % initialSize
    if(data(idx) != null) {
      val list = data(idx)
      val idxToRemove = list.indexOf(key)
      if(idxToRemove != -1) {
        list.remove(idxToRemove)
        size -= 1
      }
    }
  }

  /** Returns true if this set contains the specified element */
  def contains(key: Int): Boolean = {
    val idx = key.hashCode % initialSize
    if(data(idx) != null) {
      val list = data(idx)
      return list.contains(key)
    }
    false
  }

}

/**
  * Your MyHashSet object will be instantiated and called as such:
  * var obj = new MyHashSet()
  * obj.add(key)
  * obj.remove(key)
  * var param_3 = obj.contains(key)
  */
