[comment]: metadata=Java Solution to problem Burst Balloons using Dynamic Programming algorithm.
[comment]: keywords=Burst Balloons, Dynamic Programming algorithm.
[comment]: robots=index, follow


<h1>Burst Balloons</h1>
<p>
This page explains Java solution to problem <code class="inline">Burst Balloons</code> using <code class="inline">Dynamic Programming</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given <code class="inline">n</code> balloons, indexed from <code class="inline">0</code> to <code class="inline">n-1</code>. Each balloon is painted with a number on it represented by array <code class="inline">nums</code>. You are asked to burst all the balloons. If the you burst balloon <code class="inline">i</code> you will get <code class="inline">nums[left] * nums[i] * nums[right]</code>> coins. Here <code class="inline">left</code> and <code class="inline">right</code> are adjacent indices of <code class="inline">i</code>. After the burst, the <code class="inline">left</code> and <code class="inline">right</code> then becomes adjacent.
</p>
<p>
Find the maximum coins you can collect by bursting the balloons wisely.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: [3,1,5,8]<br/>
<b>Output</b>:  167 <br/>
<b>Explanation</b>: <br />
nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> [] <br />
coins =  3*1*5    +   3*5*8    +  1*3*8      + 1*8*1   = 167
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
O(N<sup>3</sup>) Where <br />
N is total number of elements in an input array.
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N<sup>2</sup>)
</p>
</blockquote>