[comment]: metadata=Java Solution to problem Cut Off Trees for Golf Event using Hadlock Algorithm.
[comment]: keywords=Median of Two Sorted Arrays, Breadth-First-Search, Hadlock Algorithm
[comment]: robots=index, follow


<h1>Cut Off Trees for Golf Event</h1>
<p>
This page explains Java solution to problem <code class="inline">Cut Off Trees for Golf Event</code> using <code class="inline">Hadlock</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative <code class="inline">2D</code> map, in this map:
</p>
<ul>
<li>0 represents the obstacle can't be reached.</li>
<li>1 represents the ground can be walked through.</li>
<li>The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.</li>
</ul>
<p>
In one step you can walk in any of the four directions top, bottom, left and right also when standing in a point which is a tree you can decide whether or not to cut off the tree.
</p>
<p>
You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value <code class="inline">1</code>).
</p>
<p>
You will start from the point <code class="inline">(0, 0)</code> and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output <code class="inline">-1</code> in that situation.
</p>
<p>
You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: <br />
[<br />
[1,2,3], <br />
[0,0,4], <br /> 
[7,6,5] <br />
] <br />
<b>Output</b>: 6<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: <br />
[<br />
[1,2,3], <br />
[0,0,0], <br /> 
[7,6,5] <br />
] <br />
<b>Output</b>: -1<br/>
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: <br />
[<br />
[2,3,4], <br />
[0,0,5], <br /> 
[8,7,6] <br />
] <br />
<b>Output</b>: 6<br/>
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
O(MN * log MN + MN<sup>2</sup>) Where <br />
M is total number of rows in an input forest <br />
N is total number of cols in an input forest
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(M * N) Where <br />
M is total number of rows in an input forest <br />
N is total number of cols in an input forest
</p>
</blockquote>