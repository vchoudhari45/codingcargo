package com.vc.easy

object L733 {
  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
    val dirs = Array(
      (1, 0),
      (0, 1),
      (-1, 0),
      (0, -1)
    )
    import scala.collection.mutable
    val st = new mutable.Stack[(Int, Int)]()
    st.push((sr, sc))
    val oldColor = image(sr)(sc)
    val r = image.length
    val c = image(0).length
    while(st.nonEmpty) {
      val e = st.pop
      if(image(e._1)(e._2) != newColor) {
        image(e._1)(e._2) = newColor
        dirs.foreach(dir => {
          val x = dir._1 + e._1
          val y = dir._2 + e._2
          if(x >= 0 && x < r && y >= 0 && y < c && image(x)(y) == oldColor) {
            st.push((x, y))
          }
        })
      }
    }
    image
  }
}
