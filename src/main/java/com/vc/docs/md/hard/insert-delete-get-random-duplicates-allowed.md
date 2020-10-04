[comment]: metadata=Java Solution to problem Insert Delete GetRandom Duplicates allowed using HashMap Data Structure.
[comment]: keywords=Insert Delete GetRandom Duplicates allowed, HashMap Data Structure
[comment]: robots=index, follow


<h1>Insert Delete GetRandom Duplicates allowed</h1>
<p>
This page explains Java solution to problem <code class="inline">Insert Delete GetRandom Duplicates allowed</code> using <code class="inline">HashMap Data Structure</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Design a data structure that supports all following operations in average <code class="inline">O(1)</code> time.
</p>
<ul>
<li>Note: Duplicate elements are allowed.</li>
<li>insert(val): Inserts an item val to the collection.</li>
<li>remove(val): Removes an item val from the collection if present.</li>
<li>getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.</li>
</ul>

<b>Example 1:</b>
<blockquote>
<p>
// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection(); <br /> <br />

// Inserts 1 to the collection. Returns true as the collection did not contain 1.  <br />
collection.insert(1);  <br /> <br />

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].  <br />
collection.insert(1);  <br /> <br />

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2]. <br />
collection.insert(2); <br /> <br />

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3. <br />
collection.getRandom(); <br /> <br />

// Removes 1 from the collection, returns true. Collection now contains [1,2]. <br />
collection.remove(1); <br /> <br />

// getRandom should return 1 and 2 both equally likely. <br />
collection.getRandom(); <br /> <br />
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
<p>O(1)</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is total number of elements in an input array
</p>
</blockquote>