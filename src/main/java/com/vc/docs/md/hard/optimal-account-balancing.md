[comment]: metadata=Java Solution to problem Optimal Account Balancing using Backtracking.
[comment]: keywords=Optimal Account Balancing, Backtracking
[comment]: robots=index, follow


<h1>Optimal Account Balancing</h1>
<p>
This page explains Java solution to problem <code class="inline">Optimal Account Balancing</code> using <code class="inline">backtracking</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for <code class="inline">$10</code>. Then later Chris gave Alice <code class="inline">$5</code> for a taxi ride. We can model each transaction as a tuple <code class="inline">(x, y, z)</code> which means person <code class="inline">x</code> gave person <code class="inline">y</code> <code class="inline">$z</code>. Assuming Alice, Bill, and Chris are person <code class="inline">0</code>, <code class="inline">1</code>, and <code class="inline">2</code> respectively (<code class="inline">0</code>, <code class="inline">1</code>, <code class="inline">2</code> are the person's ID), the transactions can be represented as <code class="inline">[[0, 1, 10], [2, 0, 5]]</code>.
</p>
<p>
Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: [[0,1,10], [2,0,5]] <br/>
<b>Output</b>: 2 <br/>
<b>Explanation</b>: <br/>
Person #0 gave person #1 $10. <br />
Person #2 gave person #0 $5. <br />
Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: [[0,1,10], [1,0,1], [1,2,5], [2,0,5]] <br/>
<b>Output</b>: 1 <br/>
<b>Explanation</b>: <br/>
Person #0 gave person #1 $10. <br />
Person #1 gave person #0 $1. <br />
Person #1 gave person #2 $5. <br />
Person #2 gave person #0 $5. <br />
Therefore, person #1 only need to give person #0 $4, and all debt is settled. <br />
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
O(N<sup>N</sup>) Where <br />
N is total number of people in a group
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is total number of people in a group
</p>
</blockquote>