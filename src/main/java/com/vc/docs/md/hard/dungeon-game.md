[comment]: metadata=Java Solution to problem Dungeon Game using Dynamic Programming.
[comment]: keywords=Dungeon Game, Dynamic Programming
[comment]: robots=index, follow


<h1>Dungeon Game</h1>
<p>
This page explains Java solution to problem <code class="inline">Dungeon Game</code> using <code class="inline">Dynamic Programming</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
The demons had captured the princess <code class="inline">P</code> and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of <code class="inline">M x N</code> rooms laid out in a 2D grid. Our valiant knight <code class="inline">K</code> was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
</p>
<p>
The knight has an initial health point represented by a positive integer. If at any point his health point drops to <code class="inline">0</code> or below, he dies immediately.
</p>
<p>
Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty <code class="inline">0's</code> or contain magic orbs that increase the knight's health (positive integers).
</p>
<p>
In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
</p>
<p>
Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
</p>


<b>Example 1:</b>
<b>Input</b><br/>
<img class="paragraph-heading" src="####BASEURL####dungeon-game/dungeon.jpg" alt="Dungeon Game Input" /> <br />
<b>Output</b>: 7<br/>
<b>Explanation</b>: <br />
For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path <code class="inline">RIGHT-> RIGHT -> DOWN -> DOWN</code>.<br/>


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
O(M * N) Where <br />
M is number of rows in an input array <br />
N is number of cols in an input array <br />
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(M * N) Where <br />
M is number of rows in an input array <br />
N is number of cols in an input array <br />
</p>
</blockquote>