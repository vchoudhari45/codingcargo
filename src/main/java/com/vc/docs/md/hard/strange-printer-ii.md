[comment]: metadata=Java Solution to problem Strange Printer II using Topological Sorting.
[comment]: keywords=Strange Printer II, Topological Sorting
[comment]: robots=index, follow


<h1>Strange Printer II</h1>
<p>
This page explains Java solution to problem <code class="inline">Strange Printer II</code> using <code class="inline">Topological Sorting</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
There is a strange printer with the following two special requirements:
</p>
<ul>
<li>On each turn, the printer will print a solid rectangular pattern of a single color on the grid. This will cover up the existing colors in the rectangle.</li>
<li>Once the printer has used a color for the above operation, the same color cannot be used again.</li>
</ul>

<p>
You are given a <code class="inline">m x n</code> matrix  <code class="inline">targetGrid</code>, where  <code class="inline">targetGrid[row][col]</code> is the color in the position  <code class="inline">(row, col)</code> of the grid.
</p>

<p>
Return <code class="inline">true</code> if it is possible to print the matrix  <code class="inline">targetGrid</code>, otherwise, return  <code class="inline">false</code>.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: targetGrid = [[1,1,1,1],[1,2,2,1],[1,2,2,1],[1,1,1,1]]<br/>
<b>Output</b>: true<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: targetGrid = [[1,1,1,1],[1,1,3,3],[1,1,3,4],[5,5,1,4]]<br/>
<b>Output</b>: true<br/>
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: [[1,2,1],[2,1,2],[1,2,1]]<br/>
<b>Output</b>: false<br/>
</p>
</blockquote>

<b>Example 4:</b>
<blockquote>
<p>
<b>Input</b>: [[1,1,1],[3,1,3]]<br/>
<b>Output</b>: false<br/>
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
O(V * N * M + (V + E)) Where <br />
V is number of distinct values in a targetGrid <br />
N is number of rows in a targetGrid <br />
M is number of cols in a targetGrid <br />
E is total number of dependencies for e.g. color1 should go before color2<br /> 
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(V + E) Where <br >
V is number of distinct values in a targetGrid <br />
E is total number of dependencies for e.g. color1 should go before color2<br /> 
</p>
</blockquote>