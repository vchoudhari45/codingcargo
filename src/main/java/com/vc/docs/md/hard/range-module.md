[comment]: metadata=Java Solution to problem Range Module using TreeMap Data Structure.
[comment]: keywords=Range Module, TreeMap Data Structure
[comment]: robots=index, follow


<h1>Range Module</h1>
<p>
This page explains Java solution to problem <code class="inline">Range Module</code> using <code class="inline">TreeMap</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following interfaces in an efficient manner.
</p>
<ul>
<li><code class="inline">addRange(int left, int right)</code> Adds the half-open interval <code class="inline">[left, right)</code>, tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval <code class="inline">[left, right)</code> that are not already tracked.</li>
<li><code class="inline">queryRange(int left, int right)</code> Returns true if and only if every real number in the interval <code class="inline">[left, right)</code> is currently being tracked.</li>
<li><code class="inline">removeRange(int left, int right)</code> Stops tracking every real number currently being tracked in the interval <code class="inline">[left, right)</code>.</li>
</ul>

<b>Example 1:</b>
<blockquote>
<p>
addRange(10, 20): null <br />
removeRange(14, 16): null <br />
queryRange(10, 14): true (Every number in [10, 14) is being tracked) <br />
queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked) <br />
queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite the remove operation) <br />
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
addRange(int left, int right): O(log N) <br />
queryRange(int left, int right): O(log N) <br />
removeRange(int left, int right): O(log N) Where <br />
N is total number of ranges in a RangeModule
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is total number of ranges in a RangeModule
</p>
</blockquote>