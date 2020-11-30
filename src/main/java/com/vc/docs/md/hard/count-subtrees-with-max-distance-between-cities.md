[comment]: metadata=Java Solution to problem Count Subtrees With Max Distance Between Cities using Floyd Warshall Algorithm
[comment]: keywords=Count Subtrees With Max Distance Between Cities, Floyd Warshall Algorithm, Graph Data Structure
[comment]: robots=index, follow


<h1>Count Subtrees With Max Distance Between Cities</h1>
<p>
This page explains Java solution to problem <code class="inline">Count Subtrees With Max Distance Between Cities</code> using <code class="inline">Floyd Warshall</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
There are <code class="inline">n</code> cities numbered from <code class="inline">1</code> to <code class="inline">n</code>. You are given an array edges of size <code class="inline">n-1</code>, where <code class="inline">edges[i] = [ui, vi]</code> represents a bidirectional edge between cities <code class="inline">ui</code> and <code class="inline">vi</code>. There exists a unique path between each pair of cities. In other words, the cities form a tree.
</p>
<p>
A subtree is a subset of cities where every city is reachable from every other city in the subset, where the path between each pair passes through only the cities from the subset. Two subtrees are different if there is a city in one subtree that is not present in the other.
</p>
<p>
For each <code class="inline">d</code> from <code class="inline">1</code> to <code class="inline">n - 1</code>, find the number of subtrees in which the maximum distance between any two cities in the subtree is equal to <code class="inline">d</code>.
</p>
<p>
Return an array of size <code class="inline">n - 1</code> where the <code class="inline">d<sup>th</sup></code> element <code class="inline">(1-indexed)</code> is the number of subtrees in which the maximum distance between any two cities is equal to <code class="inline">d</code>.
</p>
<p>
Notice that the distance between the two cities is the number of edges in the path between them.
</p>

<p>
Constraints:
</p>
<ul>
<li><code class="inline">2 <= n <= 15</code></li>
<li><code class="inline">edges.length == n - 1</code></li>
<li><code class="inline">edges[i].length == 2</code></li>
<li><code class="inline">1 <= ui, vi <= n</code></li>
<li>All pairs <code class="inline">(ui, vi)</code> are distinct.</li>
</ul>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: n = 4, edges = [[1,2],[2,3],[2,4]]<br/>
<b>Output</b>: [3,4,0]<br/>
<b>Explanation</b>: The subtrees with subsets {1,2}, {2,3} and {2,4} have a max distance of 1. <br />
The subtrees with subsets {1,2,3}, {1,2,4}, {2,3,4} and {1,2,3,4} have a max distance of 2. <br />
No subtree has two nodes where the max distance between them is 3.
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: n = 2, edges = [[1,2]]<br/>
<b>Output</b>: [1]<br/>
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: n = 3, edges = [[1,2],[2,3]]<br/>
<b>Output</b>: [2,1]<br/>
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
O(2<sup>N</sup>) Where <br />
N is total number of cities<br />
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N<sup>2</sup>) Where <br >
N is total number of cities<br />
</p>
</blockquote>