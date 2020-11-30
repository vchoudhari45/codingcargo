[comment]: metadata=Java Solution to problem Fancy Sequence using Math.
[comment]: keywords=Fancy Sequence, Math
[comment]: robots=index, follow


<h1>Fancy Sequence</h1>
<p>
This page explains Java solution to problem <code class="inline">Fancy Sequence</code> using <code class="inline">Math</code>.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Write an API that generates fancy sequences using the <code class="inline">append</code>, <code class="inline">addAll</code>, and <code class="inline">multAll</code> operations.
</p>
<p>Implement the Fancy class:</p>
<ul>
<li><code class="inline">Fancy()</code> Initializes the object with an empty sequence.</li>
<li><code class="inline">void append(val)</code> Appends an integer val to the end of the sequence.</li>
<li><code class="inline">void addAll(inc)</code> Increments all existing values in the sequence by an integer <code class="inline">inc</code>.</li>
<li><code class="inline">void multAll(m)</code> Multiplies all existing values in the sequence by an integer <code class="inline">m</code>.</li>
<li><code class="inline">int getIndex(idx)</code> Gets the current value at index idx (0-indexed) of the sequence modulo <code class="inline">10<sup>9</sup> + 7</code>. If the index is greater or equal than the length of the sequence, return -1</li>
</ul>

<p>
Constraints:
</p>
<ul>
<li><code class="inline">1 <= val, inc, m <= 100</code></li>
<li><code class="inline">0 <= idx <= 105</code></li>
<li>At most <code class="inline">105</code> calls total will be made to <code class="inline">append</code>, <code class="inline">addAll</code>, <code class="inline">multAll</code>, and <code class="inline">getIndex</code>.</li>
</ul>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: 
["Fancy", "append", "addAll", "append", "multAll", "getIndex", "addAll", "append", "multAll", "getIndex", "getIndex", "getIndex"]<br/>
[[], [2], [3], [7], [2], [0], [3], [10], [2], [0], [1], [2]]<br/>
<b>Output</b>: [null, null, null, null, null, 10, null, null, null, 26, 34, 20]<br/>
<b>Explanation</b>: Fancy fancy = new Fancy(); <br />
fancy.append(2);   // fancy sequence: [2] <br />
fancy.addAll(3);   // fancy sequence: [2+3] -> [5] <br />
fancy.append(7);   // fancy sequence: [5, 7] <br />
fancy.multAll(2);  // fancy sequence: [5*2, 7*2] -> [10, 14] <br />
fancy.getIndex(0); // return 10 <br />
fancy.addAll(3);   // fancy sequence: [10+3, 14+3] -> [13, 17] <br />
fancy.append(10);  // fancy sequence: [13, 17, 10] <br />
fancy.multAll(2);  // fancy sequence: [13*2, 17*2, 10*2] -> [26, 34, 20] <br />
fancy.getIndex(0); // return 26 <br />
fancy.getIndex(1); // return 34 <br />
fancy.getIndex(2); // return 20 <br />
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
append() takes O(log MOD) <br />
addAll(inc) takes O(1) <br />
multAll(inc) takes O(1) <br />
getIndex(inc) takes O(1) Where <br />
MOD is 10<sup>9</sup> + 7 
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br >
N is total number elements in Fancy Sequence
</p>
</blockquote>