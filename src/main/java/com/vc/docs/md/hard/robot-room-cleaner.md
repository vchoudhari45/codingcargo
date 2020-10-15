[comment]: metadata=Java Solution to problem Robot Room Cleaner using Depth First Search Algorithm.
[comment]: keywords=Robot Room Cleaner, Depth First Search Algorithm
[comment]: robots=index, follow


<h1>Robot Room Cleaner</h1>
<p>
This page explains Java solution to problem <code class="inline">Robot Room Cleaner</code> using <code class="inline">Depth First Search</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given a robot cleaner in a room modeled as a grid. Each cell in the grid can be empty or blocked.
</p>
<p>
The robot cleaner with <code class="inline">4</code> given APIs can move forward, turn left or turn right. Each turn it made is <code class="inline">90</code> degrees.
</p>
<p>
When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.
</p>
<p>
Design an algorithm to clean the entire room using only the <code class="inline">4</code> given APIs shown below.
</p>
<pre>
<code class="language-java">
/**
 * This is the robot's control interface.
 * You should not implement it, or speculate about its implementation
 **/
interface Robot {
    /**
     * Returns true if the cell in front is open and robot moves into the cell.
     * Returns false if the cell in front is blocked and robot stays in the current cell.
     **/
    boolean move(); <br />
    /**
     * Robot will stay in the same cell after calling turnLeft/turnRight.
     * Each turn will be 90 degrees.
     **/
    void turnLeft();
    void turnRight(); <br />
    /**
     * Clean the current cell.
     **/
    void clean();
}
</code>
</pre>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: A = [1,3], B = [2]<br/>
<b>Output</b>: 2.00000<br/>
<b>Explanation</b>: merged array = [1,2,3] and median is 2<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: <br/>
room = [<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[1,1,1,1,1,0,1,1],<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[1,1,1,1,1,0,1,1],<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[1,0,1,1,1,1,1,1],<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[0,0,0,1,0,0,0,0],<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[1,1,1,1,1,1,1,1]<br />
],<br />
<b>Output</b>: Your Program should visit each cell once<br/>
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
O(N - M) Where <br />
N is total number of empty cell in an input grid<br />
M is total number of obstacles in an input grid
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N - M) Where <br />
N is total number of empty cell in an input grid<br />
M is total number of obstacles in an input grid
</p>
</blockquote>