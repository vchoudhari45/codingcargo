[comment]: metadata=Java Solution to problem Maximum Number of Achievable Transfer Requests using Bit Manipulation.
[comment]: keywords=Maximum Number of Achievable Transfer Requests, Bit Manipulation
[comment]: robots=index, follow


<h1>Maximum Number of Achievable Transfer Requests</h1>
<p>
This page explains Java solution to problem <code class="inline">Maximum Number of Achievable Transfer Requests</code> using <code class="inline">Bit Manipulation</code>.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
We have <code class="inline">n</code> buildings numbered from <code class="inline">0</code> to <code class="inline">n - 1</code>. Each building has a number of employees. It's transfer season, and some employees want to change the building they reside in.
</p>
<p>
You are given an array requests where <code class="inline">requests[i] = [from<sub>i</sub>, to<sub>i</sub>]</code> represents an employee's request to transfer from building from<sub>i</sub> to building to<sub>i</sub>.
</p>
<p>
All buildings are full, so a list of requests is achievable only if for each building, the net change in employee transfers is zero. This means the number of employees leaving is equal to the number of employees moving in. For example if <code class="inline">n = 3</code> and two employees are leaving building <code class="inline">0</code>, one is leaving building <code class="inline">1</code>, and one is leaving building <code class="inline">2</code>, there should be two employees moving to building <code class="inline">0</code>, one employee moving to building <code class="inline">1</code>, and one employee moving to building <code class="inline">2</code>.
</p>
<p>Return the maximum number of achievable requests</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: n = 5, requests = [[0,1],[1,0],[0,1],[1,2],[2,0],[3,4]]<br/>
<b>Output</b>: 5 <br/>
<b>Explanation</b>: Let's see the requests: <br />
From building 0 we have employees x and y and both want to move to building 1. <br />
From building 1 we have employees a and b and they want to move to buildings 2 and 0 respectively. <br />
From building 2 we have employee z and they want to move to building 0. <br />
From building 3 we have employee c and they want to move to building 4. <br />
From building 4 we don't have any requests. <br />
We can achieve the requests of users x and b by swapping their places. <br />
We can achieve the requests of users y, a and z by swapping the places in the 3 buildings.
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: n = 3, requests = [[0,0],[1,2],[2,1]]<br/>
<b>Output</b>: 3<br/>
<b>Explanation</b>:  Let's see the requests: <br />
From building 0 we have employee x and they want to stay in the same building 0. <br />
From building 1 we have employee y and they want to move to building 2. <br />
From building 2 we have employee z and they want to move to building 1. <br />
We can achieve all the requests.
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: n = 4, requests = [[0,3],[3,1],[1,2],[2,0]]<br/>
<b>Output</b>: 4<br/>
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
O(R) Where <br />
2<sup>R</sup> is number requests in request input array
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br >
N is number buildings<br />
</p>
</blockquote>