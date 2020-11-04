[comment]: metadata=Java Solution to problem Tag Validator using String Data Structure.
[comment]: keywords=Tag Validator, String Data Structure
[comment]: robots=index, follow


<h1>Tag Validator</h1>
<p>
This page explains Java solution to problem <code class="inline">Tag Validator</code> using <code class="inline">String</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Given a string representing a code snippet, you need to implement a tag validator to parse the code and return whether it is valid. A code snippet is valid if all the following rules hold:
</p>
<ul>
<li>1. The code must be wrapped in a valid closed tag. Otherwise, the code is invalid.</li>
<li>2. A closed tag (not necessarily valid) has exactly the following format : <code class="inline">&lt;TAG_NAME&gt;TAG_CONTENT&lt;/TAG_NAME&gt;</code>. Among them, <code class="inline">&lt;TAG_NAME&gt;</code> is the start tag, and <code class="inline">&lt;/TAG_NAME&gt;</code> is the end tag. The TAG_NAME in start and end tags should be the same. A closed tag is valid if and only if the TAG_NAME and TAG_CONTENT are valid.</li>
<li>3. A valid TAG_NAME only contain upper-case letters, and has length in range <code class="inline">[1,9]</code>. Otherwise, the TAG_NAME is invalid.</li>
<li>4. A valid TAG_CONTENT may contain other valid closed tags, cdata and any characters (see note1) EXCEPT unmatched <code class="inline">&lt;</code>, unmatched start and end tag, and unmatched or closed tags with invalid TAG_NAME. Otherwise, the TAG_CONTENT is invalid.</li>
<li>5. A start tag is unmatched if no end tag exists with the same TAG_NAME, and vice versa. However, you also need to consider the issue of unbalanced when tags are nested.</li>
<li>6. A <code class="inline">&lt;</code> is unmatched if you cannot find a subsequent <code class="inline">&gt;</code>. And when you find a <code class="inline">&lt;</code> or <code class="inline">&lt;/</code>, all the subsequent characters until the next <code class="inline">&gt;</code> should be parsed as TAG_NAME (not necessarily valid).</li>
<li>7. The cdata has the following format : &lt;![CDATA[CDATA_CONTENT]]&gt;. The range of CDATA_CONTENT is defined as the characters between <code class="inline">&lt;![CDATA[ and the first subsequent ]]&gt;.</code></li>
<li>8. CDATA_CONTENT may contain any characters. The function of cdata is to forbid the validator to parse CDATA_CONTENT, so even it has some characters that can be parsed as tag (no matter valid or invalid), you should treat it as regular characters.</li>
</ul>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: &lt;DIV&gt;This is the first line &lt;![CDATA[&lt;div&gt;]]&gt;&lt;/DIV&gt;<br/>
<b>Output</b>: True<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: "&lt;A&gt;&nbsp;&nbsp;&nbsp;&lt;B&gt;&nbsp;&lt;/A&gt;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/B&gt;"<br/>
<b>Output</b>: False<br/>
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
N is length of input string
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is length of input string
</p>
</blockquote>