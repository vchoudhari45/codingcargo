[comment]: metadata=Java Solution to problem Scramble String using Dynamic Programming Algorithm.
[comment]: keywords=Scramble String, Dynamic Programming
[comment]: robots=index, follow


<h1>Scramble String</h1>
<p>
This page explains Java solution to problem <code class="inline">Scramble String</code> using <code class="inline">Dynamic</code> programming algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
We can scramble a string <code class="inline">s</code> to get a string <code class="inline">t</code> using the following algorithm:
</p>
<ul>
<li>
1. If the length of the string is <code class="inline">1</code>, stop.
</li>
<li>
2. If the length of the string is <code class="inline">&gt; 1</code>, do the following:
<ul>
    <li>2.1. Split the string into <code class="inline">2</code> non-empty substrings at a random index, i.e. if the string is <code class="inline">s</code>, divide it to <code class="inline">x</code> and <code class="inline">y</code> where <code class="inline">s = x + y</code>.</li>
    <li>2.2. Randomly, decide to swap the two substrings or to keep them in the same order. i.e. after this step, <code class="inline">s</code> may become <code class="inline">s = x + y</code> or <code class="inline">s = y + x</code>.</li>
    <li>2.3. Apply step <code class="inline">1</code> recursively on each of the two substrings <code class="inline">x</code> and <code class="inline">y</code>.</li>
</ul>
</li>
</ul>
<p>
Given two strings <code class="inline">s1</code> and <code class="inline">s2</code> of the same length, return <code class="inline">true</code> if <code class="inline">s2</code> is a scrambled string of <code class="inline">s1</code>, otherwise, return <code class="inline">false</code>.
</p>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: s1 = "great", s2 = "rgeat"<br/>
<b>Output</b>: true<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: s1 = "abcde", s2 = "caebd" <br />
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
O(N!) Where <br />
N is length of input string s1 or s2(Both will have same length)
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N ^ 3) Where <br />
N is length of input string s1 or s2(Both will have same length)
</p>
</blockquote>