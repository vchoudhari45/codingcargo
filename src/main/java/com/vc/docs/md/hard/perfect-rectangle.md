[comment]: metadata=Java Solution to problem Perfect Rectangle using Set Data Structure.
[comment]: keywords=PerfectRectangle, Set Data Structure
[comment]: robots=index, follow


<h1>Perfect Rectangle</h1>
<p>
This page explains Java solution to problem <code class="inline">Perfect Rectangle</code> using <code class="inline">Set</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given <code class="inline">N</code> axis-aligned rectangles where <code class="inline">N > 0</code>, determine if they all together form an exact cover of a rectangular region.
</p>
<p>
Each rectangle is represented as a <code class="inline">bottom-left</code> point and a <code class="inline">top-right</code> point. For example, a unit square is represented as <code class="inline">[1,1,2,2]</code>. (coordinate of bottom-left point is <code class="inline">(1, 1)</code> and <code class="inline">top-right</code> point is <code class="inline">(2, 2)</code>).
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: <br/>
rectangles = [<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[1,1,3,3],<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3,1,4,2],<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3,2,4,4],<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[1,3,2,4],<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[2,3,3,4]<br />
]<br />
<b>Output</b>: Return true. <br/>
<b>Explanation</b>: All 5 rectangles together form an exact cover of a rectangular region.<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: <br/>
rectangles = [ <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[1,1,2,3],<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[1,3,2,4],<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3,1,4,2],<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3,2,4,4]<br />
]<br />
<b>Output</b>: Return false<br/>
<b>Explanation</b>: Because there is a gap between the two rectangular regions.<br/>
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: <br/>
rectangles = [<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[1,1,3,3],<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3,1,4,2],<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[1,3,2,4],<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3,2,4,4]<br />
]<br />
<b>Output</b>: Return false<br/>
<b>Explanation</b>: Because there is a gap in the top center.<br/>
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
N is total number of rectangle in an input array rectangles 
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is total number of rectangle in an input array rectangles 
</p>
</blockquote>