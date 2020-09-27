[comment]: metadata=Java Solution to problem Find Median from Data Stream using Priority Queue Data Structure.
[comment]: keywords=Find Median from Data Stream, Priority Queue Data Structure
[comment]: robots=index, follow


<h1>Find Median from Data Stream</h1>
<p>
This page explains Java solution to problem <code class="inline">Find Median from Data Stream</code> using <code class="inline">Priority Queue</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
</p>
<p>
For example, <br /> 
<code class="inline">[2,3,4]</code>, the median is <code class="inline">3</code> <br />
<code class="inline">[2,3]</code>, the median is <code class="inline">(2 + 3) / 2 = 2.5</code>
</p>
<p>
Design a data structure that supports the following two operations:
</p>
<ul>
<li>1. <code class="inline">void addNum(int num)</code> - Add a integer number from the data stream to the data structure.</li>
<li>2. <code class="inline">double findMedian()</code> - Return the median of all elements so far.</li>
</ul>

<b>Example 1:</b>
<blockquote>
<p>
addNum(1) <br />
addNum(2) <br />
findMedian() -> 1.5 <br />
addNum(3) <br />
findMedian() -> 2 <br />
</p>
</blockquote>


<h2 class="heading">Solution</h2>
If you have any suggestions in below code, please <a href="####LINK_PLACEHOLDER####" target="_blank" rel="noopener noreferrer" class="absolute">create a pull request by clicking here</a>.
<pre>
<code class="language-java">
####CODE_PLACEHOLDER####
</code>
</pre>


<h2 class="heading">Time Complexity</h2>
<blockquote>
<p>
O(N * logN) Where <br />
N is total number of elements seen so far
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is total number of elements seen so far
</p>
</blockquote>