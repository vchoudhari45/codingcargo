[comment]: metadata=Java Solution to problem K Empty Slots using TreeSet Data Structure.
[comment]: keywords=K Empty Slots, Tree Data Structure
[comment]: robots=index, follow


<h1>K Empty Slots</h1>
<p>
This page explains Java solution to problem <code class="inline">K Empty Slots</code> using <code class="inline">TreeSet</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
You have <code class="inline">n</code> bulbs in a row numbered from <code class="inline">1</code> to <code class="inline">n</code>. Initially, all the bulbs are turned off. We turn on exactly one bulb every day until all bulbs are on after <code class="inline">n</code> days.
</p>
<p>
You are given an array bulbs of length <code class="inline">n</code> where <code class="inline">bulbs[i] = x</code> means that on the <code class="inline">(i+1)<sup>th</sup></code> day, we will turn on the bulb at position <code class="inline">x</code> where <code class="inline">i</code> is <code class="inline">0-indexed</code> and <code class="inline">x</code> is <code class="inline">1-indexed</code>.
</p>
<p>
Given an integer <code class="inline">k</code>, return the minimum day number such that there exists two turned on bulbs that have exactly <code class="inline">k</code> bulbs between them that are all turned off. If there isn't such day, return <code class="inline">-1</code>.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: bulbs = [1,3,2], k = 1<br/>
<b>Output</b>: 2<br/>
<b>Explanation</b>: <br/>
On the first day: bulbs[0] = 1, first bulb is turned on: [1,0,0]  <br />
On the second day: bulbs[1] = 3, third bulb is turned on: [1,0,1] <br />
On the third day: bulbs[2] = 2, second bulb is turned on: [1,1,1] <br />
We return 2 because on the second day, there were two on bulbs with one off bulb between them.
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: bulbs = [1,2,3], k = 1<br/>
<b>Output</b>: -1<br/>
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
O(N * log N) Where <br />
N is total number of bulbs in an input array.
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is total number of bulbs in an input array.
</p>
</blockquote>