package com.vc.hard

object L600 {
  def findIntegers(num: Int): Int = {
    import scala.collection.mutable
    val sb = new mutable.StringBuilder(Integer.toBinaryString(num)).reverse

    /**
            Let's say num = 8
            8 can be presented by 4 binary digits as 1000
            X marks all the binary numbers without consecutive ones in below example
            a holds count of numbers with ith digit set to zero
            b holds count of numbers with ith digit set to one
            0  0000  X
            1  0001  X

            2  0010  X
            3  0011

            4  0100  X
            5  0101  X
            6  0110
            7  0111

            8  1000  X
            9  1001  X
            10 1010  X

            11 1011
            12 1100
            13 1101
            14 1110
            15 1111

            so relation is
            a(i) = a(i - 1) + b(i - 1)      <- which means prepend zero in next bit
            b(i) = a(i - 1)                 <- which means prepend one in next bit

            for. e.g.

            a(0) = 0
            b(0) = 1

            a(1) becomes  00, 01 <- prepend zero in 1st bit
            b(1) becomes  10     <- prepend one  in 2nd bit

            a(2) becomes  000, 001, 010 <- prepend zero in 2nd bit
                                           (Since this is 0 bit that we are prepending
                                            and we are looking for numbers with non-consecutive 1 we take both previous a & b)
            b(2) becomes  100, 101      <- prepend one  in 2nd bit
                                           (Since this is 1 bit that we are prepending
                                            and we are looking for numbers with non-consecutive 1 we take only previous a 00 & 01
                                            and prepend 1 to both of them)

            a(3) becomes  0000, 0001, 0010, 0100, 0101
            b(3) becomes  1000, 1001, 1010

            But 1001 & 1010 are 9 & 10 respectively and we are only looking for number which are less than 8
            we have to remove 1001 & 1010 from answer
      */
    val n = sb.length
    val a = new Array[Int](n)
    val b = new Array[Int](n)
    a(0) = 1
    b(0) = 1
    (1 until n).foreach(i => {
      a(i) = a(i - 1) + b(i - 1)
      b(i) = a(i - 1)
    })

    var res = a(n - 1) + b(n - 1)
    (sb.length - 2 to 0 by -1).foreach(i => {
      if(sb(i) == '1' && sb(i + 1) == '1') return res
      if(sb(i) == '0' && sb(i + 1) == '0') {
        res -= b(i)
      }
    })
    res
  }
}
