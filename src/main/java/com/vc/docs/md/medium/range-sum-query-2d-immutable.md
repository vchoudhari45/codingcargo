[comment]: metadata=Java Solution to problem Range Sum Query 2D - Immutable using Prefix Array.
[comment]: keywords=Range Sum Query 2D - Immutable, Prefix Array
[comment]: robots=index, follow


<h1>Range Sum Query 2D - Immutable</h1>
<p>
This page explains Java solution to problem <code class="inline">Range Sum Query 2D - Immutable</code> using <code class="inline">Prefix Array</code>.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given a <code class="inline">2D</code> matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner <code class="inline">(row1, col1)</code> and lower right corner <code class="inline">(row2, col2)</code>.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: <br/>
matrix = [<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3, 0, 1, 4, 2], <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[5, 6, 3, 2, 1], <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[1, 2, 0, 1, 5], <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4, 1, 0, 1, 7], <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[1, 0, 3, 0, 5] <br />
]<br />
<b>Output</b>: <br/>
sumRegion(2, 1, 4, 3) -> 8 <br />
sumRegion(1, 1, 2, 2) -> 11 <br />
sumRegion(1, 2, 2, 4) -> 12 <br />
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
O(M * N) to Generate prefix array Where <br />
M is total number of rows in an input array <br />
N is total number of cols in an input array <br />
O(1) to Get Range Sum
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(M * N) Where <br />
M is total number of rows in an input array <br />
N is total number of cols in an input array <br />
</p>
</blockquote>