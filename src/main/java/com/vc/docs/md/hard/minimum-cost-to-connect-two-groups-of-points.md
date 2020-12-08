[comment]: metadata=Java Solution to problem Minimum Cost to Connect Two Groups of Points using Bit Masking.
[comment]: keywords=Minimum Cost to Connect Two Groups of Points, Bit Masking
[comment]: robots=index, follow


<h1>Minimum Cost to Connect Two Groups of Points</h1>
<p>
This page explains Java solution to problem <code class="inline">Minimum Cost to Connect Two Groups of Points</code> using <code class="inline">Bit Masking</code>.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
You are given two groups of points where the first group has <code class="inline">size1</code> points, the second group has <code class="inline">size2</code> points, and <code class="inline">size1 >= size2</code>.
</p>
<p>
The cost of the connection between any two points are given in an <code class="inline">size1 x size2</code> matrix where <code class="inline">cost[i][j]</code> is the cost of connecting point <code class="inline">i</code> of the first group and point <code class="inline">j</code> of the second group. The groups are connected if each point in both groups is connected to one or more points in the opposite group. In other words, each point in the first group must be connected to at least one point in the second group, and each point in the second group must be connected to at least one point in the first group.
</p>
<p>
Return the minimum cost it takes to connect the two groups.
</p>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: cost = [[15, 96], [36, 2]]<br/>
<b>Output</b>: 17<br/>
<b>Explanation</b>: The optimal way of connecting the groups is: <br />
1--A<br />
2--B<br />
This results in a total cost of 17.
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: cost = [[1, 3, 5], [4, 1, 1], [1, 5, 3]]<br/>
<b>Output</b>: 4<br/>
<b>Explanation</b>: The optimal way of connecting the groups is: <br />
1--A<br />
2--B<br />
2--C<br />
3--A<br />
This results in a total cost of 4.<br />
Note that there are multiple points connected to point 2 in the first group and point A in the second group. This does not matter as there is no limit to the number of points that can be connected. We only care about the minimum total cost.<br />
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: cost = [[2, 5, 1], [3, 4, 7], [8, 1, 2], [6, 2, 4], [3, 8, 8]]<br/>
<b>Output</b>: 10<br/>
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
O(NM * 2<sup>M</sup>) Where <br />
N is number of elements in a group1 <br />
M is number of elements in a group2 <br />
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(2<sup>M</sup>) Where <br >
M is number of elements in a group2 <br />
</p>
</blockquote>