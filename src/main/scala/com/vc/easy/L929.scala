package com.vc.easy

object L929 {
  def numUniqueEmails(emails: Array[String]): Int = {
    import scala.collection.mutable
    val set = new mutable.HashSet[String]()

    emails.foreach(email => {
      set += cleanUpEmail(email)
    })
    set.size
  }

  def cleanUpEmail(email: String): String = {
    val splitByAt = email.split('@')
    val splitByPlus = splitByAt(0).split('+')
    splitByPlus(0).replaceAll("\\.", "") + "@" + splitByAt(1)
  }
}
