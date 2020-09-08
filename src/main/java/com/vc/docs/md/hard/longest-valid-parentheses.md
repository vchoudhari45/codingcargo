[comment]: metadata=Java Solution to problem <strong>Longest Valid Parentheses</strong> using <strong>Stack</strong> Data Structure.
[comment]: keywords=Longest Valid Parentheses, Stack
[comment]: robots=index, follow





<h1>Longest Valid Parentheses</h1>
<p>
This page explains Java solution to problem <code class="inline">Longest Valid Parentheses</code> using <a href="https://www.codingcargo.com/what-is-stack" class="absolute" target="_blank" rel="noopener noreferrer">Stack</a> Data Structure.
</p>





<h2 class="heading">Problem Statement</h2>
<p>
Given a string containing just the characters <code class="inline">(</code> and <code class="inline">)</code>, find the length of the longest valid (well-formed) parentheses substring.
</p>






<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: "(()"<br />
<b>Output</b>: 2<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: ")()())"<br/>
<b>Output</b>: 4<br/>
</p>
</blockquote>





<h2 class="heading">Solution</h2>
<p>
We use Stack Data Structure for solving this problem, idea is to keep a track of end index of last valid parentheses.
</p>
<p>
So we start by pushing -1 into into the stack as end index of last valid parentheses. Every time we see <code class="inline">(</code> character in an input string we keep pushing it's index on the stack.
</p>
<p>
Whenever we see <code class="inline">)</code> character in an input string we pop last element from stack and do below
</p>
<ul>
    <li>If Stack is empty, then it is an end of valid parentheses and we push current index onto the stack</li>
    <li>If Stack is not empty, then we pop last element from the stack and recalculate maxLength</li>
</ul>





<p class="paragraph-heading">
Let's run one of the sample input <code class="inline">)()())</code> visually, for better understanding.
</p>
<img class="paragraph-heading" src="####BASEURL####longest-valid-parentheses/longest-1.png" alt="Longest Valid Parentheses 1" />
<img class="paragraph-heading" src="####BASEURL####longest-valid-parentheses/longest-2.png" alt="Longest Valid Parentheses 2" />
<img class="paragraph-heading" src="####BASEURL####longest-valid-parentheses/longest-3.png" alt="Longest Valid Parentheses 3" />
<img class="paragraph-heading" src="####BASEURL####longest-valid-parentheses/longest-4.png" alt="Longest Valid Parentheses 4" />
<img class="paragraph-heading" src="####BASEURL####longest-valid-parentheses/longest-5.png" alt="Longest Valid Parentheses 5" />
<img class="paragraph-heading" src="####BASEURL####longest-valid-parentheses/longest-6.png" alt="Longest Valid Parentheses 6" />
<img class="paragraph-heading" src="####BASEURL####longest-valid-parentheses/longest-7.png" alt="Longest Valid Parentheses 7" />
 


<h2 class="heading">Time Complexity</h2>
<blockquote>
<p>
O(N)Where <br />
N is total number of elements in a input string
</p>
</blockquote>






<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>O(N)</p>
</blockquote>






<h2 class="heading">Complete Java code</h2>
If you have any suggestions in below code, please create a pull request <a href="####LINK_PLACEHOLDER####" target="_blank" rel="noopener noreferrer" class="absolute">here</a>
<pre>
<code class="language-java">
####CODE_PLACEHOLDER####
</code>
</pre>