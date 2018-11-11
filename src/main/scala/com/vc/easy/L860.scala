package com.vc.easy

object L860 {
  def lemonadeChange(bills: Array[Int]): Boolean = {
    var fives = 0
    var tens = 0
    bills.foreach(bill => {
      if(bill == 5) fives += 1
      else if(bill == 10) {
        fives -= 1
        tens += 1
      }
      else {
        if(tens > 0) {
          tens -= 1
          fives -= 1
        }
        else {
          fives -= 3
        }
      }
      if(fives < 0) return false
    })
    true
  }
}
