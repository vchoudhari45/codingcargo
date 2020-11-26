[comment]: metadata=Java Solution to problem Rank Transform of a Matrix using Union And Find Algorithm.
[comment]: keywords=Rank Transform of a Matrix, Union And Find Algorithm
[comment]: robots=index, follow


<h1>Rank Transform of a Matrix</h1>
<p>
This page explains Java solution to problem <code class="inline">Rank Transform of a Matrix</code> using <code class="inline">Union And Find</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given an <code class="inline">m x n</code> matrix, return a new matrix <code class="inline">answer</code> where <code class="inline">answer[row][col]</code> is the rank of <code class="inline">matrix[row][col]</code>.
</p>
<p>
The rank is an integer that represents how large an element is compared to other elements. It is calculated using the following rules:
</p>
<ul>
<li>The rank is an integer starting from <code class="inline">1</code>.</li>
<li>If two elements <code class="inline">p</code> and <code class="inline">q</code> are in the same <code class="inline">row</code> or <code class="inline">column</code>, then:</li>
<li>If <code class="inline">p < q</code> then <code class="inline">rank(p) < rank(q)</code></li>
<li>If <code class="inline">p == q</code> then <code class="inline">rank(p) == rank(q)</code></li>
<li>If <code class="inline">p > q</code> then <code class="inline">rank(p) > rank(q)</code></li>
<li>The rank should be as small as possible.</li>
</ul>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: [[1,2],[3,4]]<br/>
<b>Output</b>: [[1,2],[2,3]]<br/>
<b>Explanation</b>: The rank of matrix[0][0] is 1 because it is the smallest integer in its row and column. <br />
The rank of matrix[0][1] is 2 because matrix[0][1] > matrix[0][0] and matrix[0][0] is rank 1. <br />
The rank of matrix[1][0] is 2 because matrix[1][0] > matrix[0][0] and matrix[0][0] is rank 1. <br />
The rank of matrix[1][1] is 3 because matrix[1][1] > matrix[0][1], matrix[1][1] > matrix[1][0], and both matrix[0][1] and matrix[1][0] are rank 2.<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: [[7,7],[7,7]]<br/>
<b>Output</b>: [[1,1],[1,1]]<br/>
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: [[20,-21,14],[-19,4,19],[22,-47,24],[-19,4,19]]<br/>
<b>Output</b>: [[4,2,3],[1,3,4],[5,1,6],[1,3,4]]<br/>
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
O(NM log(NM)) Where <br />
M is number of Rows in an input matrix <br />
N is number of Columns in an input matrix
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(NM) Where <br >
M is number of Rows in an input matrix <br />
N is number of Columns in an input matrix <br />
</p>
</blockquote>