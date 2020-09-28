[comment]: metadata=Java Solution to problem Range Sum Query - Mutable using Binary Indexed Tree.
[comment]: keywords=Range Sum Query - Mutable, Binary Indexed Tree
[comment]: robots=index, follow


<h1>Range Sum Query - Mutable</h1>
<p>
This page explains Java solution to problem <code class="inline">Range Sum Query - Mutable</code> using <code class="inline">Binary Indexed Tree</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given an integer array <code class="inline">nums</code>, find the sum of the elements between indices <code class="inline">i</code> and <code class="inline">j</code> <code class="inline">(i ≤ j)</code>, inclusive.
</p>
<p>
The <code class="inline">update(i, val)</code> function modifies <code class="inline">nums</code> by updating the element at index <code class="inline">i</code> to <code class="inline">val</code>.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: nums = [1, 3, 5]<br/>
<b>Output</b>: <br/>
sumRange(0, 2) -> 9 <br />
update(1, 2) <br />
sumRange(0, 2) -> 8 <br />
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
O(N * log N) to Generate Binary Indexed Tree using Array<br />
O(log N) to Update element in an input array & Binary Indexed Tree <br />
O(log N) to Sum elements in an input range Where <br />
N is total number of elements in an input array
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is total number of elements in an input array
</p>
</blockquote>