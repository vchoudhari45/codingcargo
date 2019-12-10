package com.vc.hard

object L899 {
  def orderlyQueue(S: String, K: Int): String = {
    if(K > 1) return S.sorted
    else {
      var sOld = S
      (0 until S.length).foreach(i => {
        val sNew = S.substring(i) + S.substring(0, i)
        sOld = if(sNew > sOld) sOld else sNew
      })
      sOld
    }
  }
}