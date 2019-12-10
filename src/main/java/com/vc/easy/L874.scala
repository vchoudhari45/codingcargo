package com.vc.easy

object L874 {
  def robotSim(commands: Array[Int], obstacles: Array[Array[Int]]): Int = {
    /**
      *    0
      *  3   1
      *    2
      **/
    val dir = Array((0, 1), (1, 0), (0, -1), (-1, 0))
    var direction = 0
    var max = 0

    import scala.collection.mutable
    val set = new mutable.HashSet[String]()
    obstacles.foreach(o => {
      set += (o(0) + " " + o(1))
    })

    var x = 0
    var y = 0
    commands.foreach(c => {
      if(c == -1) {
        direction = direction + 1
        if(direction == 4) direction = 0
      }
      else if(c == -2) {
        direction = direction - 1
        if(direction == -1) direction = 3
      }
      else {
        var cVar = c
        while(cVar > 0 && !set.contains((x + dir(direction)._1) + " " + (y + dir(direction)._2))) {
          x += dir(direction)._1
          y += dir(direction)._2
          cVar -= 1
        }
      }
      max = Math.max(max, x * x + y * y)
    })
    max
  }
}
