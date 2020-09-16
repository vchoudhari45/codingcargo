[comment]: metadata=Java Solution to problem Word Break II using Recursion with Memoization.
[comment]: keywords=Word Break II, Recursion with Memoization
[comment]: robots=index, follow


<h1>Word Break II</h1>
<p>
This page explains Java solution to problem <code class="inline">Word Break II</code> using <code class="inline">Recursion with memoization</code>.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
</p>
<p>
<b>Note:</b>
</p>
<ul>
<li>The same word in the dictionary may be reused multiple times in the segmentation.</li>
<li>You may assume the dictionary does not contain duplicate words.</li>
</ul>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: s = "catsanddog", wordDict = ["cat", "cats", "and", "sand", "dog"]<br/>
<b>Output</b>: <br/>
[<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"cats and dog",<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp"cat sand dog"<br/>
]<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: s = "pineapplepenapple", wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]<br/>
<b>Output</b>: <br/>
[<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"pine apple pen apple",<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp"pineapple pen apple",<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp"pine applepen apple"<br/>
]<br/>
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
O(N! + W) Where <br />
N is total number of elements in an input String s.
W is total number of elements in an input array wordDict.
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(W + 2 ^ N) Where <br />
N is total number of elements in an input String s.
W is total number of elements in an input array wordDict.
</p>
</blockquote>