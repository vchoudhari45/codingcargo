package com.vc.hard

object L1001 {
  def gridIllumination(N: Int, lamps: Array[Array[Int]], q: Array[Array[Int]]): Array[Int] = {
    import scala.collection.mutable
    val dirs = Array((0, 0), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1), (-1, 0), (-1, 1))

    val n = q.length
    val res = new Array[Int](n)

    val row = new mutable.HashMap[Int, Int]()
    val col = new mutable.HashMap[Int, Int]()
    val diagonal = new mutable.HashMap[Int, Int]()
    val rDiagonal = new mutable.HashMap[Int, Int]()
    val isOn = new mutable.HashMap[Int, Boolean]()

    //illuminate
    lamps.foreach(lamp => {
      val lx = lamp(0)
      val ly = lamp(1)

      row.put(lx, row.getOrElse(lx, 0) + 1)
      col.put(ly, col.getOrElse(ly, 0) + 1)

      diagonal.put(lx + ly, diagonal.getOrElse(lx + ly, 0) + 1)
      rDiagonal.put(lx - ly, rDiagonal.getOrElse(lx - ly, 0) + 1)

      isOn.put(lx * N + ly, true)
    })

    q.indices.foreach(i => {
      val qx = q(i)(0)
      val qy = q(i)(1)

      res(i) = if(row.getOrElse(qx, 0) > 0 || col.getOrElse(qy, 0) > 0 || diagonal.getOrElse(qx + qy, 0) > 0 || rDiagonal.getOrElse(qx - qy, 0) > 0) 1 else 0

      dirs.foreach(dir => {
        val xNew = dir._1 + qx
        val yNew = dir._2 + qy

        if(isOn.getOrElse(xNew * N + yNew, false)) {
          row.put(xNew, row.getOrElse(xNew, 1) - 1)
          col.put(yNew, col.getOrElse(yNew, 1) - 1)

          diagonal.put(xNew + yNew, diagonal.getOrElse(xNew + yNew, 1) - 1)
          rDiagonal.put(xNew - yNew, rDiagonal.getOrElse(xNew - yNew, 1) - 1)

          isOn.put(xNew * N + yNew, false)
        }
      })
    })
    res
  }
}