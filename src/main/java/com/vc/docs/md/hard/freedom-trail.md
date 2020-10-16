[comment]: metadata=Java Solution to problem Freedom Trail using TreeMap Data Structure.
[comment]: keywords=Freedom Trail, TreeMap Data Structure
[comment]: robots=index, follow


<h1>Freedom Trail</h1>
<p>
This page explains Java solution to problem <code class="inline">Freedom Trail</code> using <code class="inline">TreeMap</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
In the video game Fallout <code class="inline">4</code>, the quest "Road to Freedom" requires players to reach a metal dial called the "Freedom Trail Ring", and use the dial to spell a specific keyword in order to open the door.
</p>
<p>
Given a string ring, which represents the code engraved on the outer ring and another string key, which represents the keyword needs to be spelled. You need to find the minimum number of steps in order to spell all the characters in the keyword.
</p>
<p>
Initially, the first character of the ring is aligned at <code class="inline">12:00</code> direction. You need to spell all the characters in the string key one by one by rotating the ring clockwise or anticlockwise to make each character of the string key aligned at <code class="inline">12:00</code> direction and then by pressing the center button.
</p>
<p>
At the stage of rotating the ring to spell the key character <code class="inline">key[i]</code>:
</p>
<ul>
<li>1. You can rotate the ring clockwise or anticlockwise one place, which counts as <code class="inline">1</code> step. The final purpose of the rotation is to align one of the string ring's characters at the <code class="inline">12:00</code> direction, where this character must equal to the character <code class="inline">key[i]</code>.</li>
<li>2. If the character <code class="inline">key[i]</code> has been aligned at the <code class="inline">12:00</code> direction, you need to press the center button to spell, which also counts as <code class="inline">1</code> step. After the pressing, you could begin to spell the next character in the key (next stage), otherwise, you've finished all the spelling.</li>
</ul>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: ring = "godding", key = "gd"<br/>
<b>Output</b>: 4<br/>
<b>Explanation</b>: <br/>
For the first key character 'g', since it is already in place, we just need 1 step to spell this character. <br />
For the second key character 'd', we need to rotate the ring "godding" anticlockwise by two steps to make it become "ddinggo". <br />
Also, we need 1 more step for spelling. So the final output is 4.
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
O(MN * log M) Where <br />
M is number of elements in an input string ring <br /> 
N is number of elements in an input string key <br />
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(M + N) Where <br />
M is number of elements in an input string ring <br /> 
N is number of elements in an input string key <br />
</p>
</blockquote>