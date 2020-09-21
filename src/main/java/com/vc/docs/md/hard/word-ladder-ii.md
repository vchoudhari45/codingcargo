[comment]: metadata=Java Solution to problem Word Ladder II using Dijkstra's algorithm.
[comment]: keywords=Word Ladder II, Dijkstra's algorithm
[comment]: robots=index, follow


<h1>Word Ladder II</h1>
<p>
This page explains Java solution to problem <code class="inline">Word Ladder II</code> using <code class="inline">Dijkstra's</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given two words <code class="inline">beginWord</code> and <code class="inline">endWord</code>, and a dictionary's word list, find all shortest transformation sequence(s) from <code class="inline">beginWord</code> to <code class="inline">endWord</code>, such that:
</p>
<ul>
<li>1. Only one letter can be changed at a time.</li>
<li>2. Each transformed word must exist in the word list. Note that <code class="inline">beginWord</code> is not a transformed word.</li>
</ul>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: <br />
beginWord = "hit",  <br />
endWord = "cog",  <br />
wordList = ["hot","dot","dog","lot","log","cog"]  <br />
<b>Output</b>: <br/>
[<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;["hit","hot","dot","dog","cog"],<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;["hit","hot","lot","log","cog"]<br />
]<br />
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: <br />
beginWord = "hit" <br />
endWord = "cog" <br />
wordList = ["hot","dot","dog","lot","log"] <br />
<b>Output</b>: []<br />
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
Total Time complexity = O(V * W * 26) + O(V + E)  
<br />
<br />
O(V * W * 26) Where <br /> 
V is total number of Vertices, in our case elements in an input array words. <br /> 
W is length of word in an input array words. <br /> 
26 because we iterate over all the elements from 'a' to 'z' <br /> 
<br /> 
<br /> 
O(V + E) Where <br />
V is total number of Vertices, in our case elements in an input array words. <br /> 
E is total number of Edges, in our case connections that we generate in a graph variable.
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(V + E) Where <br />
V is total number of Vertices, in our case elements in an input array words. <br /> 
E is total number of Edges, in our case connections that we generate in a graph variable.
</p>
</blockquote>