[comment]: metadata=Java Solution to problem Find Servers That Handled Most Number of Requests using TreeMap Data Structure.
[comment]: keywords=Find Servers That Handled Most Number of Requests, TreeMap Data Structure
[comment]: robots=index, follow


<h1>Find Servers That Handled Most Number of Requests</h1>
<p>
This page explains Java solution to problem <code class="inline">Find Servers That Handled Most Number of Requests</code> using <code class="inline">TreeMap</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
You have <code class="inline">k</code> servers numbered from <code class="inline">0</code> to <code class="inline">k - 1</code> that are being used to handle multiple requests simultaneously. Each server has infinite computational capacity but cannot handle more than one request at a time. The requests are assigned to servers according to a specific algorithm:
</p>
<ul>
<li>The <code class="inline">i<sup>th</sup></code> <code class="inline">(0-indexed)</code> request arrives.</li>
<li>If all servers are busy, the request is dropped (not handled at all).</li>
<li>If the <code class="inline">(i % k)<sup>th</sup></code> server is available, assign the request to that server.</li>
Otherwise, assign the request to the next available server (wrapping around the list of servers and starting from <code class="inline">0</code> if necessary). For example, if the ith server is busy, try to assign the request to the <code class="inline">(i + 1)<sup>th</sup></code> server, then the <code class="inline">(i + 2)<sup>th</sup></code> server, and so on.</li>
</ul>
<p>
You are given a strictly increasing array arrival of positive integers, where <code class="inline">arrival[i]</code> represents the arrival time of the <code class="inline">i<sup>th</sup></code> request, and another array load, where <code class="inline">load[i]</code> represents the load of the ith request (the time it takes to complete). Your goal is to find the busiest server(s). A server is considered busiest if it handled the most number of requests successfully among all the servers.
</p>
<p>
Return a list containing the IDs <code class="inline">(0-indexed)</code> of the busiest server(s). You may return the IDs in any order.
</p>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: k = 3, arrival = [1,2,3,4,5], load = [5,2,3,3,3]<br/>
<b>Output</b>: [1] <br/>
<b>Explanation</b>: All of the servers start out available. <br />
The first 3 requests are handled by the first 3 servers in order. <br />
Request 3 comes in. Server 0 is busy, so it's assigned to the next available server, which is 1.<br />
Request 4 comes in. It cannot be handled since all servers are busy, so it is dropped. <br />
Servers 0 and 2 handled one request each, while server 1 handled two requests. Hence server 1 is the busiest server.<br />
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: k = 3, arrival = [1,2,3,4], load = [1,2,1,2]<br/>
<b>Output</b>: [0]<br/>
<b>Explanation</b>: The first 3 requests are handled by first 3 servers. <br />
Request 3 comes in. It is handled by server 0 since the server is available. <br />
Server 0 handled two requests, while servers 1 and 2 handled one request each. Hence server 0 is the busiest server. <br />
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: k = 3, arrival = [1,2,3], load = [10,12,11]<br/>
<b>Output</b>: [0,1,2]<br/>
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
O(N * log K)) Where <br />
N is number of request in an input array arrival<br />
K is number of servers to handle request
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(K) Where <br >
K is number of servers to handle request
</p>
</blockquote>