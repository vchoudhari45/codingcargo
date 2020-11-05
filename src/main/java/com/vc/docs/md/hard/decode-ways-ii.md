[comment]: metadata=Java Solution to problem Decode Ways II using Dynamic Programming.
[comment]: keywords=Decode Ways II, Dynamic Programming
[comment]: robots=index, follow


<h1>Decode Ways II</h1>
<p>
This page explains Java solution to problem <code class="inline">Decode Ways II</code> using <code class="inline">Dynamic Programming</code>.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
A message containing letters from A-Z is being encoded to numbers using the following mapping way:
</p>
<blockquote>
<p>
'A' -> 1  <br />
'B' -> 2  <br />
...       <br />
'Z' -> 26 <br />
</p>
</blockquote>
<p>
Beyond that, now the encoded string can also contain the character <code class="inline">*</code>, which can be treated as one of the numbers from <code class="inline">1</code> to <code class="inline">9</code>.
</p>
<p>
Given the encoded message containing digits and the character <code class="inline">*</code>, return the total number of ways to decode it.
</p>
<p>
Also, since the answer may be very large, you should return the output mod <code class="inline">10<sup>9</sup> + 7</code>.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: "*"<br/>
<b>Output</b>: 9<br/>
<b>Explanation</b>: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: 1*"<br/>
<b>Output</b>: 9 + 9 = 18<br/>
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
O(N) Where <br />
N length of input string S
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N length of input string S
</p>
</blockquote>