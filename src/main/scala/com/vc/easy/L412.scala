package com.vc.easy

object L412 {
  def fizzBuzz(n: Int): List[String] = {
    import scala.collection.mutable
    val list = new mutable.ListBuffer[String]()
    var three = 3
    var five = 5
    var i = 1
    while(i <= n) {
      if(three == i && five == i) {
        list += "FizzBuzz"
        three += 3
        five += 5
      }
      else if(three == i) {
        list += "Fizz"
        three += 3
      }
      else if(five == i) {
        list += "Buzz"
        five += 5
      }
      else {
        list += i.toString
      }
      i += 1
    }
    list.toList
  }
}
