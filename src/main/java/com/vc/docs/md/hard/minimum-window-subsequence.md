[comment]: metadata=Java Solution to problem Minimum Window Subsequence using String Data Structure.
[comment]: keywords=Minimum Window Subsequence, String Data Structure
[comment]: robots=index, follow


<h1>Minimum Window Subsequence</h1>
<p>
This page explains Java solution to problem <code class="inline">Minimum Window Subsequence</code> using <code class="inline">String</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given strings <code class="inline">S</code> and <code class="inline">T</code>, find the minimum (contiguous) substring <code class="inline">W</code> of <code class="inline">S</code>, so that <code class="inline">T</code> is a subsequence of <code class="inline">W</code>.
</p>
<p>
If there is no such window in <code class="inline">S</code> that covers all characters in <code class="inline">T</code>, return the empty string <code class="inline">""</code>. If there are multiple such minimum-length windows, return the one with the left-most starting index.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: S = "abcdebdde", T = "bde"<br/>
<b>Output</b>: "bcde"<br/>
<b>Explanation</b>: <br />
"bcde" is the answer because it occurs before "bdde" which has the same length.<br/>
"deb" is not a smaller window because the elements of T in the window must occur in order.
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
O(S + (S / T)) Where <br />
S is total number of characters in an input string<br />
T is total number of characters in an input subsequence
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(S) Where <br />
S is total number of characters in an input string
</p>
</blockquote>