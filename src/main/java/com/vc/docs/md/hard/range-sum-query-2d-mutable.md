[comment]: metadata=Java Solution to problem Range Sum Query 2D - Mutable using Binary Indexed Tree.
[comment]: keywords=Median of Two Sorted Arrays, Binary Indexed Tree
[comment]: robots=index, follow


<h1>Range Sum Query 2D - Mutable</h1>
<p>
This page explains Java solution to problem <code class="inline">Range Sum Query 2D - Mutable</code> using <code class="inline">Binary Indexed Tree</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given a <code class="inline">2D matrix</code>, find the sum of the elements inside the rectangle defined by its upper left corner <code class="inline">(row1, col1)</code> and lower right corner <code class="inline">(row2, col2)</code>.
</p>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: <br/>
matrix = [<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3, 0, 1, 4, 2], <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[5, 6, 3, 2, 1], <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[1, 2, 0, 1, 5], <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[4, 1, 0, 1, 7], <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[1, 0, 3, 0, 5]  <br />
] <br />
<b>Output</b>:
sumRegion(2, 1, 4, 3) -> 8 <br />
update(3, 2, 2) <br />
sumRegion(2, 1, 4, 3) -> 10 <br />
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
O(M * N * log(M * N)) to Generate Binary Indexed Tree using Array <br />
O(log (M * N)) to Update element in an input array & Binary Indexed Tree <br />
O(log (M * N)) to Sum elements in an input range Where <br />
M is total number rows in an input array <br />
N is total number cols in an input array
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(M * N) Where <br />
M is total number rows in an input array <br />
N is total number cols in an input array
</p>
</blockquote>
