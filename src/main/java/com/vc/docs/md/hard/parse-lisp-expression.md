[comment]: metadata=Java Solution to problem Parse Lisp Expression using String Data Structure.
[comment]: keywords=Parse Lisp Expression, String Data Structure
[comment]: robots=index, follow


<h1>Parse Lisp Expression</h1>
<p>
This page explains Java solution to problem <code class="inline">Parse Lisp Expression</code> using <code class="inline">String</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
You are given a string <code class="inline">expression</code> representing a Lisp-like expression to return the integer value of.
</p>
<p>
The syntax for these expressions is given as follows.
</p>
<ul>
<li>An expression is either an integer, a let-expression, an add-expression, a mult-expression, or an assigned variable. Expressions always evaluate to a single integer.</li>
<li>An integer could be positive or negative.</li>
<li>A let-expression takes the form <code class="inline">(let v1 e1 v2 e2 ... vn en expr)</code>, where let is always the string "let", then there are 1 or more pairs of alternating variables and expressions, meaning that the first variable v1 is assigned the value of the expression e1, the second variable v2 is assigned the value of the expression e2, and so on sequentially; and then the value of this let-expression is the value of the expression expr.</li>
<li>An add-expression takes the form <code class="inline">(add e1 e2)</code> where add is always the string <code class="inline">"add"</code>, there are always two expressions <code class="inline">e1</code>, <code class="inline">e2</code>, and this expression evaluates to the addition of the evaluation of <code class="inline">e1</code> and the evaluation of <code class="inline">e2</code>.</li>
<li>A mult-expression takes the form <code class="inline">(mult e1 e2)</code> where mult is always the string <code class="inline">"mult"</code>, there are always two expressions <code class="inline">e1</code>, <code class="inline">e2</code>, and this expression evaluates to the multiplication of the evaluation of <code class="inline">e1</code> and the evaluation of <code class="inline">e2</code>.</li>
<li>For the purposes of this question, we will use a smaller subset of variable names. A variable starts with a lowercase letter, then zero or more lowercase letters or digits. Additionally for your convenience, the names <code class="inline">"add"</code>, <code class="inline">"let"</code>, or <code class="inline">"mult"</code> are protected and will never be used as variable names.</li>
<li>Finally, there is the concept of scope. When an expression of a variable name is evaluated, within the context of that evaluation, the innermost scope (in terms of parentheses) is checked first for the value of that variable, and then outer scopes are checked sequentially. It is guaranteed that every expression is legal. Please see the examples for more details on scope.</li>
</ul>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: (add 1 2)<br/>
<b>Output</b>: 3<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: (mult 3 (add 2 3))<br/>
<b>Output</b>: 15<br/>
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: (let x 2 (mult x (let x 3 y 4 (add x y))))<br/>
<b>Output</b>: 14<br/>
<b>Explanation</b>: <br />
In the expression (add x y), when checking for the value of the variable x, <br />
we check from the innermost scope to the outermost in the context of the variable we are trying to evaluate.<br />
Since x = 3 is found first, the value of x is 3.<br />
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
O(N<sup>2</sup>) Where <br />
N is length of expression
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N<sup>2</sup>) Where <br />
N is length of expression
</p>
</blockquote>