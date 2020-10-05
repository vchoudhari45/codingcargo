[comment]: metadata=Java Solution to problem Minimum Unique Word Abbreviation using Bit Manipulation.
[comment]: keywords=Minimum Unique Word Abbreviation, Bit Manipulation
[comment]: robots=index, follow


<h1>Minimum Unique Word Abbreviation</h1>
<p>
This page explains Java solution to problem <code class="inline">Minimum Unique Word Abbreviation</code> using <code class="inline">Bit Manipulation</code>.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
A string such as <code class="inline">"word"</code> contains the following abbreviations:
</p>
<p>
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
</p>
<p>
Given a target string and a set of strings in a dictionary, find an abbreviation of this target string with the smallest possible length such that it does not conflict with abbreviations of the strings in the dictionary.
</p>
<p>
Each number or letter in the abbreviation is considered <code class="inline">length = 1</code>. For example, the abbreviation <code class="inline">"a32bc"</code> has <code class="inline">length = 4</code>.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: target = "apple", dictionary = ["blade"] <br/>
<b>Output</b>: "a4" <br/>
<b>Explanation</b>: because "5" or "4e" conflicts with "blade"<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: target = "apple", dictionary = ["plain", "amber", "blade"] <br/>
<b>Output</b>: "1p3" <br/>
<b>Explanation</b>: (other valid answers include "ap3", "a3e", "2p2", "3le", "3l1")<br/>
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
O(2<sup>N</sup> * M) Where <br />
N is length of an input string target<br />
M is length of an input array dictionary<br />
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(M + N) Where <br />
N is length of an input string target<br />
M is length of an input array dictionary<br />
</p>
</blockquote>