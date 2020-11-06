[comment]: metadata=Java Solution to problem Design Search Autocomplete System using Trie Data Structure.
[comment]: keywords=Design Search Autocomplete System, Trie Data Structure
[comment]: robots=index, follow


<h1>Design Search Autocomplete System</h1>
<p>
This page explains Java solution to problem <code class="inline">Design Search Autocomplete System</code> using <code class="inline">Trie</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#'). For each character they type except '#', you need to return the top 3 historical hot sentences that have prefix the same as the part of sentence already typed. Here are the specific rules:
</p>
<ul>
<li>1. The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.</li>
<li>2. The returned top <code class="inline">3</code> hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).</li>
<li>3. If less than <code class="inline">3</code> hot sentences exist, then just return as many as you can.</li>
<li>4. When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.</li>
</ul>
<p>Your job is to implement the following functions:</p>
<p>
<code class="inline">DesignSearchAutocompleteSystem(String[] sentences, int[] times)</code>: This is the constructor. The input is historical data. Sentences is a string array consists of previously typed sentences. Times is the corresponding times a sentence has been typed. Your system should record these historical data.
</p>
<p>
Now, the user wants to input a new sentence. The following function will provide the next character the user types:
</p>
<p>
<code class="inline">List<String> input(char c)</code>: The input c is the next character typed by the user. The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#'). Also, the previously typed sentence should be recorded in your system. The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.
</p>


<b>Example 1:</b>
<blockquote>
<p>
Operation: DesignSearchAutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2]) <br />
The system have already tracked down the following sentences and their corresponding times:<br />
"i love you" : 5 times<br />
"island" : 3 times<br />
"ironman" : 2 times<br />
"i love leetcode" : 2 times<br />
Now, the user begins another search:<br />
<br />
Operation: input('i') <br/>
Output: ["i love you", "island","i love leetcode"]<br/>
Explanation:<br/>
There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.<br/>
<br />
Operation: input(' ')<br />
Output: ["i love you","i love leetcode"]<br />
Explanation:<br />
There are only two sentences that have prefix "i ".<br />
<br />
Operation: input('a')<br />
Output: []<br />
Explanation:<br />
There are no sentences that have prefix "i a".<br />
<br />
Operation: input('#')<br />
Output: []<br />
Explanation:<br />
The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.<br />
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
DesignSearchAutocompleteSystem() takes O(K * L) < br/>
input() takes O(P + Q + M * log M) <br /> Where 
K is avg length of each sentences <br />
L is total number of sentences
P is length of sentence formed <br />
Q is length of nodes in trie after sentence <br />
M is result that we need to sort <br />
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(C) Where <br />
Q is total number of characters in all the sentences in an input array
</p>
</blockquote>