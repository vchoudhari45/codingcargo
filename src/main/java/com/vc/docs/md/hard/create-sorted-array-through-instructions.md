[comment]: metadata=Java Solution to problem Create Sorted Array through Instructions using Binary Indexed Tree.
[comment]: keywords=Create Sorted Array through Instructions, Binary Indexed Tree
[comment]: robots=index, follow


<h1>Create Sorted Array through Instructions</h1>
<p>
This page explains Java solution to problem <code class="inline">Create Sorted Array through Instructions</code> using <code class="inline">Binary Indexed Tree</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given an integer array instructions, you are asked to create a sorted array from the elements in instructions. You start with an empty container <code class="inline">nums</code>. For each element from left to right in instructions, insert it into <code class="inline">nums</code>. The cost of each insertion is the minimum of the following:
</p>
<ul>
<li>The number of elements currently in <code class="inline">nums</code> that are strictly less than <code class="inline">instructions[i]</code>.</li>
<li>The number of elements currently in <code class="inline">nums</code> that are strictly greater than <code class="inline">instructions[i]</code>.</li>
</ul>
<p>
For example, if inserting element <code class="inline">3</code> into <code class="inline">nums = [1,2,3,5]</code>, the cost of insertion is <code class="inline">min(2, 1)</code> (elements <code class="inline">1</code> and <code class="inline">2</code> are less than <code class="inline">3</code>, element <code class="inline">5</code> is greater than <code class="inline">3</code>) and <code class="inline">nums</code> will become <code class="inline">[1,2,3,3,5]</code>.
</p>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: instructions = [1,5,6,2]<br/>
<b>Output</b>: 1<br/>
<b>Explanation</b>: Begin with nums = [].<br/>
Insert 1 with cost min(0, 0) = 0, now nums = [1]. <br />
Insert 5 with cost min(1, 0) = 0, now nums = [1,5]. <br />
Insert 6 with cost min(2, 0) = 0, now nums = [1,5,6]. <br />
Insert 2 with cost min(1, 2) = 1, now nums = [1,2,5,6]. <br />
The total cost is 0 + 0 + 0 + 1 = 1.
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: instructions = [1,2,3,6,5,4]<br/>
<b>Output</b>: 3<br/>
<b>Explanation</b>: Begin with nums = [].<br/>
Insert 1 with cost min(0, 0) = 0, now nums = [1].<br />
Insert 2 with cost min(1, 0) = 0, now nums = [1,2].<br />
Insert 3 with cost min(2, 0) = 0, now nums = [1,2,3].<br />
Insert 6 with cost min(3, 0) = 0, now nums = [1,2,3,6].<br />
Insert 5 with cost min(3, 1) = 1, now nums = [1,2,3,5,6].<br />
Insert 4 with cost min(3, 2) = 2, now nums = [1,2,3,4,5,6].<br />
The total cost is 0 + 0 + 0 + 0 + 1 + 2 = 3.
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: instructions = [1,3,3,3,2,4,2,1,2]<br/>
<b>Output</b>: 4<br/>
<b>Explanation</b>: Begin with nums = [].<br/>
Insert 1 with cost min(0, 0) = 0, now nums = [1].<br />
Insert 3 with cost min(1, 0) = 0, now nums = [1,3].<br />
Insert 3 with cost min(1, 0) = 0, now nums = [1,3,3].<br />
Insert 3 with cost min(1, 0) = 0, now nums = [1,3,3,3].<br />
Insert 2 with cost min(1, 3) = 1, now nums = [1,2,3,3,3].<br />
Insert 4 with cost min(5, 0) = 0, now nums = [1,2,3,3,3,4].<br />
​​​​​​​Insert 2 with cost min(1, 4) = 1, now nums = [1,2,2,3,3,3,4].<br />
​​​​​​​Insert 1 with cost min(0, 6) = 0, now nums = [1,1,2,2,3,3,3,4].<br />
​​​​​​​Insert 2 with cost min(2, 4) = 2, now nums = [1,1,2,2,2,3,3,3,4].<br />
The total cost is 0 + 0 + 0 + 0 + 1 + 0 + 1 + 0 + 2 = 4.
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
O(N log M) Where <br />
N is total number of instructions in an input array <br/>
M is maximum value in an instructions input array, in our case it is 1e<sup>5</sup> + 1
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(M) Where <br />
M is maximum value in an instructions input array, in our case it is 1e<sup>5</sup> + 1
</p>
</blockquote>