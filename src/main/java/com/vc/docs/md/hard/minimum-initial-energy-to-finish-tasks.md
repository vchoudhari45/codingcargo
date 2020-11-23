[comment]: metadata=Java Solution to problem Minimum Initial Energy to Finish Tasks using greedy Algorithm.
[comment]: keywords=Minimum Initial Energy to Finish Tasks, Greedy Algorithm
[comment]: robots=index, follow


<h1>Minimum Initial Energy to Finish Tasks</h1>
<p>
This page explains Java solution to problem <code class="inline">Minimum Initial Energy to Finish Tasks</code> using <code class="inline">Greedy</code> algorithm.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
You are given an array tasks where <code class="inline">tasks[i]</code> = <code class="inline">[actuali, minimumi]</code>:
</p>
<ul>
<li><code class="inline">actuali</code> is the actual amount of energy you spend to finish the <code class="inline">ith</code> task.</li>
<li><code class="inline">minimumi</code> is the minimum amount of energy you require to begin the <code class="inline">ith</code> task.</li>
</ul>
<p>
For example, if the task is <code class="inline">[10, 12]</code> and your current energy is <code class="inline">11</code>, you cannot start this task. However, if your current energy is <code class="inline">13</code>, you can complete this task, and your energy will be <code class="inline">3</code> after finishing it.
</p>
<p>You can finish the tasks in any order you like.</p>
<p>Return the minimum initial amount of energy you will need to finish all the tasks.</p>

<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: tasks = [[1,2],[2,4],[4,8]]<br/>
<b>Output</b>: 8<br/>
<b>Explanation</b>: Starting with 8 energy, we finish the tasks in the following order: <br />
- 3rd task. Now energy = 8 - 4 = 4. <br />
- 2nd task. Now energy = 4 - 2 = 2. <br />
- 1st task. Now energy = 2 - 1 = 1. <br />
Notice that even though we have leftover energy, starting with 7 energy does not work because we cannot do the 3rd task.
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: tasks = [[1,3],[2,4],[10,11],[10,12],[8,9]]<br/>
<b>Output</b>: 32<br/>
<b>Explanation</b>: Starting with 32 energy, we finish the tasks in the following order:<br/>
- 1st task. Now energy = 32 - 1 = 31. <br />
- 2nd task. Now energy = 31 - 2 = 29. <br />
- 3rd task. Now energy = 29 - 10 = 19. <br />
- 4th task. Now energy = 19 - 10 = 9. <br />
- 5th task. Now energy = 9 - 8 = 1. 
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
O(N log N) Where <br />
N is total number of elements in an input array
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(1)
</p>
</blockquote>