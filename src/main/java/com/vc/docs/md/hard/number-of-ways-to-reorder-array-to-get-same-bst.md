[comment]: metadata=Java Solution to problem Number of Ways to Reorder Array to Get Same BST using Dynamic Programming.
[comment]: keywords=Number of Ways to Reorder Array to Get Same BST, Dynamic Programming
[comment]: robots=index, follow


<h1>Number of Ways to Reorder Array to Get Same BST</h1>
<p>
This page explains Java solution to problem <code class="inline">Number of Ways to Reorder Array to Get Same BST</code> using <code class="inline">Dynamic Programming</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given an array <code class="inline">nums</code> that represents a permutation of integers from <code class="inline">1</code> to <code class="inline">n</code>. We are going to construct a binary search tree (BST) by inserting the elements of <code class="inline">nums</code> in order into an initially empty BST. Find the number of different ways to reorder <code class="inline">nums</code> so that the constructed BST is identical to that formed from the original array <code class="inline">nums</code>.
</p>
<p>
For example, given <code class="inline">nums = [2,1,3]</code>, we will have <code class="inline">2</code> as the root, <code class="inline">1</code> as a left child, and <code class="inline">3</code> as a right child. The array <code class="inline">[2,3,1]</code> also yields the same BST but <code class="inline">[3,2,1]</code> yields a different BST.
</p>
<p>
Return the number of ways to reorder <code class="inline">nums</code> such that the BST formed is identical to the original BST formed from <code class="inline">nums</code>.
</p>
<p>
Since the answer may be very large, return it modulo <code class="inline">10^<sup>9</sup> + 7</code>.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: nums = [2,1,3]<br/>
<b>Output</b>: 1<br/>
<b>Explanation</b>: We can reorder nums to be [2,3,1] which will yield the same BST. There are no other ways to reorder nums which will yield the same BST.
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: [3,4,5,1,2]<br/>
<b>Output</b>: 5<br/>
<b>Explanation</b>: The following 5 arrays will yield the same BST:  <br />
[3,1,2,4,5]<br />
[3,1,4,2,5]<br />
[3,1,4,5,2]<br />
[3,4,1,2,5]<br />
[3,4,1,5,2]
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: nums = [1,2,3]<br/>
<b>Output</b>: 0<br/>
</p>
</blockquote>

<b>Example 4:</b>
<blockquote>
<p>
<b>Input</b>: nums = [9,4,2,1,3,6,5,7,8,14,11,10,12,13,16,15,17,18]<br/>
<b>Output</b>: 216212978<br/>
<b>Explanation</b>: The number of ways to reorder nums to get the same BST is 3216212999. Taking this number modulo 10^<sup>9</sup> + 7 gives 216212978.
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
O(N<sup>2</sup>) Where <br />
N is number of elements in an input array nums
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N * N) Where <br >
N is number of elements in an input array nums
</p>
</blockquote>