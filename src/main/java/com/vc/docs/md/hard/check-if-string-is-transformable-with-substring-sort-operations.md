[comment]: metadata=Java Solution to problem Check If String Is Transformable With Substring Sort Operations using String data structure.
[comment]: keywords=Check If String Is Transformable With Substring Sort Operations, String data structure
[comment]: robots=index, follow


<h1>Check If String Is Transformable With Substring Sort Operations</h1>
<p>
This page explains Java solution to problem <code class="inline">Check If String Is Transformable With Substring Sort Operations</code> using <code class="inline">String</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given two strings <code class="inline">s</code> and <code class="inline">t</code>, you want to transform string <code class="inline">s</code> into string <code class="inline">t</code> using the following operation any number of times:
</p>
<p>
Choose a non-empty substring in <code class="inline">s</code> and sort it in-place so the characters are in ascending order.
</p>
<p>
For example, applying the operation on the underlined substring in <code class="inline">14234</code> results in <code class="inline">12344</code>.
</p>
<p>
Return <code class="inline">true</code> if it is possible to transform string <code class="inline">s</code> into string <code class="inline">t</code>. Otherwise, return <code class="inline">false</code>.
</p>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: s = "84532", t = "34852"<br/>
<b>Output</b>: true<br/>
<b>Explanation</b>: You can transform s into t using the following sort operations: <br />
"84532" (from index 2 to 3) -> "84352" <br />
"84352" (from index 0 to 2) -> "34852"
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: s = "34521", t = "23415"<br/>
<b>Output</b>: true<br/>
<b>Explanation</b>: You can transform s into t using the following sort operations: <br />
"34521" -> "23451" <br />
"23451" -> "23415" 
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: s = "12345", t = "12435"<br/>
<b>Output</b>: false<br/>
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
O(N + M) Where <br />
N is length of input string s<br />
M is length of input string t
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br >
N is length of input string s<br />
</p>
</blockquote>