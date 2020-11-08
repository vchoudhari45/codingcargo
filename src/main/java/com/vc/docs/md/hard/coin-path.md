[comment]: metadata=Java Solution to problem Coin Path using Dynamic Programming.
[comment]: keywords=Coin Path, Dynamic Programming
[comment]: robots=index, follow


<h1>Coin Path</h1>
<p>
This page explains Java solution to problem <code class="inline">Coin Path</code> using <code class="inline">Dynamic Programming</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given an array <code class="inline">A</code> (index starts at <code class="inline">1</code>) consisting of <code class="inline">N</code> integers: <code class="inline">A1, A2, ..., AN</code> and an integer <code class="inline">B</code>. The integer <code class="inline">B</code> denotes that from any place (suppose the index is <code class="inline">i</code>) in the array <code class="inline">A</code>, you can jump to any one of the place in the array A indexed <code class="inline">i+1, i+2, …, i+B</code> if this place can be jumped to. Also, if you step on the index <code class="inline">i</code>, you have to pay <code class="inline">Ai</code> coins. If <code class="inline">Ai</code> is <code class="inline">-1</code>, it means you can’t jump to the place indexed <code class="inline">i</code> in the array.
</p>
<p>
Now, you start from the place indexed <code class="inline">1</code> in the array <code class="inline">A</code>, and your aim is to reach the place indexed N using the minimum coins. You need to return the path of indexes (starting from <code class="inline">1</code> to <code class="inline">N</code>) in the array you should take to get to the place indexed <code class="inline">N</code> using minimum coins.
</p>
<p>
If there are multiple paths with the same cost, return the lexicographically smallest such path.
</p>
<p>
If it's not possible to reach the place indexed <code class="inline">N</code> then you need to return an empty array.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: [1,2,4,-1,2], 2<br/>
<b>Output</b>: [1,3,5]<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: [1,2,4,-1,2], 1<br/>
<b>Output</b>: []<br/>
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
O(N * B) Where <br />
N is total number of elements in an input array <br />
B is Max Jump you can take 
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is total number of elements in an input array
</p>
</blockquote>