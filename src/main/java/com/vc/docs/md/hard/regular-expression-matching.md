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
'.' Matches any single character.<br/>
'*' Matches zero or more of the preceding element.
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
Tricky part in this problem is to see how we should handle <code class="inline">*</code> and <code class="inline">.</code> in pattern <code class="inline">p</code> so let's gets started by writing a skeleton for Dynamic Programming and adding happy path and the special cases for handling <code class="inline">*</code> and <code class="inline">.</code>
</p>

<h2>Skeleton Code</h2>
<p>
First we will define a 2d boolean matrix of length <code class="inline">(m + 1) * (n + 1)</code> where <code class="inline">m</code> is length of input string <code class="inline">s</code> and <code class="inline">n</code> is length of pattern <code class="inline">p</code>. We add 1 to length input string and input pattern to make dynamic programming code look simpler.<br />
Next, we will write all the possible condition to handle happy path as well as special cases as below. 
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
If length of input string and input pattern is zero, then our answer will be true, so let's fill that in our 2d <code class="inline">dp</code> array and in place of <code class="inline">???</code> in skeleton code.
</p>
<p>
With above case our code becomes 
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
        <th></th>
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
If length of input pattern is zero and input string is &gt; zero, then our answer will always be false, so let's fill that in our 2d <code class="inline">dp</code> array and in place of <code class="inline">???</code> in skeleton code.
</p>
<p>
With above cases our code becomes 
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
        <th></th>
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
If length of input string is zero and input pattern is &gt; zero, then our answer will have three conditions as below.
</p>
<ul>
    <li>
       <b>Case 1</b>: If character in pattern is <code class="inline">*</code>, then we assign previous to previous value, because <code class="inline">*</code> can match zero or more character in regular expression and there is nothing to match in the input string.
    </li>
    <li>
       <b>Case 2</b>: If character in pattern is <code class="inline">.</code>, then we assign false because input string is empty.
    </li>
    <li>
       <b>Case 3</b>: If character in pattern is anything other than <code class="inline">*</code> and <code class="inline">.</code>, then we assign false as there is nothing to match in the input string.
    </li>
</ul>
<p>
With above cases our code becomes 
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
        <th></th>
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
If length of input string is &gt; zero and input pattern is &gt; zero, then our answer will have three cases as below.
</p>
<ul>
    <li>
       <b>Case 1</b>: If character in pattern is <code class="inline">*</code> <br />
       Then we can ignore two character in the pattern and see if it that value was true, considering <code class="inline">*</code> matches with zero character in the input string. <br />
       Also, we have to do additional check to see if previous character in pattern matches with current character in input string or previous character in pattern was<code class="inline">.</code>, if so we can ignore current character in the input string and see if we get true.
    </li>
    <li>
       <b>Case 2</b>: If character in pattern is <code class="inline">.</code>, then we assign value ignore current character in pattern as well as current character in input string, as <code class="inline">.</code> can match any character.
    </li>
    <li>
       <b>Case 3</b>: If character in pattern is anything other than <code class="inline">*</code> and <code class="inline">.</code>, then we check if current character in pattern matches with current character in string or previous character in the pattern was <code class="inline">.</code>, if so assign value ignoring current pattern character as well as current input string character else assign false.
    </li>
</ul>
<p>
With above cases our code becomes 
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
        <th></th>
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
Once we have filled in all the elements in 2d <code class="inline">dp</code> array, we will have our answer from <code class="inline">dp[m][n]</code>
</p>


<h2 class="heading">Complete Java code</h2>
If you have any suggestions in below code, please create a pull request <a href="####LINK_PLACEHOLDER####" target="_blank" rel="noopener noreferrer" class="absolute">here</a>
<pre>
<code class="language-java">
####CODE_PLACEHOLDER####
</code>
</pre>