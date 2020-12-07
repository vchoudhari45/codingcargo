[comment]: metadata=Java Solution to problem Build Binary Expression Tree From Infix Expression using Tree Data Structure.
[comment]: keywords=Build Binary Expression Tree From Infix Expression, Tree Data Structure
[comment]: robots=index, follow


<h1>Build Binary Expression Tree From Infix Expression</h1>
<p>
This page explains Java solution to problem <code class="inline">Build Binary Expression Tree From Infix Expression</code> using <code class="inline">Tree</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
A binary expression tree is a kind of binary tree used to represent arithmetic expressions. Each node of a binary expression tree has either zero or two children. Leaf nodes (nodes with <code class="inline">0</code> children) correspond to operands (numbers), and internal nodes (nodes with <code class="inline">2</code> children) correspond to the operators <code class="inline">+</code> (addition), <code class="inline">-</code> (subtraction), <code class="inline">*</code> (multiplication), and <code class="inline">/</code> (division).
</p>
<p>
For each internal node with operator <code class="inline">o</code>, the infix expression that it represents is <code class="inline">(A o B)</code>, where <code class="inline">A</code> is the expression the left subtree represents and <code class="inline">B</code> is the expression the right subtree represents.
</p>
<p>
You are given a string <code class="inline">s</code>, an infix expression containing operands, the operators described above, and parentheses <code class="inline">(</code> and <code class="inline">)</code>.
</p>
<p>
Return any valid binary expression tree, which its in-order traversal reproduces <code class="inline">s</code> after omitting the parenthesis from it (see examples below).
</p>
<p>
Please note that order of operations applies in <code class="inline">s</code>. That is, expressions in parentheses are evaluated first, and multiplication and division happen before addition and subtraction.
</p>
<p>
Operands must also appear in the same order in both <code class="inline">s</code> and the in-order traversal of the tree.
</p>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: "2-3/(5*2)+1"<br/>
<b>Output</b>: [+,-,1,2,/,null,null,null,null,3,*,null,null,5,2]<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: "3*4-2*5"<br/>
<b>Output</b>: [-,*,*,3,4,2,5]<br/>
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: "1+2+3+4+5"<br/>
<b>Output</b>: [+,+,5,+,4,null,null,+,3,null,null,1,2]<br/>
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
O(N) Where <br />
N is number of characters in an input String s<br />
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is number of characters in an input String s<br />
</p>
</blockquote>