[comment]: metadata=Java Solution to problem The Skyline Problem using TreeMap Data Structure.
[comment]: keywords=The Skyline Problem, TreeMap Data Structure
[comment]: robots=index, follow


<h1>The Skyline Problem</h1>
<p>
This page explains Java solution to problem <code class="inline">The Skyline Problem</code> using <code class="inline">TreeMap</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo <code class="inline">(Figure A)</code>, write a program to output the skyline formed by these buildings collectively <code class="inline">(Figure B)</code>.
</p>
<img class="paragraph-heading" src="####BASEURL####skyline/skyline-1.jpg" alt="Skyline Problem" /> 
<p class="paragraph-heading">
The geometric information of each building is represented by a triplet of integers <code class="inline">[Li, Ri, Hi]</code>, where <code class="inline">Li</code> and <code class="inline">Ri</code> are the <code class="inline">x</code> coordinates of the left and right edge of the ith building, respectively, and <code class="inline">Hi</code> is its height. It is guaranteed that <code class="inline">0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0</code>. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height <code class="inline">0</code>.
</p>
<p>
For instance, the dimensions of all buildings in Figure A are recorded as: <code class="inline">[[2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8]]</code>.
</p>
<p>
The output is a list of "key points" (red dots in Figure B) in the format of <code class="inline">[ [x1,y1], [x2, y2], [x3, y3], ... ]</code> that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
</p>
<p>
For instance, the skyline in Figure <code class="inline">B</code> should be represented as:<code class="inline">[[2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0]]</code>.
</p>


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
O(N log N) Where <br />
N is total number of buildings in an input array <br />
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is total number of buildings in an input array <br />
</p>
</blockquote>