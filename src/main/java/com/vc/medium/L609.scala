package com.vc.medium

object L609 {
  /**
    * Input:
    * ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
    *
    * Output:
    * [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
    **/
  def findDuplicate(paths: Array[String]): List[List[String]] = {
    import scala.collection.mutable
    val map = new mutable.HashMap[String, mutable.ListBuffer[String]]()
    paths.foreach(path => {
      val parts = path.split(" ")
      val dir = parts(0)
      (1 until parts.length).foreach(i => {
        val openingBracket = parts(i).indexOf("(")
        val closingBracket = parts(i).indexOf(")")
        val content = parts(i).substring(openingBracket + 1, closingBracket)
        val fileName = parts(i).substring(0, openingBracket)
        val list = map.getOrElse(content, new mutable.ListBuffer[String]())
        list += s"$dir/$fileName"
        map.put(content, list)
      })
    })
    val res = new mutable.ListBuffer[List[String]]()
    map.foreach(kv => if(kv._2.length > 1) res += kv._2.toList)
    res.toList
  }
}
