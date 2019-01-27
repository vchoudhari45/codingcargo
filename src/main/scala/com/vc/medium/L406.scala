package com.vc.medium


object L406 {
  object PeopleSorting extends Ordering[Array[Int]] {
    def compare(x: Array[Int], y: Array[Int]): Int = {
      val cmp = y(0).compareTo(x(0))
      if(cmp == 0) x(1).compareTo(y(1)) else cmp
    }
  }
  def reconstructQueue(people: Array[Array[Int]]): Array[Array[Int]] = {
    scala.util.Sorting.quickSort(people)(PeopleSorting)
    people.indices.foreach(i => {
      val desiredIndex = people(i)(1)
      move(desiredIndex, i)
    })
    def move(desiredIndex: Int, currentIndex: Int): Unit = {
      val e = people(currentIndex)
      (currentIndex until desiredIndex by - 1).foreach(i => {
        people(i) = people(i - 1)
      })
      people(desiredIndex) = e
    }
    people
  }
}