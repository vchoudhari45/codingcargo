[comment]: metadata=Java Solution to problem Count The Repetitions using String Data Structure.
[comment]: keywords=Count The Repetitions, String Data Structure
[comment]: robots=index, follow


<h1>Count The Repetitions</h1>
<p>
This page explains Java solution to problem <code class="inline">Count The Repetitions</code> using <code class="inline">String</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Define <code class="inline">S = [s,n]</code> as the string <code class="inline">S</code> which consists of <code class="inline">n</code> connected strings <code class="inline">s</code>. For example, <code class="inline">["abc", 3] ="abcabcabc"</code>.
</p>
<p>
On the other hand, we define that string <code class="inline">s1</code> can be obtained from string <code class="inline">s2</code> if we can remove some characters from <code class="inline">s2</code> such that it becomes <code class="inline">s1</code>. For example, <code class="inline">abc</code> can be obtained from <code class="inline">abdbec</code> based on our definition, but it can not be obtained from <code class="inline">acbbe</code>.
</p>
<p>
You are given two non-empty strings <code class="inline">s1</code> and <code class="inline">s2</code> (each at most <code class="inline">100</code> characters long) and two integers <code class="inline">0 ≤ n1 ≤ 106</code> and <code class="inline">1 ≤ n2 ≤ 106</code>. Now consider the strings <code class="inline">S1</code> and <code class="inline">S2</code>, where <code class="inline">S1=[s1,n1]</code> and <code class="inline">S2=[s2,n2]</code>. Find the maximum integer <code class="inline">M</code> such that <code class="inline">[S2,M]</code> can be obtained from <code class="inline">S1</code>.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: <br />
s1 = "acb", n1 = 4<br/>
s2 = "ab", n2 = 2<br />
<b>Output</b>: 2<br/>
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
O(len1 * len2) Where <br />
len1 is length of input string s1<br />
len2 is length of input string s2<br />
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(len2 + N1) Where <br />
N1 number of times input string s1 can be used<br /> 
len2 is length of input string s2<br />
</p>
</blockquote>