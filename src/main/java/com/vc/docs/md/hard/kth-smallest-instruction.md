[comment]: metadata=Java Solution to problem Kth Smallest Instructions using Dynamic Programming.
[comment]: keywords=Kth Smallest Instructions, Dynamic Programming.
[comment]: robots=index, follow


<h1>Kth Smallest Instructions</h1>
<p>
This page explains Java solution to problem <code class="inline">Kth Smallest Instructions</code> using <code class="inline">Dynamic Programming</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Bob is standing at cell <code class="inline">(0, 0)</code>, and he wants to reach destination: <code class="inline">(row, column)</code>. He can only travel right and down. You are going to help Bob by providing instructions for him to reach destination.
</p>
<p>
The instructions are represented as a string, where each character is either:
</p>
<ul>
<li><code class="inline">H</code>, meaning move horizontally (go right), or</li>
<li><code class="inline">V</code>, meaning move vertically (go down).</li>
</ul>
<p>
Multiple instructions will lead Bob to destination. For example, if destination is <code class="inline">(2, 3)</code>, both <code class="inline">HHHVV</code> and <code class="inline">HVHVH</code> are valid instructions.
</p>
<p>
However, Bob is very picky. Bob has a lucky number <code class="inline">k</code>, and he wants the <code class="inline">k<sup>th</sup></code> lexicographically smallest instructions that will lead him to destination. <code class="inline">k</code> is 1-indexed.
</p>
<p>
Given an integer array destination and an integer <code class="inline">k</code>, return the <code class="inline">k<sup>th</sup></code> lexicographically smallest instructions that will take Bob to destination.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: destination = [2,3], k = 1<br/>
<b>Output</b>: "HHHVV"<br/>
<b>Explanation</b>: All the instructions that reach (2, 3) in lexicographic order are as follows: <br />
["HHHVV", "HHVHV", "HHVVH", "HVHHV", "HVHVH", "HVVHH", "VHHHV", "VHHVH", "VHVHH", "VVHHH"].<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: destination = [2,3], k = 2<br/>
<b>Output</b>: "HHVHV"<br/>
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
O(X * Y) Where <br />
X is destination in horizontal direction <br />
Y is destination in vertical direction 
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(X * Y) Where <br />
X is destination in horizontal direction <br />
Y is destination in vertical direction 
</p>
</blockquote>