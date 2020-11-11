[comment]: metadata=Java Solution to problem Number of Atoms using TreeMap Data Structure.
[comment]: keywords=Number of Atoms, TreeMap Data Structure
[comment]: robots=index, follow


<h1>Number of Atoms</h1>
<p>
This page explains Java solution to problem <code class="inline">Number of Atoms</code> using <code class="inline">TreeMap</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given a chemical formula (given as a string), return the count of each atom.
</p>
<p>
The atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.
</p>
<p>
One or more digits representing that element's count may follow if the count is greater than <code class="inline">1</code>. If the count is <code class="inline">1</code>, no digits will follow. For example, <code class="inline">H2O</code> and <code class="inline">H2O2</code> are possible, but <code class="inline">H1O2</code> is impossible.
</p>
<p>
Two formulas concatenated together to produce another formula. For example, <code class="inline">H2O2He3Mg4</code> is also a formula.
</p>
<p>
A formula placed in parentheses, and a count (optionally added) is also a formula. For example, <code class="inline">(H2O2)</code> and <code class="inline">(H2O2)3</code> are formulas.
</p>
<p>
Given a formula, return the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than <code class="inline">1</code>), followed by the second name (in sorted order), followed by its count (if that count is more than <code class="inline">1</code>), and so on.
</p>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: formula = "H2O"<br/>
<b>Output</b>: "H2O"<br/>
<b>Explanation</b>: The count of elements are {'H': 2, 'O': 1}.<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: formula = "Mg(OH)2"<br/>
<b>Output</b>: "H2MgO2"<br/>
<b>Explanation</b>: The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.<br/>
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: formula = "K4(ON(SO3)2)2"<br/>
<b>Output</b>: "K4N2O14S4"<br/>
<b>Explanation</b>: The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.<br/>
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
N is total number of characters in an input formula
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is total number of characters in an input formula
</p>
</blockquote>