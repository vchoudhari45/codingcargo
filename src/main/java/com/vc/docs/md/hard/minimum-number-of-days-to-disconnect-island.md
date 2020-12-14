[comment]: metadata=Java Solution to problem Minimum Number of Days to Disconnect Island using Depth First Search.
[comment]: keywords=Minimum Number of Days to Disconnect Island, Depth First Search
[comment]: robots=index, follow


<h1>Minimum Number of Days to Disconnect Island</h1>
<p>
This page explains Java solution to problem <code class="inline">Minimum Number of Days to Disconnect Island</code> using <code class="inline">Depth First Search</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given a <code class="inline">2D</code> grid consisting of <code class="inline">1s</code> (land) and <code class="inline">0s</code> (water). An island is a maximal 4-directionally (horizontal or vertical) connected group of <code class="inline">1s</code>.
</p>
<p>
The grid is said to be connected if we have exactly one island, otherwise is said disconnected.
</p>
<p>
In one day, we are allowed to change any single land cell <code class="inline">(1)</code> into a water cell <code class="inline">(0)</code>.
</p>
<p>Return the minimum number of days to disconnect the grid.</p>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: grid = [[0,1,1,0],[0,1,1,0],[0,0,0,0]]<br/>
<b>Output</b>: 2<br/>
<b>Explanation</b>: We need at least 2 days to get a disconnected grid.<br />
Change land grid[1][1] and grid[0][2] to water and get 2 disconnected island.
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: [[1,1]]<br/>
<b>Output</b>: 1<br/>
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: [[1,0,1,0]]<br/>
<b>Output</b>: 0<br/>
</p>
</blockquote>

<b>Example 4:</b>
<blockquote>
<p>
<b>Input</b>: [[1,1,0,1,1], [1,1,1,1,1], [1,1,0,1,1],[1,1,1,1,1]]<br/>
<b>Output</b>: 2<br/>
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
O((N * M)<sup>2</sup>) Where <br />
N is number of Rows in an input grid <br />
M is number of Columns in an input grid
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N * M) Where <br >
N is number of Rows in an input grid <br />
M is number of Columns in an input grid
</p>
</blockquote>