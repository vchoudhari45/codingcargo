[comment]: metadata=Java Solution to problem Word Squares using Backtracking.
[comment]: keywords=Word Squares, Backtracking
[comment]: robots=index, follow


<h1>Word Squares</h1>
<p>
This page explains Java solution to problem <code class="inline">Word Squares</code> using <code class="inline">Backtracking</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given a set of words (without duplicates), find all word squares you can build from them.
</p>
<p>
A sequence of words forms a valid word square if the <code class="inline">kth</code> row and column read the exact same string, where <code class="inline">0 ≤ k < max(numRows, numColumns)</code>.
</p>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: ["area","lead","wall","lady","ball"] <br />
<b>Output</b>:<br/>
[<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ "wall",<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"area",<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"lead",<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"lady"],<br /><br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ "ball",<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"area",<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"lead",<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"lady"]<br />
]
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
O(N * 26<sup>L</sup>) Where <br />
N is total number words in an input array <br />
L is length of single word <br />
26 Alphabets a-z
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N * L) Where <br />
N is total number words in an input array <br />
L is length of single word <br />
</p>
</blockquote>