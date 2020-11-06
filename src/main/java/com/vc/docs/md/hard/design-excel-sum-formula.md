[comment]: metadata=Java Solution to problem Design Excel Sum Formula using HashMap Data Structure.
[comment]: keywords=Design Excel Sum Formula, HashMap Data Structure
[comment]: robots=index, follow


<h1>Design Excel Sum Formula</h1>
<p>
This page explains Java solution to problem <code class="inline">Design Excel Sum Formula</code> using <code class="inline">HashMap</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Your task is to design the basic function of Excel and implement the function of sum formula. Specifically, you need to implement the following functions:
</p>
<ul>
<li><code class="inline">Excel(int H, char W)</code>: This is the constructor. The inputs represents the height and width of the Excel form. <code class="inline">H</code> is a positive integer, range from <code class="inline">1</code> to <code class="inline">26</code>. It represents the height. <code class="inline">W</code> is a character range from <code class="inline">A</code> to <code class="inline">Z</code>. It represents that the width is the number of characters from <code class="inline">A</code> to <code class="inline">W</code>. The Excel form content is represented by a height * width <code class="inline">2D</code> integer array <code class="inline">C</code>, it should be initialized to zero. You should assume that the first row of <code class="inline">C</code> starts from <code class="inline">1</code>, and the first column of <code class="inline">C</code> starts from <code class="inline">A</code>.</li>
<li><code class="inline">void Set(int row, char column, int val)</code>: Change the value at <code class="inline">C(row, column)</code> to be val.</li>
<li><code class="inline">int Get(int row, char column)</code>: Return the value at <code class="inline">C(row, column)</code>.</li>
<li>
    <p><code class="inline">int Sum(int row, char column, List of Strings : numbers)</code>: This function calculate and set the value at <code class="inline">C(row, column)</code>, where the value should be the sum of cells represented by numbers. This function return the sum result at <code class="inline">C(row, column)</code>. This sum formula should exist until this cell is overlapped by another value or another sum formula.</p>
    <p><code class="inline">numbers</code> is a list of strings that each string represent a cell or a range of cells. If the string represent a single cell, then it has the following format : ColRow. For example, <code class="inline">"F7"</code> represents the cell at <code class="inline">(7, F)</code>.</p>
    <p>If the string represent a range of cells, then it has the following format : ColRow1:ColRow2. The range will always be a rectangle, and ColRow1 represent the position of the top-left cell, and ColRow2 represents the position of the bottom-right cell.</p>
</li>
</ul>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: <br/>
Excel(3,"C"); <br />
construct a 3 * 3 2D array with all zero.<br />
&nbsp;&nbsp;A B C <br />
   1 0 0 0 <br />
   2 0 0 0 <br />
   3 0 0 0 <br />
<br />
Set(1, "A", 2); <br />
set C(1,"A") to be 2.<br />
&nbsp;&nbsp;A B C <br />
   1 2 0 0 <br />
   2 0 0 0 <br />
   3 0 0 0 <br />
<br />
Sum(3, "C", ["A1", "A1:B2"]); <br />
set C(3,"C") to be the sum of value at C(1,"A") and the values sum of the rectangle range whose top-left cell is C(1,"A") and bottom-right cell is C(2,"B"). Return 4.<br />
&nbsp;&nbsp;A B C <br />
   1 2 0 0 <br />
   2 0 0 0 <br />
   3 0 0 4 <br />
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
Set(int row, char column, int val) takes O(1) <br /> 
Get(int row, char column) takes O(N) <br />
int Sum(int row, char column, List of Strings : numbers) takes O(L) <br />
Where N is total number Cell references we have in a formula <br />
L is length of input list which has formulas
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(H, W) Where <br />
H is number of rows in an excel <br />
W is number of cols in an excel <br />
</p>
</blockquote>