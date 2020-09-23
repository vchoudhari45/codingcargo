[comment]: metadata=Java Solution to problem Sliding Window Maximum using TreeMap Data Structure
[comment]: keywords=Sliding Window Maximum, TreeMap Data Structure
[comment]: robots=index, follow


<h1>Sliding Window Maximum</h1>
<p>
This page explains Java solution to problem <code class="inline">Sliding Window Maximum</code> using <code class="inline">TreeMap</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
You are given an array of integers <code class="inline">nums</code>, there is a sliding window of size <code class="inline">k</code> which is moving from the very left of the array to the very right. You can only see the <code class="inline">k</code> numbers in the window. Each time the sliding window moves right by one position.
</p>
<p>Return the max sliding window.</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: nums = [1,3,-1,-3,5,3,6,7], k = 3<br/>
<b>Output</b>: [3,3,5,5,6,7]<br />
<b>Explanation</b>: <br />
Window position&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Max   <br /> 
[1  3  -1] -3  5  3  6  7&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       3    <br />   
 1 [3  -1  -3] 5  3  6  7&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       3    <br />    
 1  3 [-1  -3  5] 3  6  7&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       5    <br />
 1  3  -1 [-3  5  3] 6  7&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       5    <br />
 1  3  -1  -3 [5  3  6] 7&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       6    <br />
 1  3  -1  -3  5 [3  6  7]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      7    <br />
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
O(N * log(K)) Where <br />
N is total number of elements in an input array<br />
K is Window size.
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is total number of elements in an input array
</p>
</blockquote>