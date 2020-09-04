[comment]: metadata=Java Solution to problem <strong>Median of Two Sorted Arrays</strong> using <strong>Binary Search</strong> Algorithm.
[comment]: keywords=Median of Two Sorted Arrays, Binary Search
[comment]: robots=index, follow







<h1>Median of Two Sorted Arrays</h1>
<p>
This page explains Java solution to problem <code class="inline">Median of Two Sorted Arrays</code> using <a href="https://www.codingcargo.com/what-is-binary-search" class="absolute" target="_blank" rel="noopener noreferrer">Binary Search</a> Algorithm.
</p>







<h2 class="heading">Problem Statement</h2>
<p>
Given two sorted arrays <code class="inline">A</code> and <code class="inline">B</code> of size <code class="inline">m</code> and <code class="inline">n</code> respectively, return the <a href="https://en.wikipedia.org/wiki/Median" class="absolute" target="_blank" rel="noopener noreferrer">median</a> of the two sorted arrays.
</p>

<p>
<strong>Follow up</strong>: The overall run time complexity should be <code class="inline">O(log (m+n))</code>.
</p>

<h4 class="heading">Example 1</h4>
<blockquote>
Input: nums1 = [1,3], nums2 = [2]<br/>
Output: 2.00000<br/>
Explanation: merged array = [1,2,3] and median is 2<br/>
</blockquote>

<h4 class="heading">Example 2:</h4>
<blockquote>
Input: nums1 = [1,2], nums2 = [3,4]<br/>
Output: 2.50000<br/>
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5<br/>
</blockquote>

<h4 class="heading">Example 3:</h4>
<blockquote>
Input: nums1 = [0,0], nums2 = [0,0]<br/>
Output: 0.00000<br/>
</blockquote>

<h4 class="heading">Example 4:</h4>
<blockquote>
Input: nums1 = [], nums2 = [1]<br/>
Output: 1.00000<br/>
</blockquote>

<h4 class="heading">Example 5:</h4>
<blockquote>
Input: nums1 = [2], nums2 = []<br/>
Output: 2.00000<br/>
</blockquote>







<h2 class="heading">Solution</h2>
<p>
Simple solution to this problem will be to combine both arrays <code class="inline">A</code> and <code class="inline">B</code> and take middle element if total number of elements are odd or take avg of middle two elements if total number of elements are even.
</p>
<p>
With above approach our solution will have run time complexity of <code class="inline">O(m + n)</code>, but expected time complexity is <code class="inline">O(log(m + n))</code>, so we use Binary Search Algorithm.
</p>

<p>
We should start by finding middle two element <code class="inline">midLeftA</code> and <code class="inline">midRightA</code> from array <code class="inline">A</code> using binary search
</p>
<pre>
<code class="language-java">
int lo = 0;
int hi = m;
/**
    We do + 1 to total length so that we get extra element on the left hand side 
    And we can return mid in case total number of elements are odd
*/
int halfOfTotalElements = (m + n + 1) / 2;
while(lo &lt;= hi) {
    int midLeft = lo + (hi - lo) / 2;
    int midLeftA = midLeft == 0 ? Integer.MIN_VALUE : A[midLeft - 1];
    int midRightA = midLeft == m ? Integer.MAX_VALUE : A[midLeft];
}
</code>
</pre>

<br />
<br />
<p>
Corresponding to <code class="inline">midLeftA</code> and <code class="inline">midRightA</code> we should pick up two middle elements <code class="inline">midLeftB</code> and <code class="inline">midRightB</code> from array <code class="inline">B</code> such that 
<code class="inline">midLeftA &lt;= midRightB</code> and <code class="inline">midLeftB &lt;= midRightA</code>
</p>
<pre>
<code class="language-java">
while(lo &lt;= hi) {
    int midLeft = lo + (hi - lo) / 2;
    int midLeftA = midLeft == 0 ? Integer.MIN_VALUE : A[midLeft - 1];
    int midRightA = midLeft == m ? Integer.MAX_VALUE : A[midLeft];<br />    
    int midRight = halfOfTotalElements - midLeft;
    int midLeftB = midRight == 0 ? Integer.MIN_VALUE : B[midRight - 1];
    int midRightB = midRight == n ? Integer.MAX_VALUE : B[midRight];
}
</code>
</pre>

<br />
<br />
<p>
Continue the Binary Search until we have <code class="inline">midLeftA &lt;= midRightB && midLeftB &lt;= midRightA</code> and once we have four such numbers calculate median based on the total length of both arrays
</p>
<pre>
<code class="language-java">
if(midLeftA &gt; midRightB) {
    hi = midLeft - 1;
}
else if(midLeftB > midRightA) {
    lo = midLeft + 1;
}
else {
    midLeft = Math.max(midLeftA, midLeftB);
    midRight = Math.min(midRightA, midRightB);
    if((m + n) % 2 == 0) return (midLeft + midRight) / 2.0;
    else return midLeft;
}
</code>
</pre>







<h2 class="heading">Complete Java Code</h2>
<pre>
<code class="language-java">
####CODE_PLACEHOLDER####
</code>
</pre>