[comment]: metadata=Java Solution to problem Strong Password Checker using Math.
[comment]: keywords=Strong Password Checker, Math
[comment]: robots=index, follow


<h1>Strong Password Checker</h1>
<p>
This page explains Java solution to problem <code class="inline">Strong Password Checker</code> using <code class="inline">Math</code>.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
A password is considered strong if below conditions are all met:
</p>
<ul>
<li>1. It has at least <code class="inline">6</code> characters and at most <code class="inline">20</code> characters.</li>
<li>2. It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.</li>
<li>3. It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).</li>
</ul>
<p>
Write a function <code class="inline">strongPasswordChecker(s)</code>, that takes a string <code class="inline">s</code> as input, and return the MINIMUM change required to make <code class="inline">s</code> a strong password. If <code class="inline">s</code> is already strong, return 0.
</p>
<p>
Insertion, deletion or replace of any one character are all considered as one change.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: s = aaaa <br/>
<b>Output</b>: 2 <br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: s = 1aA <br/>
<b>Output</b>: 3 <br/>
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
N is total number of characters in an input array
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>O(1)</p>
</blockquote>