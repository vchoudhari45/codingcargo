[comment]: metadata=Java Solution to problem Remove Max Number of Edges to Keep Graph Fully Traversable using Graph Data Structure.
[comment]: keywords=Remove Max Number of Edges to Keep Graph Fully Traversable, Graph Data Structure.
[comment]: robots=index, follow


<h1>Remove Max Number of Edges to Keep Graph Fully Traversable</h1>
<p>
This page explains Java solution to problem <code class="inline">Remove Max Number of Edges to Keep Graph Fully Traversable</code> using <code class="inline">Graph</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Alice and Bob have an undirected graph of <code class="inline">n</code> nodes and <code class="inline">3</code> types of edges:
</p>

<ul>
<li>Type 1: Can be traversed by Alice only.</li>
<li>Type 2: Can be traversed by Bob only.</li>
<li>Type 3: Can by traversed by both Alice and Bob.</li>
</ul>

<p>
Given an array edges where <code class="inline">edges[i] = [type<sub>i</sub>, u<sub>i</sub>, v<sub>i</sub>]</code> represents a bidirectional edge of type type<sub>i</sub> between nodes u<sub>i</sub> and v<sub>i</sub>, find the maximum number of edges you can remove so that after removing the edges, the graph can still be fully traversed by both Alice and Bob. The graph is fully traversed by Alice and Bob if starting from any node, they can reach all other nodes.
</p>
<p>
Return the maximum number of edges you can remove, or return <code class="inline">-1</code> if it's impossible for the graph to be fully traversed by Alice and Bob.
</p>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]<br/>
<b>Output</b>: [[1,2],[2,3]]<br/>
<b>Explanation</b>: If we remove the 2 edges [1,1,2] and [1,1,3]. The graph will still be fully traversable by Alice and Bob. Removing any additional edge will not make it so. So the maximum number of edges we can remove is 2.
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]<br/>
<b>Output</b>: 0<br/>
<b>Explanation</b>: Notice that removing any edge will not make the graph fully traversable by Alice and Bob.
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>:  n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]<br/>
<b>Output</b>:  -1 <br/>
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
O(M * log(N)) Where <br />
N is number of nodes<br />
M is number of edges in an input array edges
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br >
N is number of nodes<br />
</p>
</blockquote>