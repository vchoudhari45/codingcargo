[comment]: metadata=Java Solution to problem Expression Add Operators using Backtracking.
[comment]: keywords=Expression Add Operators, Backtracking
[comment]: robots=index, follow


<h1>Expression Add Operators</h1>
<p>
This page explains Java solution to problem <code class="inline">Expression Add Operators</code> using <code class="inline">Backtracking</code>.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given a string that contains only digits <code class="inline">0-9</code> and a target value, return all possibilities to add binary operators (not unary) <code class="inline">+</code>, <code class="inline">-</code>, or <code class="inline">*</code> between the digits so they evaluate to the target value.
</p>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: num = "123", target = 6<br/>
<b>Output</b>: ["1+2+3", "1*2*3"]<br />
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: num = "105", target = 5<br/>
<b>Output</b>: ["1*0+5","10-5"]<br/>
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
O(N<sup>2</sup> * 3<sup>N</sup>) Where <br />
N is length of elements in an input string <br />
At every step along the way, we consider exactly 3 different choices or 3 different recursive paths. The base case is when the value of index reaches N. 
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is length of elements in an input string <br />
</p>
</blockquote>