[comment]: metadata=Java Solution to problem <strong>Substring with Concatenation of All Words</strong> using <strong>HashMap</strong> Data Structure.
[comment]: keywords=Substring with Concatenation of All Words
[comment]: robots=index, follow






<h1>Substring with Concatenation of All Words</h1>
<p>
This page explains Java solution to problem <code class="inline">Substring with Concatenation of All Words</code> using <a href="https://www.codingcargo.com/what-is-hashmap" class="absolute" target="_blank" rel="noopener noreferrer">HashMap</a>.
</p>





<h2 class="heading">Problem Statement</h2>
<p>
You are given a string s and an array of strings words <b>of the same length</b>. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.
</p>
<p>
You can return the answer in any order.
</p>





<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: s = "barfoothefoobarman", words = ["foo","bar"]<br />
<b>Output</b>: [0,9]<br />
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]<br />
<b>Output</b>: []<br/>
</p>
</blockquote>





<h2 class="heading">Solution</h2>
<p>
Let's start by thinking the brute-force solution to this problem. 
</p>
<p>
We can start by iterating over each element in an input string <code class="inline">s</code>, and see if we can find match for all the elements from <code class="inline">words</code> input array from a particular index <code class="inline">i</code>.
</p>
<p>
With above approach our solution will have a time complexity of <code class="inline">O(N * (K * M) ^ 2)</code> Where, 
</p>
<ul>
    <li><code class="inline">N</code> is number of elements in an input string.</li>
    <li><code class="inline">K</code> is an avg length of <code class="inline">word</code> in <code class="inline">words</code> input array.</li>
    <li><code class="inline">M</code> is number of elements in the <code class="inline">words</code> input array.</li>
</ul> 


<p class="paragraph-heading">
But if we notice the problem statement carefully it mentions all the elements in an input <code class="inline">words</code> array have same length so we can easily reduce the the time complexity of above solution by <code class="inline">O(K * M)</code> using HashMap.
</p>

<p>So let's get started, firstly we add all the elements in an input <code class="inline">words</code> array into HashMap along with the count</p>
<pre>
<code class="language-java">
HashMap&lt;String, Integer&gt; mapInitial = new HashMap&lt;&gt;();
int required = 0;
for(String word: words) {
    mapInitial.put(word, mapInitial.getOrDefault(word, 0) + 1);  
    required++;
}
</code>
</pre>


<p>Next we iterate over all the elements in an input string <code class="inline">s</code></p>
<p>Notice how we are using <code class="inline">i + words.length * wordLength</code> instead of <code class="inline">i</code> here because if remaining elements in the input string <code class="inline">s</code> 
is less than total length of all the elements in an input array <code class="inline">words</code> then we won't find a match and we can stop.</p>
<pre>
<code class="language-java">
for(int i = 0; i + words.length * wordLength &lt;= s.length(); i++) {<br />
}
</code>
</pre>



<p>
From each index validate if we can get a match for a word from the HashMap as below. And if we find all the elements from <code class="inline">words</code> input array from particular index <code class="inline">i</code> then we add that index as a solution list.
</p>
<pre>
<code class="language-java">
for(int i = 0; i + words.length * wordLength &lt;= s.length(); i++) {
    HashMap&lt;String, Integer&gt; map = new HashMap&lt;&gt;();<br />
    int total = 0;
    for(int j = i; j &lt;= i + words.length * wordLength; j = j + wordLength) {
        //Fixed length word
        String word = s.substring(j, j + wordLength);<br />
        //See if word is present in a words input array
        map.put(word, map.getOrDefault(word, 0) + 1);
        if(map.get(word) > mapInitial.getOrDefault(word, 0)) break; <br />
        //If so see if we found all the elements in a input words array
        if(++total == required) {
            res.add(i);
            break;
        }  
    }
}
</code>
</pre>



<h2 class="heading">Time Complexity</h2>
<blockquote>
<p>
O(N * M * K) Where <br />
N number of elements in an input string
M length of word in words input array
K number of elements in words input array
</p>
</blockquote>




<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(K) to store K elements from words input array into HashMap 
</p>
</blockquote>




<h2 class="heading">Complete Java code</h2>
If you have any suggestions in below code, please create a pull request <a href="####LINK_PLACEHOLDER####" target="_blank" rel="noopener noreferrer" class="absolute">here</a>
<pre>
<code class="language-java">
####CODE_PLACEHOLDER####
</code>
</pre>