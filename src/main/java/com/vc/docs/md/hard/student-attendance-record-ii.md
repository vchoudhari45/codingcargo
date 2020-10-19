[comment]: metadata=Java Solution to problem Student Attendance Record II using Dynamic Programming.
[comment]: keywords=Student Attendance Record II, Dynamic Programming
[comment]: robots=index, follow


<h1>Student Attendance Record II</h1>
<p>
This page explains Java solution to problem <code class="inline">Student Attendance Record II</code> using <code class="inline">Dynamic Programming</code>.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given a positive integer <code class="inline">n</code>, return the number of all possible attendance records with length <code class="inline">n</code>, which will be regarded as rewardable. The answer may be very large, return it after mod <code class="inline">10<sup>9</sup> + 7</code>.
</p>
<p>
A student attendance record is a string that only contains the following three characters:
</p>
<ul>
<li>'A' : Absent.</li>
<li>'L' : Late.</li>
<li>'P' : Present.</li>
</ul>
<p>
A record is regarded as rewardable if it doesn't contain more than one <code class="inline">A</code> (absent) or more than two continuous <code class="inline">L</code> (late).
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: n = 2<br/>
<b>Output</b>: 8 <br/>
<b>Explanation</b>: <br/>
There are 8 records with length 2 will be regarded as rewardable: <br />
"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"  <br />
Only "AA" won't be regarded as rewardable owing to more than one absent times. 
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: n = 6 <br/>
<b>Output</b>: 200 <br/>
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
N is given positive integer
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is given positive integer
</p>
</blockquote>