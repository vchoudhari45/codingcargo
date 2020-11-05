[comment]: metadata=Java Solution to problem Course Schedule III using Priority Queue Data Structure.
[comment]: keywords=Course Schedule III, Priority Queue Data Structure.
[comment]: robots=index, follow


<h1>Course Schedule III</h1>
<p>
This page explains Java solution to problem <code class="inline">Course Schedule III</code> using <code class="inline">Priority Queue</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
There are <code class="inline">n</code> different online courses numbered from <code class="inline">1</code> to <code class="inline">n</code>. Each course has some duration(course length) <code class="inline">t</code> and closed on dth day. A course should be taken continuously for <code class="inline">t</code> days and must be finished before or on the <code class="inline">dth</code> day. You will start at the <code class="inline">1st</code> day.
</p>
<p>
Given <code class="inline">n</code> online courses represented by pairs <code class="inline">(t,d)</code>, your task is to find the maximal number of courses that can be taken.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]<br/>
<b>Output</b>: 3<br/>
<b>Explanation</b>: There're totally 4 courses, but you can take 3 courses at most: <br/>
First, take the 1st course, it costs 100 days so you will finish it on the 100th day, and ready to take the next course on the 101st day.<br/>
Second, take the 3rd course, it costs 1000 days so you will finish it on the 1100th day, and ready to take the next course on the 1101st day.<br/> 
Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day. <br/>
The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.
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
N is total number of course in an input array.
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is total number of course in an input array.
</p>
</blockquote>