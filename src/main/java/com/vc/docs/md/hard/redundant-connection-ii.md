[comment]: metadata=Java Solution to problem Redundant Connection II using Union and Find.
[comment]: keywords=Redundant Connection II, Union and Find.
[comment]: robots=index, follow


<h1>Redundant Connection II</h1>
<p>
This page explains Java solution to problem <code class="inline">Redundant Connection II</code> using <code class="inline">Union and Find</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.
</p>
<p>
The given input is a directed graph that started as a rooted tree with <code class="inline">N</code> nodes (with distinct values <code class="inline">1, 2, ..., N</code>), with one additional directed edge added. The added edge has two different vertices chosen from <code class="inline">1</code> to <code class="inline">N</code>, and was not an edge that already existed.
</p>
<p>
The resulting graph is given as a 2D-array of edges. Each element of edges is a pair <code class="inline">[u, v]</code> that represents a directed edge connecting nodes <code class="inline">u</code> and <code class="inline">v</code>, where <code class="inline">u</code> is a parent of child <code class="inline">v</code>.
</p>
<p>
Return an edge that can be removed so that the resulting graph is a rooted tree of <code class="inline">N</code> nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: [[1,2], [1,3], [2,3]]<br/>
<b>Output</b>: [2,3]<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: [[1,2], [2,3], [3,4], [4,1], [1,5]]<br/>
<b>Output</b>: [4,1]<br/>
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
O(N * log N) Where <br />
N is total number of edges in an input array
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is total number of edges in an input array
</p>
</blockquote>