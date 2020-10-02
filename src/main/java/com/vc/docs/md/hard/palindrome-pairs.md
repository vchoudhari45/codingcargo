[comment]: metadata=Java Solution to problem Palindrome Pairs using String Data Structure
[comment]: keywords=Palindrome Pairs, String Data Structure
[comment]: robots=index, follow


<h1>Palindrome Pairs</h1>
<p>
This page explains Java solution to problem <code class="inline">Palindrome Pairs</code> using <code class="inline">String</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given a list of unique words, return all the pairs of the distinct indices <code class="inline">(i, j)</code> in the given list, so that the concatenation of the two words <code class="inline">words[i] + words[j]</code> is a palindrome.
</p>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: words = ["abcd","dcba","lls","s","sssll"]<br/>
<b>Output</b>: [[0,1],[1,0],[3,2],[2,4]]<br/>
<b>Explanation</b>: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: words = ["bat","tab","cat"]<br/>
<b>Output</b>: [[0,1],[1,0]]<br/>
<b>Explanation</b>: The palindromes are ["battab","tabbat"]<br/>
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
O(N * K<sup>2</sup>) Where <br />
N is total number of elements in an input array <br />
K is length of longest word in a word input array<br />
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p> 
O(N) Where <br />
N is total number of elements in an input array <br />
</p>
</blockquote>