[comment]: metadata=Java Solution to problem Number of Ways to Form a Target String Given a Dictionary using Dynamic Programming Algorithm.
[comment]: keywords=Number of Ways to Form a Target String Given a Dictionary, Dynamic Programming Algorithm
[comment]: robots=index, follow


<h1>Number of Ways to Form a Target String Given a Dictionary</h1>
<p>
This page explains Java solution to problem <code class="inline">Number of Ways to Form a Target String Given a Dictionary</code> using <code class="inline">Dynamic Programming</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
You are given a list of strings of the same length <code class="inline">words</code> and a string <code class="inline">target</code>.
</p>
<p>
Your task is to form target using the given words under the following rules:
</p>
<ul>
<li><code class="inline">target</code> should be formed from left to right.</li>
<li>To form the <code class="inline">i<sup>th</sup></code> character (0-indexed) of target, you can choose the <code class="inline">k<sup>th</sup></code> character of the <code class="inline">j<sup>th</sup></code> string in words if <code class="inline">target[i] = words[j][k]</code>.</li>
<li>Once you use the <code class="inline">k<sup>th</sup></code> character of the <code class="inline">j<sup>th</sup></code> string of words, you can no longer use the xth character of any string in words where <code class="inline">x <= k</code>. In other words, all characters to the left of or at index <code class="inline">k</code> become unusuable for every string.</li>
<li>Repeat the process until you form the string target.</li>
</ul>
<p>
Notice that you can use multiple characters from the same string in words provided the conditions above are met.
</p>
<p>Return the number of ways to form target from words. Since the answer may be too large, return it modulo <code class="inline">10<sup>9</sup> + 7</code>.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: words = ["acca","bbbb","caca"], target = "aba"<br/>
<b>Output</b>: 6<br/>
<b>Explanation</b>: There are 6 ways to form target.<br/>
"aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("caca") <br />
"aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("caca") <br />
"aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("acca") <br />
"aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("acca") <br />
"aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("acca") <br />
"aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("caca") <br />
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: words = ["abba","baab"], target = "bab"<br/>
<b>Output</b>: 4<br/>
<b>Explanation</b>: There are 4 ways to form target.<br/>
"bab" -> index 0 ("baab"), index 1 ("baab"), index 2 ("abba") <br />
"bab" -> index 0 ("baab"), index 1 ("baab"), index 3 ("baab") <br />
"bab" -> index 0 ("baab"), index 2 ("baab"), index 3 ("baab") <br />
"bab" -> index 1 ("abba"), index 2 ("baab"), index 3 ("baab") <br />
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
O(L * (W + T)) Where <br />
L is length of input words array <br />
W is length of any input word in an input words array<br />
T is length of input target string
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(T) Where <br />
T is length of input target string
</p>
</blockquote>