package com.vc.easy

import scala.collection.mutable
class MyHashMap() {

  /** Initialize your data structure here. */
  val loadFactor = 0.75
  var initialCapacity = 16
  var size = 0
  var data = new Array[mutable.ListBuffer[(Int, Int)]](initialCapacity)

  /** value will always be non-negative. */
  def put(key: Int, value: Int) {
    if(initialCapacity * loadFactor == size){
      initialCapacity = initialCapacity * 2
      val dataNew = new Array[mutable.ListBuffer[(Int, Int)]](initialCapacity)
      data.foreach(list => {
        if(list != null){
          list.foreach(e => {
            insert(e._1, e._2, dataNew)
          })
        }
      })
      data = dataNew
    }
    insert(key, value, data)
    size += 1
  }

  private def insert(key:Int, value:Int, data:Array[mutable.ListBuffer[(Int, Int)]]): Unit = {
    val index = key.hashCode() % initialCapacity
    if(data(index) == null){
      val list = new mutable.ListBuffer[(Int, Int)]()
      list += ((key, value))
      data(index) = list
    }
    else{
      val list = data(index)
      var toBeRemoved = -1
      list.indices.foreach(i => {
        if(list(i)._1 == key){
          toBeRemoved = i
        }
      })
      if(toBeRemoved != -1) list.remove(toBeRemoved)
      data(index) += ((key, value))
    }
  }

  /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
  def get(key: Int): Int = {
    val index = key.hashCode() % initialCapacity
    val list = data(index)
    if(list != null){
      list.foreach(ele => if(ele._1 == key) return ele._2)
    }
    -1
  }

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  def remove(key: Int) {
    val index = key.hashCode() % initialCapacity
    val list = data(index)
    if(list != null){
      list.indices.foreach(i => if(list(i)._1 == key) {
        list.remove(i)
        return
      })
    }
  }

}

/**
  * Your MyHashMap object will be instantiated and called as such:
  * var obj = new MyHashMap()
  * obj.put(key,value)
  * var param_2 = obj.get(key)
  * obj.remove(key)
  */
