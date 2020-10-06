[comment]: metadata=Java Solution to problem LFU Cache using HashMap Data Structure.
[comment]: keywords=LFU Cache, HashMap Data Structure
[comment]: robots=index, follow


<h1>LFU Cache</h1>
<p>
This page explains Java solution to problem <code class="inline">LFU Cache</code> using <code class="inline">HashMap</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: <code class="inline">get</code> and <code class="inline">put</code>.
</p>

<p>
<code class="inline">get(key)</code> - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return <code class="inline">-1</code>. 
</p>

<p>
<code class="inline">put(key, value)</code> - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
</p>

<p>
Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.
</p>

<p>
Follow up: Could you do both operations in <code class="inline">O(1)</code> time complexity?
</p>

<b>Example 1:</b>
<blockquote>
LFUCache cache = new LFUCache( 2 /* capacity */ ); <br />
cache.put(1, 1);    <br />
cache.put(2, 2);    <br />
cache.get(1);       // returns 1<br />
cache.put(3, 3);    // evicts key 2<br />
cache.get(2);       // returns -1 (not found)<br />
cache.get(3);       // returns 3.<br />
cache.put(4, 4);    // evicts key 1.<br />
cache.get(1);       // returns -1 (not found)<br />
cache.get(3);       // returns 3<br />
cache.get(4);       // returns 4<br />
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
<p>O(1)</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>O(1)</p>
</blockquote>