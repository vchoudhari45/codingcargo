[comment]: metadata=Java Solution to problem <strong>First Missing Positive</strong> using <strong>Array</strong> Data Structure.
[comment]: keywords=First Missing Positive, Array
[comment]: robots=index, follow






<h1>First Missing Positive</h1>
<p>
This page explains Java solution to problem <code class="inline">First Missing Positive</code> using <a href="####BASEURL####what-is-array" class="absolute" target="_blank" rel="noopener noreferrer">Array</a>.
</p>





<h2 class="heading">Problem Statement</h2>
<p>
Given an unsorted integer array, find the smallest missing positive integer.
</p>





<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: [1,2,0]<br/>
<b>Output</b>: 3<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: [3,4,-1,1]<br/>
<b>Output</b>: 2<br/>
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: [7,8,9,11,12]<br/>
<b>Output</b>: 1<br/>
</p>
</blockquote>




<h2 class="heading">Solution</h2>
<p>
We can divide this problem into two parts
</p>
<ul>
<li>First, move all the negative numbers to the end of an input array</li>
<li>Second, find missing number from positive number</li>
</ul>

<p>So, let's start by addressing first problem to moving negative numbers to end</p>
<pre>
<code class="language-java">
int positiveNumberIndex = -1; 
//Since we have to return smallest missing positive number, 
//let's move all the negative number to the end
for(int i = 0; i &lt; arr.length; i++) {
    if(arr[i] &gt; 0) swap(arr, i, ++positiveNumberIndex);
}
</code>
</pre>





<p class="paragraph-heading">
Now problem has reduced to finding missing positive number from <code class="inline">0</code> to <code class="inline">positiveNumberIndex</code>
</p>
<p>
Next step is to iterate over positive numbers let's say <code class="inline">a[i]</code> and mark the number at index <code class="inline">a[i] - 1</code> negative.
</p>
<pre>
<code class="language-java">
for(int i = 0; i &lt;= positiveNumberIndex; i++) {
    int index = Math.abs(arr[i]) - 1;
    if(index <= positiveNumberIndex && arr[index] > 0) arr[index] = -1 * arr[index];
}
</code>
</pre>





<p>
Now, If at index let's say <code class="inline">0</code> number is positive, it mean number 1 is missing because it wasn't marked negative in above step.
</p>
<pre>
<code class="language-java">
for(int i = 0; i &lt;= positiveNumberIndex; i++) {
    if(arr[i] &gt; 0) return i + 1;
}
</code>
</pre>





<h2 class="heading">Time Complexity</h2>
<blockquote>
<p>
O(N) <br />
Where N is total number of elements in an input array.
</p>
</blockquote>




<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(1)
</p>
</blockquote>




<h2 class="heading">Complete Java code</h2>
If you have any suggestions in below code, please create a pull request <a href="####LINK_PLACEHOLDER####" target="_blank" rel="noopener noreferrer" class="absolute">here</a>
<pre>
<code class="language-java">
####CODE_PLACEHOLDER####
</code>
</pre>