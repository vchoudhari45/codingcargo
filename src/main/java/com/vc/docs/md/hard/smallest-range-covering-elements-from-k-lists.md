[comment]: metadata=Java Solution to problem Smallest Range Covering Elements from K Lists using Priority Queue Data Structure.
[comment]: keywords=Smallest Range Covering Elements from K Lists, Priority Queue Data Structure
[comment]: robots=index, follow


<h1>Smallest Range Covering Elements from K Lists</h1>
<p>
This page explains Java solution to problem <code class="inline">Smallest Range Covering Elements from K Lists</code> using <code class="inline">Priority Queue</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
You have <code class="inline">k</code> lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the <code class="inline">k</code> lists.
</p>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]<br/>
<b>Output</b>: [20,24]<br/>
<b>Explanation</b>: List 1: [4, 10, 15, 24,26], 24 is in range [20,24].<br/>
List 2: [0, 9, 12, 20], 20 is in range [20,24].<br/>
List 3: [5, 18, 22, 30], 22 is in range [20,24].<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: nums = [[1,2,3],[1,2,3],[1,2,3]]<br/>
<b>Output</b>: [1,1]<br/>
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: nums = [[10,10],[11,11]]<br/>
<b>Output</b>: [10,11]<br/>
</p>
</blockquote>

<b>Example 4:</b>
<blockquote>
<p>
<b>Input</b>: nums = [[1],[2],[3],[4],[5],[6],[7]]<br/>
<b>Output</b>: [1,7]<br/>
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
O(N * Log K) Where <br />
K is size of nums <br />
N is max of (nums[0].size(), nums[1].size() .... nums[k].size())
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(K) Where <br />
K is length of nums <br />
N is max of (nums[0].size(), nums[1].size() .... nums[k].size())
</p>
</blockquote>