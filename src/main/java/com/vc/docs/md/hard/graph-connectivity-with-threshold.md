[comment]: metadata=Java Solution to problem Graph Connectivity With Threshold using Union And Find Algorithm.
[comment]: keywords=Graph Connectivity With Threshold, Union And Find Algorithm
[comment]: robots=index, follow


<h1>Graph Connectivity With Threshold</h1>
<p>
This page explains Java solution to problem <code class="inline">Graph Connectivity With Threshold</code> using <code class="inline">Union And Find</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
We have <code class="inline">n</code> cities labeled from <code class="inline">1</code> to <code class="inline">n</code>. Two different cities with labels <code class="inline">x</code> and <code class="inline">y</code> are directly connected by a bidirectional road if and only if <code class="inline">x</code> and <code class="inline">y</code> share a common divisor strictly greater than some threshold. More formally, cities with labels <code class="inline">x</code> and <code class="inline">y</code> have a road between them if there exists an integer <code class="inline">z</code> such that all of the following are true:
</p>
<ul>
<li><code class="inline">x % z == 0</code>,</li>
<li><code class="inline">y % z == 0</code>, and</li>
<li><code class="inline">z > threshold</code>.</li>
</ul>
<p>
Given the two integers, <code class="inline">n</code> and threshold, and an array of queries, you must determine for each <code class="inline">queries[i] = [ai, bi]</code> if cities <code class="inline">ai</code> and <code class="inline">bi</code> are connected (i.e. there is some path between them).
</p>
<p>
Return an array answer, where <code class="inline">answer.length == queries.length</code> and <code class="inline">answer[i]</code> is <code class="inline">true</code> if for the <code class="inline">i<sup>th</sup></code> query, there is a path between <code class="inline">ai</code> and <code class="inline">bi</code>, or <code class="inline">answer[i]</code> is <code class="inline">false</code> if there is no path.
</p>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: n = 6, threshold = 2, queries = [[1,4],[2,5],[3,6]]<br/>
<b>Output</b>: [false,false,true]<br/>
<b>Explanation</b>: The divisors for each number: <br />
1:   1<br />
2:   1, 2<br />
3:   1, 3<br />
4:   1, 2, 4<br />
5:   1, 5<br />
6:   1, 2, 3, 6<br />
Using the underlined divisors above the threshold, only cities 3 and 6 share a common divisor, so they are the<br />
only ones directly connected. The result of each query:<br />
[1,4]   1 is not connected to 4<br />
[2,5]   2 is not connected to 5<br />
[3,6]   3 is connected to 6 through path 3--6<br />
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: n = 6, threshold = 0, queries = [[4,5],[3,4],[3,2],[2,6],[1,3]]<br/>
<b>Output</b>: [true,true,true,true,true]<br/>
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: n = 5, threshold = 1, queries = [[4,5],[4,5],[3,2],[2,3],[3,4]]<br/>
<b>Output</b>: [false,false,false,false,false]<br/>
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
O(N log N + Q) Where <br />
N is total number of cities <br />
Q is total number of queries
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N + Q) Where <br >
N is total number of cities <br />
Q is total number of queries
</p>
</blockquote>