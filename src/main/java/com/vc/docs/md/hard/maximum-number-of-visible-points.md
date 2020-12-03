[comment]: metadata=Java Solution to problem Maximum Number of Visible Points using Geometry.
[comment]: keywords=Maximum Number of Visible Points, Geometry
[comment]: robots=index, follow


<h1>Maximum Number of Visible Points</h1>
<p>
This page explains Java solution to problem <code class="inline">Maximum Number of Visible Points</code> using <code class="inline">Geometry</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
You are given an array <code class="inline">points</code>, an integer <code class="inline">angle</code>, and your <code class="inline">location</code>, where <code class="inline">location = [posx, posy]</code> and <code class="inline">points[i] = [xi, yi]</code> both denote integral coordinates on the X-Y plane.
</p>
<p>
Initially, you are facing directly east from your position. You cannot move from your position, but you can rotate. In other words, <code class="inline">pos<sub>x</sub></code> and <code class="inline">pos<sub>y</sub></code> cannot be changed. Your field of view in degrees is represented by angle, determining how wide you can see from any given view direction. Let <code class="inline">d</code> be the amount in degrees that you rotate counterclockwise. Then, your field of view is the inclusive range of angles <code class="inline">[d - angle/2, d + angle/2]</code>.
</p>
<p>
You can see some set of points if, for each point, the angle formed by the point, your position, and the immediate east direction from your position is in your field of view.
</p>
<p>
There can be multiple points at one coordinate. There may be points at your location, and you can always see these points regardless of your rotation. Points do not obstruct your vision to other points.
</p>
<p>
Return the maximum number of points you can see.
</p>

<p>Constraints:</p>
<p>
<code class="inline">1 &lt;= points.length &lt;= 10<sup>5</sup></code><br />
<code class="inline">points[i].length == 2</code><br />
<code class="inline">location.length == 2</code><br />
<code class="inline">0 &lt;= angle < 360</code><br />
<code class="inline">0 &lt;= pos<sub>x</sub>, pos<sub>y</sub>, xi, yi &lt;= 10<sup>9</sup></code>
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: points = [[2,1],[2,2],[3,3]], angle = 90, location = [1,1]<br/>
<b>Output</b>: 3<br/>
<b>Explanation</b>: The shaded region represents your field of view. All points can be made visible in your field of view, including [3,3] even though [2,2] is in front and in the same line of sight.
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: [[2,1],[2,2],[3,4],[1,1]], angle = 90, location = [1,1]<br/>
<b>Output</b>: 4<br/>
<b>Explanation</b>: All points can be made visible in your field of view, including the one at your location.
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: points = [[1,0],[2,1]], angle = 13, location = [1,1]<br/>
<b>Output</b>: 1<br/>
<b>Explanation</b>: You can only see one of the two points, as shown above.
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
O(N + N logN) Where <br />
N is number of elements in an input array points 
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br >
N is number of elements in an input array points 
</p>
</blockquote>