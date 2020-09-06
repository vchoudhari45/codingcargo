[comment]: metadata=Java Solution to problem <strong>Regular Expression Matching</strong> using <strong>Dynamic Programming</strong>.
[comment]: keywords=Regular Expression Matching, Dynamic Programming
[comment]: robots=index, follow



<h1>Regular Expression Matching</h1>
<p>
This page explains Java solution to problem <code class="inline">Regular Expression Matching</code> using <a href="https://www.codingcargo.com/what-is-dynamic-programming" class="absolute" target="_blank" rel="noopener noreferrer">Dynamic Programming</a>.
</p>



<h2 class="heading">Problem Statement</h2>
<p>
Given an input string <code class="inline">s</code> and a pattern <code class="inline">p</code>, implement regular expression matching with support for <code class="inline">.</code> and <code class="inline">*</code>.
</p>
<p>
<code class="inline">.</code> Matches any single character.<br/>
<code class="inline">*</code> Matches zero or more of the preceding element.
</p>



<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: s = "aa", p = "a"<br/>
<b>Output</b>: false<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: s = "aab", p = "c*a*b"<br/>
<b>Output</b>: true<br/>
</p>
</blockquote>

<b>Example 3:</b>
<blockquote>
<p>
<b>Input</b>: s = "mississippi", p = "mis*is*p*."<br/>
<b>Output</b>: false<br/>
</p>
</blockquote>




<h2 class="heading">Solution</h2>
<p>
The Tricky Part of this problem is to see how we should handle <code class="inline">*</code> and <code class="inline">.</code> in a pattern <code class="inline">p</code>, so let's get started by writing a skeleton for Dynamic Programming.
</p>

<h2 class="heading">Skeleton Code</h2>
<p>
First, we will define a 2d boolean matrix of length <code class="inline">(m + 1) * (n + 1)</code> where <code class="inline">m</code> is the length of input string <code class="inline">s</code>, and <code class="inline">n</code> is the length of pattern <code class="inline">p</code>. <br />
Next, we will write a skeleton code for dynamic programming as below. 
</p>
<pre>
<code class="language-java">
if(s == null && p == null) return true;
if(s == null || p == null) return false;<br/>
int m = s.length();
int n = p.length();
boolean[][] dp = new boolean[m + 1][n + 1];<br />
for(int si = 0; si <= m; si++) {
    for(int pi = 0; pi <= n; pi++) {
        if(si == 0 && pi == 0) {
            //if length of input string si & input pattern pi is 0
            ???
        }
        else if(pi == 0) {
            //if length of input pattern pi is 0
            ???
        }
        else if(si == 0) { 
            //if length of input string si is 0<br/>
            //here pi will be > 0, so we have to handle special cases * and .
            if(p.charAt(pi - 1) == '*') {
                ???
            }
            else if(p.charAt(pi - 1) == '.') {
                ???
            }
            else {
                ???
            } 
        }       
        else {
            //if length of input string as well as input pattern is > 0<br/>
            //here pi will be > 0, so we have to handle special cases * and .
            if(p.charAt(pi - 1) == '*')  {
                ???
            }
            else if(p.charAt(pi - 1) == '.') {
                ???
            }
            else if(p.charAt(pi - 1) == s.charAt(si - 1)) {
                ???
            }
            else {
                ???
            }
        }
    }
}
</code>
</pre>


<br />
<p>
Now let's consider sample input <code class="inline">s = "aab"</code> and <code class="inline">p = "c*.*b"</code> and fill in the 2d array.
</p>
<p>
If the length of the input string and input pattern is zero, then our answer will be True, so let's fill that in our 2d <code class="inline">dp</code> array and in place of <code class="inline">???</code> in skeleton code.
</p>
<p>
With the above case, our code becomes
</p>
<pre>
<code class="language-java">
    if(si == 0 && pi == 0) {
        dp[si][pi] = true;
    }
</code>
</pre>
<p>
And our 2d <code class="inline">dp</code> array becomes
</p>
<table>
    <tr>
        <th class="heading"></th>
        <th>0</th>
        <th>c</th>
        <th>*</th>
        <th>.</th>
        <th>*</th>
        <th>b</th>
    </tr>
    <tr>
        <th>0</th>
        <td>T</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <th>a</th>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <th>a</th>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <th>b</th>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>             
</table>


<br/>
<p>
If the length of the input pattern is zero and the input string is &gt; zero, then our answer will always be False, so let's fill that in our 2d <code class="inline">dp</code> array and in place of <code class="inline">???</code> in skeleton code.
</p>
<p>
With the above cases, our code becomes 
</p>
<pre>
<code class="language-java">
    else if(pi == 0) {
        //if length of input pattern pi is 0
        dp[si][pi] = false;
    }
</code>
</pre>
<p>
And our 2d <code class="inline">dp</code> array becomes
</p>
<table>
    <tr>
        <th class="heading"></th>
        <th>0</th>
        <th>c</th>
        <th>*</th>
        <th>.</th>
        <th>*</th>
        <th>b</th>
    </tr>
    <tr>
        <th>0</th>
        <td>T</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <th>a</th>
        <td>F</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <th>a</th>
        <td>F</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <th>b</th>
        <td>F</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>             
</table>


