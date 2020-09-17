[comment]: metadata=Java Solution to problem Read N Characters Given Read4 II using String Data Structure.
[comment]: keywords=Read N Characters Given Read4 II, String
[comment]: robots=index, follow


<h1>Read N Characters Given Read4 II</h1>
<p>
This page explains Java solution to problem <code class="inline">Read N Characters Given Read4 II</code> using <code class="inline">String</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given a file and assume that you can only read the file using a given method read4, implement a method read to read n characters. Your method read may be called multiple times.
</p>
<h3>Method read4: </h3>
<p>
The API read4 reads 4 consecutive characters from the file, then writes those characters into the buffer array buf.
</p>
<p>
The return value is the number of actual characters read.
</p>
<p>
Note that read4() has its own file pointer, much like FILE *fp in C.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: File file("abc")<br/>
<b>Output</b>: <br/>
Assume buf is allocated and guaranteed to have enough space for storing all characters from the file.<br />
read(buf, 1); // After calling your read method, buf should contain "a". We read a total of 1 character from the file, so return 1.<br />
read(buf, 2); // Now buf should contain "bc". We read a total of 2 characters from the file, so return 2.<br />
read(buf, 1); // We have reached the end of file, no more characters can be read. So return 0.<br />
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
N is total number of elements in an input file
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is total number of elements in an input file
</p>
</blockquote>