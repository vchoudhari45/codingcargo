[comment]: metadata=Java Solution to problem IPO using Priority Queue Data Structure.
[comment]: keywords=IPO, Priority Queue Data Structure.
[comment]: robots=index, follow


<h1>IPO</h1>
<p>
This page explains Java solution to problem <code class="inline">IPO</code> using <code class="inline">Priority Queue</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most <code class="inline">k</code> distinct projects.
</p>
<p>
You are given several projects. For each project <code class="inline">i</code>, it has a pure profit <code class="inline">Pi</code> and a minimum capital of <code class="inline">Ci</code> is needed to start the corresponding project. Initially, you have <code class="inline">W</code> capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
</p>
<p>
To sum up, pick a list of at most <code class="inline">k</code> distinct projects from given projects to maximize your final capital, and output your final maximized capital.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1]<br/>
<b>Output</b>: 4<br/>
<b>Explanation</b>: <br/>
Since your initial capital is 0, you can only start the project indexed 0. <br />
After finishing it you will obtain profit 1 and your capital becomes 1. <br />
With capital 1, you can either start the project indexed 1 or the project indexed 2.<br />
Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.<br />
Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
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
N is total number of elements in an input array profit & capitals
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is total number of elements in an input array profit & capitals
</p>
</blockquote>