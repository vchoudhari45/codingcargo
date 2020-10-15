[comment]: metadata=Java Solution to problem The Maze III using Breadth First Search.
[comment]: keywords=The Maze III, Breadth First Search
[comment]: robots=index, follow


<h1>The Maze III</h1>
<p>
This page explains Java solution to problem <code class="inline">The Maze III</code> using <code class="inline">Breadth First Search</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up <code class="inline">(u)</code>, down <code class="inline">(d)</code>, left <code class="inline">(l)</code> or right <code class="inline">(r)</code>, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction. There is also a hole in this maze. The ball will drop into the hole if it rolls on to the hole.
</p>
<p>
Given the ball position, the hole position and the maze, find out how the ball could drop into the hole by moving the shortest distance. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the hole (included). Output the moving directions by using <code class="inline">'u'</code>, <code class="inline">'d'</code>, <code class="inline">'l'</code> and <code class="inline">'r'</code>. Since there could be several different shortest ways, you should output the lexicographically smallest way. If the ball cannot reach the hole, output "impossible".
</p>
<p>
The maze is represented by a binary <code class="inline">2D</code> array. <code class="inline">1</code> means the wall and <code class="inline">0</code> means the empty space. You may assume that the borders of the maze are all walls. The ball and the hole coordinates are represented by row and column indexes.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: <br/>
maze = [<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0 0 0 0 0 <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1 1 0 0 1 <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0 0 0 0 0 <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0 1 0 0 1 <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0 1 0 0 0 <br />
]<br />
ball coordinate (rowBall, colBall) = (4, 3) <br />
hole coordinate (rowHole, colHole) = (0, 1) <br />
<b>Output</b>: lul<br/>
<b>Explanation</b>: <br/>
There are two shortest ways for the ball to drop into the hole. <br />
The first way is left -> up -> left, represented by "lul".<br />
The second way is up -> left, represented by 'ul'. <br />
Both ways have shortest distance 6, but the first way is lexicographically smaller because 'l' < 'u'. So the output is "lul". <br />
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
O(NM * log(NM)) Where <br />
N is total number of rows in an input array maze <br />
M is total number of cols in an input array maze <br />
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O((MN)<sup>2</sup>) <br />
N is total number of rows in an input array maze <br />
M is total number of cols in an input array maze <br />
</p>
</blockquote>