[comment]: metadata=Java Solution to problem <strong>Trapping Rain Water</strong> using <strong>Array</strong> Data Structure.
[comment]: keywords=Trapping Rain Water, Array
[comment]: robots=index, follow






<h1>Trapping Rain Water</h1>
<p>
This page explains Java solution to problem <code class="inline">Trapping Rain Water</code> using <a href="####BASEURL####what-is-priority-queue" class="absolute" target="_blank" rel="noopener noreferrer">Array</a>.
</p>





<h2 class="heading">Problem Statement</h2>
<p>
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
</p>





<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: [0,1,0,2,1,0,1,3,2,1,2,1]<br />
<b>Output</b>: 6<br/>
</p>
</blockquote>





<h2 class="heading">Solution</h2>
<p>
Problem is fairly simple only thing to understand here is, amount of water that will be trapped is minimum of bar size from both side.
</p>
<img src="####BASEURL####trapping-rain-water/trap-1.png" alt="Trapping Rain Water 1" />


<p class="paragraph-heading">
So Let's start by iterating over input array with two pointer <code class="inline">left</code> and <code class="inline">right</code>.
</p>
<pre>
<code class="language-java">
while(left &lt;= right) {
    if(arr[left] &lt;= arr[right]) {
        if(maxLeft &lt; arr[left]) maxLeft = arr[left];
        else res += maxLeft - arr[left];
        left++;
    }
    else {
        if(maxRight &lt; arr[right]) maxRight = arr[right];
        else res += maxRight - arr[right];
        right--;
    }
}
</code>
</pre>





<h2 class="heading">Time Complexity</h2>
<blockquote>
<p>
O(N) <br />
Where N is total number of elements in an input array
</p>
</blockquote>




<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(1)
</p>
</blockquote>




<h2 class="heading">Complete Java code</h2>
If you have any suggestions in below code, please create a pull request <a href="####LINK_PLACEHOLDER####" target="_blank" rel="noopener noreferrer" class="absolute">here</a>
<pre>
<code class="language-java">
####CODE_PLACEHOLDER####
</code>
</pre>