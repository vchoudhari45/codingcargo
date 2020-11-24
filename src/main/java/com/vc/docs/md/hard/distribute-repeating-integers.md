[comment]: metadata=Java Solution to problem Distribute Repeating Integers using Backtracking.
[comment]: keywords=Distribute Repeating Integers, Backtracking
[comment]: robots=index, follow


<h1>Distribute Repeating Integers</h1>
<p>
This page explains Java solution to problem <code class="inline">Distribute Repeating Integers</code> using <code class="inline">Backtracking</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
You are given an array of <code class="inline">n</code> integers, <code class="inline">nums</code>, where there are at most <code class="inline">50</code> unique values in the array. You are also given an array of m customer order quantities, <code class="inline">quantity</code>, where <code class="inline">quantity[i]</code> is the amount of integers the ith customer ordered. Determine if it is possible to distribute <code class="inline">nums</code> such that:
</p>
<ul>
<li>The ith customer gets exactly quantity[i] integers,</li>
<li>The integers the ith customer gets are all equal, and</li>
<li>Every customer is satisfied.</li>
</ul>
<p>
Return <code class="inline">true</code> if it is possible to distribute <code class="inline">nums</code> according to the above conditions.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: nums = [1,2,3,4], quantity = [2]<br/>
<b>Output</b>: false<br/>
<b>Explanation</b>: The 0th customer cannot be given two different integers.<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: nums = [1,2,3,3], quantity = [2]<br/>
<b>Output</b>: true<br/>
<b>Explanation</b>: The 0th customer is given [3,3]. The integers [1,2] are not used.<br/>
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: nums = [1,1,2,2], quantity = [2,2]<br/>
<b>Output</b>: true<br/>
<b>Explanation</b>: The 0th customer is given [1,1], and the 1st customer is given [2,2].<br/>
</p>
</blockquote>

<b>Example 4:</b>
<blockquote>
<p>
<b>Input</b>: nums = [1,1,2,3], quantity = [2,2]<br/>
<b>Output</b>: false<br/>
<b>Explanation</b>: Although the 0th customer could be given [1,1], the 1st customer cannot be satisfied.<br/>
</p>
</blockquote>

<b>Example 5:</b>
<blockquote>
<p>
<b>Input</b>: nums = [1,1,1,1,1], quantity = [2,3]<br/>
<b>Output</b>: true<br/>
<b>Explanation</b>: The 0th customer is given [1,1], and the 1st customer is given [1,1,1].<br/>
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
O(M<sup>N</sup>) Where <br />
M is number of customer orders <br />
N is number of values in an array.
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(M) Where <br />
M is number of customer orders <br />
</p>
</blockquote>