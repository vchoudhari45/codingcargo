[comment]: metadata=Java Solution to problem Minimum One Bit Operations to Make Integers Zero using Gray Code Sequence.
[comment]: keywords=Minimum One Bit Operations to Make Integers Zero, Gray Code Sequence
[comment]: robots=index, follow


<h1>Minimum One Bit Operations to Make Integers Zero</h1>
<p>
This page explains Java solution to problem <code class="inline">Minimum One Bit Operations to Make Integers Zero</code> using <code class="inline">Gray Code Sequence</code>.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given an integer <code class="inline">n</code>, you must transform it into <code class="inline">0</code> using the following operations any number of times:
</p>
<ul>
<li>Change the rightmost <code class="inline">(0<sup>th</sup>)</code> bit in the binary representation of <code class="inline">n</code>.</li>
<li>Change the <code class="inline">i<sup>th</sup></code> bit in the binary representation of <code class="inline">n</code> if the <code class="inline">(i-1)<sup>th</sup></code> bit is set to <code class="inline">1</code> and the <code class="inline">(i-2)<sup>th</sup></code> through <code class="inline">0<sup>th</sup></code> bits are set to <code class="inline">0</code>.</li>
</ul>
<p>
Return the minimum number of operations to transform <code class="inline">n</code> into <code class="inline">0</code>.
</p>


<p>Constraints</p>
<p><code class="inline">0 &lt;= n &lt;= 10<sup>9</sup></code></p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: n = 0<br/>
<b>Output</b>: 0<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: n = 3<br/>
<b>Output</b>: 2<br/>
<b>Explanation</b>:The binary representation of 3 is "11". <br />
"11" -> "01" with the 2nd operation since the 0th bit is 1. <br />
"01" -> "00" with the 1st operation. <br />
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: n = 6<br/>
<b>Output</b>: 4<br/>
<b>Explanation</b>: The binary representation of 6 is "110". <br />
"110" -> "010" with the 2nd operation since the 1st bit is 1 and 0th through 0th bits are 0. <br />
"010" -> "011" with the 1st operation. <br />
"011" -> "001" with the 2nd operation since the 0th bit is 1. <br />
"001" -> "000" with the 1st operation. <br />
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
O(1)
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(1)
</p>
</blockquote>