<br/>
<p>
If the length of the input string is zero, and the input pattern is &gt; zero, then our answer will have three conditions as below.
</p>
<ul>
    <li>
       <b>Case 1</b>: If a character in the pattern is <code class="inline">*</code>, then we can ignore the last two elements in the input pattern as <code class="inline">*</code> can match zero or more of the preceding element.
    </li>
    <li>
       <b>Case 2</b>: If a character in the pattern is <code class="inline">.</code>, then we assign False because the input string is empty.
    </li>
    <li>
       <b>Case 3</b>: If a character in pattern is anything other than <code class="inline">*</code> and <code class="inline">.</code>, then we assign False as the input string is empty.
    </li>
</ul>
<p>
With the above cases, our code becomes
</p>
<pre>
<code class="language-java">
    else if(si == 0) { 
        //if length of input string si is 0<br/>
        //here pi will be > 0, so we have to handle special cases * and .
        if(p.charAt(pi - 1) == '*') {
            dp[si][pi] = dp[si][pi - 2];
        }
        else if(p.charAt(pi - 1) == '.') {
            dp[si][pi] = false;
        }
        else {
            dp[si][pi] = false;
        } 
    }   
</code>
</pre>
<p>
And our 2d <code class="inline">dp</code> array becomes
</p>
<table>
    <tr>
        <th class="heading"></th>
        <th>0</th>
        <th>c</th>
        <th>*</th>
        <th>.</th>
        <th>*</th>
        <th>b</th>
    </tr>
    <tr>
        <th>0</th>
        <td>T</td>
        <td>F</td>
        <td>T</td>
        <td>F</td>
        <td>T</td>
        <td>F</td>
    </tr>
    <tr>
        <th>a</th>
        <td>F</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <th>a</th>
        <td>F</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <th>b</th>
        <td>F</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>             
</table>



<br/>
<p>
If the length of the input string is &gt; zero and the input pattern is &gt; zero, then our answer will have three cases as below.
</p>
<ul>
    <li>
       <b>Case 1</b>: If a character in the pattern is <code class="inline">*</code>
       <ul>
            <li>Then, we can ignore the last two characters in input pattern, and see if that gives us a match as <code class="inline">*</code> can match zero or more of the preceding element.</li>
            <li>Or we can see if the preceding character in the pattern was<code class="inline">.</code>, if so we can ignore the current element in the input string and see if that returns us a match.</li>
            <li>Or we can see if the preceding character in a pattern matches the current element in the input string.</li>
       </ul>  
    </li>
    <li>
       <b>Case 2</b>: If a character in the pattern is <code class="inline">.</code>, then we can ignore the current element from both the input string and see if that returns us a match, as <code class="inline">.</code> can match any character.
    </li>
    <li>
       <b>Case 3</b>: If a character in the pattern is anything other than <code class="inline">*</code> and <code class="inline">.</code>,
        <ul>
            <li>Then we check if the current character in the pattern matches the current element in a string if, so we can ignore the current character from both the input string and see if that returns us a match.</li>
            <li>Or the preceding character in the pattern is <code class="inline">.</code> if, so we can ignore the current element from both the input string and see if that returns us a match.</li>
        </ul> 
    </li>
    <li>
        <b>Case 4</b>: Else we return False.
    </li>
</ul>
<p>
With the above case, our code becomes
</p>
<pre>
<code class="language-java">
    else {
        //if length of input string as well as input pattern is > 0<br/>
        //here pi will be > 0, so we have to handle special cases * and .
        if(p.charAt(pi - 1) == '*')  {
            dp[si][pi] = dp[si][pi - 2];
            if(p.charAt(pi - 2) == '.' || p.charAt(pi - 2) == s.charAt(si - 1)) {
                dp[si][pi] |= dp[si - 1][pi];
            }
        }
        else if(p.charAt(pi - 1) == '.') {
            dp[si][pi] = dp[si - 1][pi - 1];
        }
        else if(p.charAt(pi - 1) == s.charAt(si - 1)) {
            dp[si][pi] = dp[si - 1][pi - 1];
        }
        else {
            dp[si][pi] = false;
        }
    }  
</code>
</pre>
<p>
And our 2d <code class="inline">dp</code> array becomes
</p>
<table>
    <tr>
        <th class="heading"></th>
        <th>0</th>
        <th>c</th>
        <th>*</th>
        <th>.</th>
        <th>*</th>
        <th>b</th>
    </tr>
    <tr>
        <th>0</th>
        <td>T</td>
        <td>F</td>
        <td>T</td>
        <td>F</td>
        <td>T</td>
        <td>F</td>
    </tr>
    <tr>
        <th>a</th>
        <td>F</td>
        <td>F</td>
        <td>F</td>
        <td>T</td>
        <td>T</td>
        <td>F</td>
    </tr>
    <tr>
        <th>a</th>
        <td>F</td>
        <td>F</td>
        <td>F</td>
        <td>F</td>
        <td>T</td>
        <td>F</td>
    </tr>
    <tr>
        <th>b</th>
        <td>F</td>
        <td>F</td>
        <td>F</td>
        <td>F</td>
        <td>F</td>
        <td>T</td>
    </tr>             
</table>


<br />
<p>
Once we have filled in all the elements in 2d <code class="inline">dp</code> array, we will have our answer from <code class="inline">dp[m][n].</code>
</p>


<h2 class="heading">Complete Java code</h2>
If you have any suggestions in below code, please create a pull request <a href="####LINK_PLACEHOLDER####" target="_blank" rel="noopener noreferrer" class="absolute">here</a>
<pre>
<code class="language-java">
####CODE_PLACEHOLDER####
</code>
</pre>