[comment]: metadata=Java Solution to problem Encode String with Shortest Length using Dynamic Programming algorithm.
[comment]: keywords=Encode String with Shortest Length, Dynamic Programming algorithm
[comment]: robots=index, follow


<h1>Encode String with Shortest Length</h1>
<p>
This page explains Java solution to problem <code class="inline">Encode String with Shortest Length</code> using <code class="inline">Dynamic Programming</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given a non-empty string, encode the string such that its encoded length is the shortest.
</p>
<p>
The encoding rule is: <code class="inline">k[encoded_string]</code>, where the encoded_string inside the square brackets is being repeated exactly <code class="inline">k</code> times.
</p>
<ul>
<li><code class="inline">k</code> will be a positive integer.</li>
<li>If an encoding process does not make the string shorter, then do not encode it. If there are several solutions, return any of them.</li>
</ul>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: s = "aaaaa"<br/>
<b>Output</b>: "5[a]"<br/>
<b>Explanation</b>: "5[a]" is shorter than "aaaaa" by 1 character.<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: s = "abbbabbbcabbbabbbc"<br/>
<b>Output</b>: "2[2[abbb]c]"<br/>
<b>Explanation</b>: "abbbabbbc" occurs twice, but "abbbabbbc" can also be encoded to "2[abbb]c", so one answer can be "2[2[abbb]c]".<br/>
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
O(N<sup>3</sup>) Where <br />
N is length of input string
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N<sup>2</sup>) Where <br />
N is length of input string
</p>
</blockquote>