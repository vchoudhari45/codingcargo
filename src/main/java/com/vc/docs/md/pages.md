[comment]: metadata=
[comment]: keywords=
[comment]: robots=
<h1>Median of Two Sorted Arrays</h1>
<p>This page explains Java solution to problem <code class="inline">Median of Two Sorted Arrays</code> using Binary Search Algorithm</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given two sorted arrays <code class="inline">A</code> and <code class="inline">B</code> of size <code class="inline">m</code> and <code class="inline">n</code> respectively, return the <a href="https://en.wikipedia.org/wiki/Median" class="absolute" target="_blank" rel="noopener noreferrer">median</a> of the two sorted arrays.
</p>

<p>
<strong>Follow up</strong>: The overall run time complexity should be O(log (m+n)).
</p>

<pre class="language-java">
<code>
class Sample {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length; int n = B.length; if (m > n) return findMedianSortedArrays(B, A); int lo = 0, hi = m; int total = (m + n + 1) / 2;
        while (lo <= hi) {
            int midRight = lo + (hi - lo) / 2;
            int midLeft = total - midRight;
            int leftA = midRight == 0 ? Integer.MIN_VALUE : A[midRight - 1]; int rightA = midRight == m ? Integer.MAX_VALUE : A[midRight]; int leftB = midLeft == 0 ? Integer.MIN_VALUE : B[midLeft - 1]; int rightB = midLeft == n ? Integer.MAX_VALUE : B[midLeft];
            if (leftA > rightB) {
                hi = midRight - 1;
            }
            else if (leftB > rightA) {
                lo = midRight + 1;
            }
            else {
                int maxLeft = Math.max(leftA, leftB);
                int minRight = Math.min(rightA, rightB);
                if ((m + n) % 2 == 1) return maxLeft; // # of left_part = # of right_part + 1;
                else return (maxLeft + minRight) / 2.0;
            }
        }
        return -1;
    }
}
</code>
</pre>


<h2 class="heading">Solution</h2>
<p>Simple solution to this problem </p>


<h2 class="heading">Similar Questions</h2>
<p>This Page explains Java Solution to Problem Median of Two Sorted Arrays using Binary Search Algorithm</p>
