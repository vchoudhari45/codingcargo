package com.vc.hard

object L711 {
  def numDistinctIslands2(arr: Array[Array[Int]]): Int = {
    import scala.collection.mutable
    val island = new mutable.HashSet[String]()
    val dirs = Array((0, 1), (1, 0), (0, -1), (-1, 0))
    val coordinates = new mutable.ListBuffer[(Int, Int)]()

    val n = arr.length
    if(n == 0) return 0
    val m = arr(0).length

    def solve(x: Int, y: Int): Unit = {
      if(arr(x)(y) != -1) {
        coordinates += ((x, y))
        arr(x)(y) = -1
        var i = 0
        while(i < dirs.length) {
          val dir = dirs(i)
          val xNew = x + dir._1
          val yNew = y + dir._2
          if(xNew >= 0 && xNew < n && yNew >= 0 && yNew < m && arr(xNew)(yNew) == 1) {
            solve(xNew, yNew)
          }
          i += 1
        }
      }
    }


    object TupleOrdering extends Ordering[(Int, Int)] {
      def compare(x: (Int, Int), y: (Int, Int)): Int = {
        val cmp = x._1.compareTo(y._1)
        if(cmp == 0) x._2.compareTo(y._2) else cmp
      }
    }
    val transform = Array(
      (1, 1),
      (-1, -1),
      (1, -1),
      (-1, 1)
    )
    def translate(list: mutable.ListBuffer[(Int, Int)]) : String = {
      val transformed = new mutable.ArrayBuffer[String]()

      transform.indices.foreach(i => {
        val xTransform = transform(i)._1
        val yTransform = transform(i)._2
        val listTransformed = new mutable.ListBuffer[(Int, Int)]()
        list.foreach(xy => {
          val xNew = xy._1 * xTransform
          val yNew = xy._2 * yTransform
          listTransformed += ((xNew, yNew))
        })
        val arr = listTransformed.toArray
        scala.util.Sorting.quickSort(arr)(TupleOrdering)
        transformed += normalize(arr)
      })

      transform.indices.foreach(i => {
        val xTransform = transform(i)._1
        val yTransform = transform(i)._2
        val listTransformed = new mutable.ListBuffer[(Int, Int)]()
        list.foreach(xy => {
          val xNew = xy._1 * xTransform
          val yNew = xy._2 * yTransform
          listTransformed += ((yNew, xNew))
        })
        val arr = listTransformed.toArray
        scala.util.Sorting.quickSort(arr)(TupleOrdering)
        transformed += normalize(arr)
      })

      val resArr = transformed.toArray
      scala.util.Sorting.quickSort(resArr)
      resArr(0)
    }

    def normalize(list: Array[(Int, Int)]): String = {
      val res = new mutable.StringBuilder
      (1 until list.length).foreach(i => {
        val xy = list(i)
        res.append(s"${xy._1 - list.head._1}:${xy._2 - list.head._2}:")
      })
      res.toString
    }

    /**
            [
                [1,1,0,1,1],
                [1,0,0,0,0],
                [0,0,0,0,1],
                [1,1,0,1,1]
            ]
      */
    arr.indices.foreach(i => {
      arr(i).indices.foreach(j => {
        if(arr(i)(j) == 1) {
          coordinates.clear()
          solve(i, j)
          val key = translate(coordinates)
          island += key
        }
      })
    })
    island.size
  }
}