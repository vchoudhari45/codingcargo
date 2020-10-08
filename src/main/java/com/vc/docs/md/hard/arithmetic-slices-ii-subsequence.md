[comment]: metadata=Java Solution to problem Arithmetic Slices II - Subsequence using Dynamic Programming.
[comment]: keywords=Arithmetic Slices II - Subsequence, Dynamic Programming
[comment]: robots=index, follow


<h1>Arithmetic Slices II - Subsequence</h1>
<p>
This page explains Java solution to problem <code class="inline">Arithmetic Slices II - Subsequence</code> using <code class="inline">Dynamic Programming</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
</p>
<p>
For example, these are arithmetic sequences:
</p>
<p>
1, 3, 5, 7, 9   <br />
7, 7, 7, 7      <br />
3, -1, -5, -9   <br />
</p>
<p>
A zero-indexed array <code class="inline">A</code> consisting of <code class="inline">N</code> numbers is given. A subsequence slice of that array is any sequence of integers <code class="inline">(P0, P1, ..., Pk)</code> such that <code class="inline">0 ≤ P0 < P1 < ... < Pk < N</code>.
</p>
<p>
A subsequence slice <code class="inline">(P0, P1, ..., Pk)</code> of array <code class="inline">A</code> is called arithmetic if the sequence <code class="inline">A[P0], A[P1], ..., A[Pk-1], A[Pk]</code> is arithmetic. In particular, this means that <code class="inline">k ≥ 2</code>.
</p>
<p>
The function should return the number of arithmetic subsequence slices in the array A.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: [2, 4, 6, 8, 10]<br/>
<b>Output</b>: 7<br/>
<b>Explanation</b>: <br/>
All arithmetic subsequence slices are:<br />
[2,4,6]<br />
[4,6,8]<br />
[6,8,10]<br />
[2,4,6,8]<br />
[4,6,8,10]<br />
[2,4,6,8,10]<br />
[2,6,10]<br />
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
O(N<sup>2</sup>) Where <br />
N is total number of elements in an input array.
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N)
</p>
</blockquote>