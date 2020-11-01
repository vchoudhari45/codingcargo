[comment]: metadata=Java Solution to problem Word Abbreviation using Trie Data Structure.
[comment]: keywords=Word Abbreviation, Trie Data Structure
[comment]: robots=index, follow


<h1>Word Abbreviation</h1>
<p>
This page explains Java solution to problem <code class="inline">Word Abbreviation</code> using <code class="inline">Trie</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given an array of <code class="inline">n</code> distinct non-empty strings, you need to generate minimal possible abbreviations for every word following rules below.
</p>
<ul>
<li>1. Begin with the first character and then the number of characters abbreviated, which followed by the last character.</li>
<li>2. If there are any conflict, that is more than one words share the same abbreviation, a longer prefix is used instead of only the first character until making the map from word to abbreviation become unique. In other words, a final abbreviation cannot map to more than one original words.</li>
<li>3. If the abbreviation doesn't make the word shorter, then keep it as original.</li>
</ul>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: ["like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"]<br/>
<b>Output</b>: ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]<br/>
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
O(C) Where <br />
C is total number or character in all of word in an input list
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(C) Where <br />
C is total number or character in all of word in an input list
/p>
</blockquote>