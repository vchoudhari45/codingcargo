package com.vc.medium

object L318 {
  def maxProduct(words: Array[String]): Int = {
    var res = 0
    val n = words.length
    val values = new Array[Int](n)
    words.indices.foreach(i => {
      var value = 0
      words(i).indices.foreach(j => {
        value = value | 1 << words(i)(j) - 'a'
      })
      values(i) = value
    })
    words.indices.foreach(i => {
      (i + 1 until n).foreach(j => {
        val len = words(i).length * words(j).length
        if((values(i) & values(j)) == 0 && res < len)
          res = Math.max(res, len)
      })
    })
    res
  }
}
