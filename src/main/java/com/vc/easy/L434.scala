package com.vc.easy

object L434 {
  def countSegments(s: String): Int = {
    if(s.trim == "") 0 else s.trim.split(" +").length
  }
}
