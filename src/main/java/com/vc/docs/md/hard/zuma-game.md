[comment]: metadata=Java Solution to problem Zuma Game using Backtracking.
[comment]: keywords=Zuma Game, Backtracking
[comment]: robots=index, follow


<h1>Zuma Game</h1>
<p>
This page explains Java solution to problem <code class="inline">Zuma Game</code> using <code class="inline">Backtracking</code>.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Think about Zuma Game. You have a row of balls on the table, colored red(R), yellow(Y), blue(B), green(G), and white(W). You also have several balls in your hand.
</p>
<p>
Each time, you may choose a ball in your hand, and insert it into the row (including the leftmost place and rightmost place). Then, if there is a group of <code class="inline">3</code> or more balls in the same color touching, remove these balls. Keep doing this until no more balls can be removed.
</p>
<p>
Find the minimal balls you have to insert to remove all the balls on the table. If you cannot remove all the balls, output <code class="inline">-1</code>.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: board = "WRRBBW", hand = "RB"<br/>
<b>Output</b>: -1<br/>
<b>Explanation</b>: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: board = "WWRRBBWW", hand = "WRBRW"<br/>
<b>Output</b>: 2<br/>
<b>Explanation</b>: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty<br/>
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
O(2<sup>N</sup>) Where <br />
N is length of input string board
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(M) Where <br />
M is length of input string hand
</p>
</blockquote>