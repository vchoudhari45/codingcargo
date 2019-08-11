package com.vc.hard

object L964 {
  def leastOpsExpressTarget(x: Int, target: Int): Int = {
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, Int]()

    def solve(x: Int, target: Int): Int = {
      if(x == 1 && target == 1) return 0
      else if(target == 1) return 1
      else if(map.contains(target)) return map(target)
      else {
        var product = x.toLong
        var count = 0
        while(product < target) {
          product = product * x
          count += 1
        }

        //Target is multiple of x
        if(product.toInt == target) {
          map.put(target, count)
          return count
        }

        //case 1: product - something = target
        //i.e. something = product - target
        //we check product - target < target because we want next target to be less than
        //current target so that we can reach closer to 1 which is our exist condition
        val case1 = if(product - target < target.toLong)
          count + solve(x, (product - target).toInt) + 1
        else
          Int.MaxValue

        //case 2: product + something = target
        //i.e. something = target - product
        //we do product = product / x to make sure we don't have negative value after
        //we do target - product
        product = product / x
        val case2 = solve(x, target - product.toInt) + (if(count == 0) 2 else count)

        count = Math.min(case1, case2)
        map.put(target, count)
        count
      }
    }
    solve(x, target)
  }
}
