[comment]: metadata=Java Solution to problem Design In Memory File System using Hash Map Data Structure.
[comment]: keywords=Design In Memory File System, HashMap Data Structure
[comment]: robots=index, follow


<h1>Design In Memory File System</h1>
<p>
This page explains Java solution to problem <code class="inline">Design In Memory File System</code> using <code class="inline">Hash Map</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Design an in-memory file system to simulate the following functions:
</p>
<p>
ls: Given a path in string format. If it is a file path, return a list that only contains this file's name. If it is a directory path, return the list of file and directory names in this directory. Your output (file and directory names together) should in lexicographic order.
</p>
<p>
mkdir: Given a directory path that does not exist, you should make a new directory according to the path. If the middle directories in the path don't exist either, you should create them as well. This function has void return type.
</p>
<p>
addContentToFile: Given a file path and file content in string format. If the file doesn't exist, you need to create that file containing given content. If the file already exists, you need to append given content to original content. This function has void return type.
</p>
<p>
readContentFromFile: Given a file path, return its content in string format.
</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: <br />
["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]<br/>
[[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]] <br />
<b>Output</b>: [null,[],null,null,["a"],"hello"]<br/>
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
ls                  : O(M + N + K log(K)) <br />
mkdir               : O(M + N) <br />
addContentToFile    : O(M + N) <br />
readContentFromFile : O(M + N) Where <br />
M is length of input path <br />
N is depth of directory structure <br />
K is total number of directory and files in a ls output
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(P + Q) Where <br />
P is total number of input dirs <br />
Q is total number of input files 
</p>
</blockquote>