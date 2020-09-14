[comment]: metadata=Java Solution to problem Scramble String using Dynamic Programming Algorithm.
[comment]: keywords=Scramble String, Dynamic Programming
[comment]: robots=index, follow


<h1>Scramble String</h1>
<p>
This page explains Java solution to problem <code class="inline">Scramble String</code> using <code class="inline">Dynamic</code> programming algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
We can scramble a string s to get a string t using the following algorithm:
</p>
<ul>
<li>
If the length of the string is 1, stop.
</li>
<li>
If the length of the string is > 1, do the following:
<ul>
    <li>Split the string into 2 non-empty substrings at a random index, i.e. if the string is s, divide it to x and y where s = x + y.</li>
    <li>Randomly, decide to swap the two substrings or to keep them in the same order. i.e. after this step, s may become s = x + y or s = y + x.</li>
    <li>Apply step 1 recursively on each of the two substrings x and y.</li>
</ul>
</li>
</ul>
<p>
Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.
</p>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: s1 = "great", s2 = "rgeat"<br/>
<b>Output</b>: true<br/>
<b>Explanation</b>: <br />
One possible scenario applied on s1 is: <br />
"great" --> "gr/eat" // divide at random index. <br />
"gr/eat" --> "gr/eat" // random decision is not to swap the two substrings and keep them in order.<br />
"gr/eat" --> "g/r / e/at" // apply the same algorith recursively on both substrings. divide at ranom index each of them.<br/>
"g/r / e/at" --> "r/g / e/at" // random decision was to swap the first substing and to keep the second substring in the same order. <br />
"r/g / e/at" --> "r/g / e/ a/t" // again apply the algorithm recursively, divide "at" to "a/t". < br />
"r/g / e/ a/t" --> "r/g / e/ a/t" // random decision is to keep both substings in the same order. <br />
The algorithm stops now and the result string is "rgeat" which is s2.
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: s1 = "abcde", s2 = "caebd" <br />
<b>Output</b>: false<br/>
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
O(N ^ 4) Where <br />
N is length of input string s1 or s2(Both will have same length)
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N ^ 3) Where <br />
N is length of input string s1 or s2(Both will have same length)
</p>
</blockquote>