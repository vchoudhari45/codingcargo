package com.vc.medium

object L638 {
  def shoppingOffers(price: List[Int], special: List[List[Int]], needs: List[Int]): Int = {
    def directPrice(needs: List[Int]): Int = {
      var res = 0
      needs.indices.foreach(i => {
        res += price(i) * needs(i)
      })
      res
    }
    def calcNewNeeds(offer:List[Int], needs: List[Int]): List[Int] = {
      val newNeeds = new Array[Int](needs.length)
      needs.indices.foreach(i => {
        if(offer(i) > needs(i)) {
          return null
        }
        newNeeds(i) = needs(i) - offer(i)
      })
      newNeeds.toList
    }
    val n = special.length
    def solve(needs: List[Int], specialOfferIndex: Int): Int = {
      var totalPrice = directPrice(needs)
      (specialOfferIndex until n).foreach(i => {
        val offer = special(i)
        val newNeeds = calcNewNeeds(offer, needs)
        if(newNeeds != null) { // that means offer applies
          totalPrice = Math.min(totalPrice, offer.last + solve(newNeeds, i))
        }
      })
      totalPrice
    }
    solve(needs, 0)
  }
}
