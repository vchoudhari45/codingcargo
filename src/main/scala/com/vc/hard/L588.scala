package com.vc.hard

import scala.collection.mutable
case class Dir(dirs: mutable.HashMap[String, Dir], files: mutable.HashMap[String, String])

class FileSystem() {

  val root = Dir(new mutable.HashMap[String, Dir](), new mutable.HashMap[String, String]())

  def ls(path: String): List[String] = {
    val list = new mutable.ListBuffer[String]()
    var current = root
    val pSplit = path.split("/")
    (1 until pSplit.length).foreach(i => {
      val d = pSplit(i)
      if(current.dirs.contains(d)) {
        current = current.dirs(d)
      }
      else if(current.files.contains(d)) {
        list += d
        return list.toList
      }
      else return list.toList
    })
    current.dirs.foreach(x => list += x._1)
    current.files.foreach(x => list += x._1)
    list.sorted.toList
  }

  def mkdir(path: String) {
    val pSplit = path.split("/")
    var current = root
    (1 until pSplit.length).foreach(i => {
      val d = pSplit(i)
      if(current.dirs.contains(d)) current = current.dirs(d)
      else {
        val dir = new Dir(
          new mutable.HashMap[String, Dir](),
          new mutable.HashMap[String, String]()
        )
        current.dirs.put(d, dir)
        current = current.dirs(d)
      }
    })
  }

  def addContentToFile(filePath: String, content: String) {
    val pSplit = filePath.split("/")
    val file = pSplit(pSplit.length - 1)
    var current = root
    (1 until pSplit.length - 1).foreach(i => {
      val d = pSplit(i)
      if(current.dirs.contains(d)) current = current.dirs(d)
    })
    current.files.put(file, current.files.getOrElse(file, "") + content)
  }

  def readContentFromFile(filePath: String): String = {
    val pSplit = filePath.split("/")
    val file = pSplit(pSplit.length - 1)
    var current = root
    (0 until pSplit.length - 1).foreach(i => {
      val d = pSplit(i)
      if(current.dirs.contains(d)) current = current.dirs(d)
    })
    if(current.files.contains(file)) current.files(file) else ""
  }

}

/**
  * Your FileSystem object will be instantiated and called as such:
  * var obj = new FileSystem()
  * var param_1 = obj.ls(path)
  * obj.mkdir(path)
  * obj.addContentToFile(filePath,content)
  * var param_4 = obj.readContentFromFile(filePath)
  */