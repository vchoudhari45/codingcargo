[comment]: metadata=Java Solution to problem Count All Possible Routes using Dynamic Programming.
[comment]: keywords=Count All Possible Routes, Dynamic Programming
[comment]: robots=index, follow


<h1>Count All Possible Routes</h1>
<p>
This page explains Java solution to problem <code class="inline">Count All Possible Routes</code> using <code class="inline">Dynamic Programming</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
You are given an array of distinct positive integers locations where <code class="inline">locations[i]</code> represents the position of city <code class="inline">i</code>. You are also given integers <code class="inline">start</code>, <code class="inline">finish</code> and <code class="inline">fuel</code> representing the starting city, ending city, and the initial amount of fuel you have, respectively.
</p>
<p>
At each step, if you are at city <code class="inline">i</code>, you can pick any city <code class="inline">j</code> such that <code class="inline">j != i</code> and <code class="inline">0 <= j < locations.length</code> and move to city <code class="inline">j</code>. Moving from city <code class="inline">i</code> to city <code class="inline">j</code> reduces the amount of fuel you have by <code class="inline">|locations[i] - locations[j]|</code>. Please notice that <code class="inline">|x|</code> denotes the absolute value of <code class="inline">x</code>.
</p>
<p>
Notice that fuel cannot become negative at any point in time, and that you are allowed to visit any city more than once (including start and finish).
</p>
<p>
Return the count of all possible routes from start to finish.
</p>
<p>
Since the answer may be too large, return it modulo <code class="inline">10^<sup>9</sup> + 7</code>.
</p>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: locations = [2,3,6,8,4], start = 1, finish = 3, fuel = 5<br/>
<b>Output</b>: 4<br/>
<b>Explanation</b>: The following are all possible routes, each uses 5 units of fuel:<br />
1 -> 3<br />
1 -> 2 -> 3<br />
1 -> 4 -> 3<br />
1 -> 4 -> 2 -> 3<br />
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: locations = [4,3,1], start = 1, finish = 0, fuel = 6<br/>
<b>Output</b>: 5<br/>
<b>Explanation</b>: The following are all possible routes:
1 -> 0, used fuel = 1<br />
1 -> 2 -> 0, used fuel = 5<br />
1 -> 2 -> 1 -> 0, used fuel = 5<br />
1 -> 0 -> 1 -> 0, used fuel = 3<br />
1 -> 0 -> 1 -> 0 -> 1 -> 0, used fuel = 5<br />
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: locations = [5,2,1], start = 0, finish = 2, fuel = 3<br/>
<b>Output</b>: 0<br/>
</p>
</blockquote>

<b>Example 4:</b>
<blockquote>
<p>
<b>Input</b>: locations = [1,2,3], start = 0, finish = 2, fuel = 40<br/>
<b>Output</b>: 615088286<br/>
<b>Explanation</b>: The total number of possible routes is 2615088300. Taking this number modulo 10^<sup>9</sup> + 7 gives us 615088286.
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
O(N<sup>2</sup> * Fuel) Where <br />
N is total number of locations in an input array<br />
Fuel is starting quantity of fuel
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N * Fuel) Where <br />
N is total number of locations in an input array<br />
Fuel is starting quantity of fuel
</p>
</blockquote>