[comment]: metadata=Java Solution to problem Alien Dictionary using Topological Sorting.
[comment]: keywords=Alien Dictionary, Topological Sorting
[comment]: robots=index, follow


<h1>Alien Dictionary</h1>
<p>
This page explains Java solution to problem <code class="inline">Alien Dictionary</code> using <code class="inline">Topological Sorting</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
</p>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: ["wrt", "wrf", "er", "ett", "rftt"]<br/>
<b>Output</b>: "wertf"<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: ["z", "x"]<br/>
<b>Output</b>: "zx"<br/>
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: ["z", "x", "z"]<br/>
<b>Output</b>: ""<br/>
Explanation: The order is invalid, so return "".
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
O(V + E) Where <br />
V is total number of characters in input array words(Vertices)<br />
E is total number of connections/dependency generated(Edges)<br />
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(V + E)<br />
V is total number of characters in input array words(Vertices)<br />
E is total number of connections/dependency generated(Edges)<br />
</p>
</blockquote>