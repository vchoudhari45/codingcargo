[comment]: metadata=Java Solution to problem <strong>Sudoku Solver</strong> using <strong>Backtracking</strong>.
[comment]: keywords=Sudoku Solver, Backtracking
[comment]: robots=index, follow






<h1>Sudoku Solver</h1>
<p>
This page explains Java solution to problem <code class="inline">Sudoku Solver</code> using <a href="####BASEURL####what-is-backtracking" class="absolute" target="_blank" rel="noopener noreferrer">Backtracking</a>.
</p>





<h2 class="heading">Problem Statement</h2>
<p>
Write a program to solve a <a href="https://simple.wikipedia.org/wiki/Sudoku" class="absolute" target="_blank" rel="noopener noreferrer">Sudoku puzzle</a> by filling the empty cells. Empty cells are indicated by the character '.'. 
</p>






<b>Example 1:</b>
<p class="paragraph-heading">Input: A Sudoku Puzzle</p>
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png" />

<p class="paragraph-heading">Output: It's Solution number marked in Red</p>
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Sudoku-by-L2G-20050714_solution.svg/250px-Sudoku-by-L2G-20050714_solution.svg.png" />




<h2 class="heading">Solution</h2>
<p>
We will be using backtracking to solve the problem. We start off with two for loop over 2d sudoku matrix to see if any cell is empty.
</p>
<p>
For each empty cell we try all the number from <code class="inline">1</code> to <code class="inline">9</code> and see if that number makes a valid sudoku, if not we backtrack.
</p>
<pre>
<code class="language-java">
//Start off with two for loops
for(int row = 0; row &lt; 9; row++) {
    for(int col = 0; col &lt; 9; col++) {< br />
        //Check if current cell is empty
        if(board[row][col] == '.') {
            //If current cell is empty try all the number from 1 to 9
            for(char num = '1'; num <= '9'; num++) {
                //Check if it makes a valid sudoku
                if(isValid(board, row, col, num)) {
                    board[row][col] = num;
                    //If so solve further 
                    if(solve(board)) return true;
                    //else backtrack
                    else board[row][col] = '.';
                }
            }
            return false;
        }
    }
}
</code>
</pre>


<p class="paragraph-heading">
Let's understand <code class="inline">isValid</code> function from above code. What is does is, Given a <code class="inline">board</code>, <code class="inline">row</code>, <code class="inline">col</code> & <code class="inline">num</code> check if adding a number at given <code class="inline">row</code> & <code class="inline">col</code> will still be a valid sudoku board.
</p>
<ul>
<li>To validate Row we simply check if board has the same <code class="inline">num</code> in any of the 9 Cols</li>
<li>To validate Col we simply check if board has the same <code class="inline">num</code> in any of the 9 Rows</li>
<li>Validating a block is little tricky we have to go to the start of the block by doing integer division as <code class="inline">blkStartRow = (row / 3) * 3</code> and start of the block column as <code class="inline">blkStartCol = (col / 3) * 3</code> and iterate over all the 9 number to see if block has same number. </li>
</ul>
<p>Code is as below</p>
<pre>
<code class="language-java">
private boolean isValid(char[][] board, int row, int col, char num) {
    int blkStartRow = (row / 3) * 3, blkStartCol = (col / 3) * 3;
    for(int i = 0; i &lt; 9; i++) {
        if(board[i][col] == num) return false;
        if(board[row][i] == num) return false;
        if(board[blkStartRow + i / 3][blkStartCol + i % 3] == num) return false;
    }
    return true;
}
</code>
</pre>




<h2 class="heading">Time Complexity</h2>
<blockquote>
<p>
O(9!)^9 <br />
For single Row there are 
    9 possibilities for first cell
    8 possibilities for second cell
    7 possibilities for third cell and so ....
So total there are 9! operations to fill in one row

There are 9 Rows in Sudoku, so total number of operations will be 9! ^ 9
</p>
</blockquote>




<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(9 * 9)
For storing 9 * 9 Grid
</p>
</blockquote>




<h2 class="heading">Complete Java code</h2>
If you have any suggestions in below code, please create a pull request <a href="####LINK_PLACEHOLDER####" target="_blank" rel="noopener noreferrer" class="absolute">here</a>
<pre>
<code class="language-java">
####CODE_PLACEHOLDER####
</code>
</pre>