package com.vc.hard

object L1125 {
  def smallestSufficientTeam(req_skills: Array[String], people: List[List[String]]): Array[Int] = {
    import scala.collection.mutable
    val map = new mutable.HashMap[String, mutable.HashSet[Int]]()

    people.indices.foreach(i => {
      people(i).foreach(skill => {
        val peopleSet = map.getOrElse(skill, new mutable.HashSet[Int]())
        peopleSet += i
        map.put(skill, peopleSet)
      })
    })
    /**
        java    -> 0
        nodeJs  -> 1, 2
        reactJs -> 2
    */
    val minTeam = new mutable.HashSet[Int]()
    val n = req_skills.length
    var minPeople = n + 1
    val team = new mutable.HashSet[Int]()
    def solve(index: Int): Unit = {
      if(team.size > minPeople) return
      if(index == n) {
        if(minPeople > team.size) {
          minPeople = team.size
          minTeam.clear
          minTeam ++= team
        }
      }
      else {
        val peopleList = map(req_skills(index))
        peopleList.foreach(people => {
          val remove = team.add(people)
          solve(index + 1)
          if(remove) team.remove(people)
        })
      }
    }
    solve(0)
    minTeam.toArray
  }
}

