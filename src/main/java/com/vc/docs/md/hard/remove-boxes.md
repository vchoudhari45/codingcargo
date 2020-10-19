[comment]: metadata=Java Solution to problem Remove Boxes using Dynamic Programming algorithm.
[comment]: keywords=Remove Boxes, Dynamic Programming Algorithm
[comment]: robots=index, follow


<h1>Remove Boxes</h1>
<p>
This page explains Java solution to problem <code class="inline">Remove Boxes</code> using <code class="inline">Dynamic Programming</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given several boxes with different colors represented by different positive numbers.
</p>
<p>
You may experience several rounds to remove boxes until there is no box left. Each time you can choose some continuous boxes with the same color (composed of <code class="inline">k</code> boxes, <code class="inline">k >= 1</code>), remove them and get <code class="inline">k * k</code> points. Find the maximum points you can get.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: boxes = [1,3,2,2,2,3,4,3,1]<br/>
<b>Output</b>: 23<br/>
<b>Explanation</b>: <br/>
[1, 3, 2, 2, 2, 3, 4, 3, 1] <br /> 
----> [1, 3, 3, 4, 3, 1] (3*3=9 points) <br /> 
----> [1, 3, 3, 3, 1] (1*1=1 points) <br />
----> [1, 1] (3*3=9 points) <br />
----> [] (2*2=4 points) <br />
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
O(N<sup>4</sup>) Where <br />
N is total number of elements in an input array.
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N<sup>3</sup>) Where <br />
N is total number of elements in an input array
</p>
</blockquote>