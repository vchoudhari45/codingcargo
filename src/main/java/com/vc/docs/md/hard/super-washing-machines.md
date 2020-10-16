[comment]: metadata=Java Solution to problem Super Washing Machines using Math.
[comment]: keywords=Super Washing Machines, Math
[comment]: robots=index, follow


<h1>Super Washing Machines</h1>
<p>
This page explains Java solution to problem <code class="inline">Super Washing Machines</code> using <code class="inline">Math</code>.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
You have <code class="inline">n</code> super washing machines on a line. Initially, each washing machine has some dresses or is empty.
</p>
<p>
For each move, you could choose any <code class="inline">m (1 ≤ m ≤ n)</code> washing machines, and pass one dress of each washing machine to one of its adjacent washing machines at the same time.
</p>
<p>
Given an integer array representing the number of dresses in each washing machine from left to right on the line, you should find the minimum number of moves to make all the washing machines have the same number of dresses. If it is not possible to do it, return <code class="inline">-1</code>.
</p>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: [1,0,5]<br/>
<b>Output</b>: 3<br/>
<b>Explanation</b>: <br/>
1st move:    1     0     5    =>    1     1     4 <br />
2nd move:    1     1     4    =>    2     1     3 <br />   
3rd move:    2     1     3    =>    2     2     2 <br />
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: [0,3,0]<br/>
<b>Output</b>: 2<br/>
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: [0,2,0]<br/>
<b>Output</b>: -1<br/>
<b>Explanation</b>: <br/>
It's impossible to make all the three washing machines have the same number of dresses.
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
N is total number of elements in an input array.
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(1)
</p>
</blockquote>