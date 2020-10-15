[comment]: metadata=Java Solution to problem Sliding Window Median using TreeSet Data Structure.
[comment]: keywords=Median of Two Sorted Arrays, TreeSet Data Structure
[comment]: robots=index, follow


<h1>Sliding Window Median</h1>
<p>
This page explains Java solution to problem <code class="inline">Sliding Window Median</code> using <code class="inline">TreeSet</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
</p>
<p>
Examples: <br />
<code class="inline">[2,3,4]</code>, the median is <code class="inline">3</code> <br />
<code class="inline">[2,3]</code>, the median is <code class="inline">(2 + 3) / 2 = 2.5</code><br />
</p>
<p>
Given an array <code class="inline">nums</code>, there is a sliding window of size <code class="inline">k</code> which is moving from the very left of the array to the very right. You can only see the <code class="inline">k</code> numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: nums = [1,3,-1,-3,5,3,6,7], and k = 3<br/>
<b>Output</b>: [1,-1,-1,3,5,6]<br/>
<b>Explanation</b>: <br/>
Window position          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      Median<br />
[1  3  -1] -3  5  3  6  7&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       1 <br />
 1 [3  -1  -3] 5  3  6  7&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;            -1<br />
 1  3 [-1  -3  5] 3  6  7&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;            -1<br />
 1  3  -1 [-3  5  3] 6  7&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       3<br />
 1  3  -1  -3 [5  3  6] 7&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       5<br />
 1  3  -1  -3  5 [3  6  7]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      6<br />
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
O(N * log K) Where <br />
N is total number of elements in an input array <br />
K is size of sliding window
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is total number of elements int an input array
</p>
</blockquote>