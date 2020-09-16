[comment]: metadata=Java Solution to problem Edit Distance using Dynamic Programming.
[comment]: keywords=Edit Distance, Dynamic Programming
[comment]: robots=index, follow


<h1>Edit Distance</h1>
<p>
This page explains Java solution to problem <code class="inline">Edit Distance</code> using <code class="inline">Dynamic programming</code>.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given two words <code class="inline">word1</code> and <code class="inline">word2</code>, find the minimum number of operations required to convert <code class="inline">word1</code> to <code class="inline">word2</code>.
</p>
<p>You have the following 3 operations permitted on a word:</p>
<ul>
<li>Insert a character</li>
<li>Delete a character</li>
<li>Replace a character</li>
</ul>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: word1 = "horse", word2 = "ros"<br/>
<b>Output</b>: 3<br/>
<b>Explanation</b>: <br />
                    horse -> rorse (replace 'h' with 'r') <br />
                    rorse -> rose (remove 'r')<br />
                    rose -> ros (remove 'e')<br />
</p>
</blockquote>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: word1 = "intention", word2 = "execution"<br/>
<b>Output</b>: 5<br/>
<b>Explanation</b>: <br />
                    intention -> inention (remove 't')<br />
                    inention -> enention (replace 'i' with 'e')<br />
                    enention -> exention (replace 'n' with 'x')<br />
                    exention -> exection (replace 'n' with 'c')<br />
                    exection -> execution (insert 'u')<br />
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
O(M * N) <br />
Where M is length of word1 <br />
And N is length of word2
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(M * N)
</p>
</blockquote>