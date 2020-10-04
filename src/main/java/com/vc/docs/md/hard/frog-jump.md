[comment]: metadata=Java Solution to problem Frog Jump using HashMap Data Structure.
[comment]: keywords=Frog Jump, HashMap Data Structure
[comment]: robots=index, follow


<h1>Frog Jump</h1>
<p>
This page explains Java solution to problem <code class="inline">Frog Jump</code> using <code class="inline">HashMap </code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
A frog is crossing a river. The river is divided into <code class="inline">x</code> units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
</p>
<p>
Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be <code class="inline">1</code> unit.
</p>
<p>
If the frog's last jump was k units, then its next jump must be either <code class="inline">k - 1</code>, <code class="inline">k</code>, or <code class="inline">k + 1</code> units. Note that the frog can only jump in the forward direction.
</p>

<ul>
<li>The number of stones is ≥ 2 and is < 1,100.</li>
<li>Each stone's position will be a non-negative integer < 231.</li>
<li>The first stone's position is always 0.</li>
</ul>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: [0,1,3,5,6,8,12,17]<br/>
<b>Output</b>: true<br/>
<b>Explanation</b>: <br/>
There are a total of 8 stones. <br />
The first stone at the 0th unit, second stone at the 1st unit,<br />
third stone at the 3rd unit, and so on...<br />
The last stone at the 17th unit.<br />
<br />
The frog can jump to the last stone by jumping <br />
1 unit to the 2nd stone, then 2 units to the 3rd stone, then <br />
2 units to the 4th stone, then 3 units to the 6th stone, <br />
4 units to the 7th stone, and 5 units to the 8th stone.<br />
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: [0,1,2,3,4,8,9,11]<br/>
<b>Output</b>: false <br/>
<b>Explanation</b>: <br />
There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.<br/>
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
O(N<sup>2</sup>) Where <br />
N is total number of stones in a stones input array.
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N<sup>2</sup>) Where <br/>
N is total number of stones in a stones input array.
</p>
</blockquote>