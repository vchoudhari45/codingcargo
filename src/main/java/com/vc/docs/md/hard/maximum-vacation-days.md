[comment]: metadata=Java Solution to problem Maximum Vacation Days using Priority Queue.
[comment]: keywords=Maximum Vacation Days, Priority Queue.
[comment]: robots=index, follow


<h1>Maximum Vacation Days</h1>
<p>
This page explains Java solution to problem <code class="inline">Maximum Vacation Days</code> using <code class="inline">Priority Queue</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
LeetCode wants to give one of its best employees the option to travel among <code class="inline">N</code> cities to collect algorithm problems. But all work and no play makes Jack a dull boy, you could take vacations in some particular cities and weeks. Your job is to schedule the traveling to maximize the number of vacation days you could take, but there are certain rules and restrictions you need to follow.
</p>
Rules and restrictions:
<ul>
<li>You can only travel among <code class="inline">N</code> cities, represented by indexes from <code class="inline">0</code> to <code class="inline">N-1</code>. Initially, you are in the city indexed <code class="inline">0</code> on Monday.</li>
<li>The cities are connected by flights. The flights are represented as a <code class="inline">N * N</code> matrix (not necessary symmetrical), called flights representing the airline status from the city <code class="inline">i</code> to the city <code class="inline">j</code>. If there is no flight from the city <code class="inline">i</code> to the city <code class="inline">j</code>, <code class="inline">flights[i][j] = 0</code>; Otherwise, <code class="inline">flights[i][j] = 1</code>. Also, <code class="inline">flights[i][i] = 0</code> for all <code class="inline">i</code>.</li>
<li>You totally have <code class="inline">K</code> weeks (each week has <code class="inline">7</code> days) to travel. You can only take flights at most once per day and can only take flights on each week's Monday morning. Since flight time is so short, we don't consider the impact of flight time.</li>
<li>For each city, you can only have restricted vacation days in different weeks, given an <code class="inline">N * K</code> matrix called days representing this relationship. For the value of <code class="inline">days[i][j]</code>, it represents the maximum days you could take vacation in the city <code class="inline">i</code> in the week <code class="inline">j</code>.</li>
</ul>
<p>
You're given the flights matrix and days matrix, and you need to output the maximum vacation days you could take during <code class="inline">K</code> weeks.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: flights = [[0,1,1],[1,0,1],[1,1,0]], days = [[1,3,1],[6,0,3],[3,3,3]]<br/>
<b>Output</b>: 12<br/>
<b>Explanation</b>: Ans = 6 + 3 + 3 = 12.<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: flights = [[0,0,0],[0,0,0],[0,0,0]], days = [[1,1,1],[7,7,7],[7,7,7]]<br/>
<b>Output</b>: 3<br/>
<b>Explanation</b>: Ans = 1 + 1 + 1 = 3.<br/>
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: flights = [[0,1,1],[1,0,1],[1,1,0]], days = [[7,0,0],[0,7,0],[0,0,7]]<br/>
<b>Output</b>: 21<br/>
<b>Explanation</b>: Ans = 7 + 7 + 7 = 21.<br/>
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
O(K * log N) Where <br />
K is total number of weeks <br />
N is total number of cities
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is total number of cities
</p>
</blockquote>