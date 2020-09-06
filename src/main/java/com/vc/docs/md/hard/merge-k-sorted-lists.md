[comment]: metadata=Java Solution to problem <strong>Merge K Sorted Lists</strong> using <strong>Linked List</strong> Data Structure.
[comment]: keywords=Merge K Sorted Lists, Linked List
[comment]: robots=index, follow






<h1>Merge K Sorted Lists</h1>
<p>
This page explains Java solution to problem <code class="inline">Merge K Sorted Lists</code> using <a href="https://www.codingcargo.com/what-is-linked-list" class="absolute" target="_blank" rel="noopener noreferrer">Linked List</a>.
</p>





<h2 class="heading">Problem Statement</h2>
<p>
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order. Merge all the linked-lists into one sorted linked-list and return it.
</p>





<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: lists = [[1,4,5],[1,3,4],[2,6]]<br/>
<b>Output</b>: [1,1,2,3,4,4,5,6]<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: lists = [[]]<br/>
<b>Output</b>: []<br/>
</p>
</blockquote>






<h2 class="heading">Solution</h2>
<p>
A simple solution to this problem will be to combine both arrays <code class="inline">A</code> and <code class="inline">B</code> and take the middle element if the total number of elements is odd or take avg of the middle two elements if the total number of elements is even.
</p>
<p>
With the above approach, our solution will have run time complexity of <code class="inline">O(m + n)</code>, but the expected time complexity is <code class="inline">O(log(m + n))</code>, so we use Binary Search Algorithm.
</p>





<p class="paragraph-heading">
We start by finding middle two-elements <code class="inline">midLeftA</code> and <code class="inline">midRightA</code> from array <code class="inline">A</code> using binary search.
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





<p class="paragraph-heading">
Corresponding to <code class="inline">midLeftA</code> and <code class="inline">midRightA</code> we should pick up two middle elements <code class="inline">midLeftB</code> and <code class="inline">midRightB</code> from array <code class="inline">B</code> such that 
<code class="inline">midLeftA &lt;= midRightB</code> and <code class="inline">midLeftB &lt;= midRightA</code>.
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





<p class="paragraph-heading">
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





<h2 class="heading">Time Complexity</h2>
<p>O(log(m + n))</p>





<h2 class="heading">Space Complexity</h2>
<p>O(1)</p>




<h2 class="heading">Complete Java code</h2>
If you have any suggestions in below code, please create a pull request <a href="####LINK_PLACEHOLDER####" target="_blank" rel="noopener noreferrer" class="absolute">here</a>
<pre>
<code class="language-java">
####CODE_PLACEHOLDER####
</code>
</pre>