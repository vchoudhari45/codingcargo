[comment]: metadata=Java Solution to problem <strong>Reverse Nodes in k-Group</strong> using <strong>Linked List</strong> Data Structure.
[comment]: keywords=Reverse Nodes in k-Group, Linked List
[comment]: robots=index, follow






<h1>Reverse Nodes in k-Group</h1>
<p>
This page explains Java solution to problem <code class="inline">Reverse Nodes in k-Group</code> using <a href="https://www.codingcargo.com/what-is-linked-list" class="absolute" target="_blank" rel="noopener noreferrer">Linked List</a>.
</p>





<h2 class="heading">Problem Statement</h2>
<p>
Given a linked list, reverse the nodes of a linked list <code class="inline">k</code> at a time and return its modified list.
</p>
<p>
<code class="inline">k</code> is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of <code class="inline">k</code> then left-out nodes in the end should remain as it is.
</p>





<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: lists = 1->2->3->4->5,  k = 2<br/>
<b>Output</b>: 2->1->4->3->5<br />
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: lists = 1->2->3->4->5,  k = 3<br/>
<b>Output</b>: 3->2->1->4->5<br />
</p>
</blockquote>





<h2 class="heading">Solution</h2>
<p>
Tricky part in this problem is to figure out how to reverse singly linked list, as In Singly Linked list every element has reference to it's next element, so let's understand it first.
</p>
<p>
We start by creating four reference variable called <code class="inline">dummyNode</code>, <code class="inline">prev</code>, <code class="inline">current</code> and <code class="inline">next</code> as below.
</p>
<img src="####BASEURL####reverse-linked-list/reverse-1.png" alt="Reverse Linked List 1" /> 
<pre>
<code class="language-java">
final ListNode dummyNode = new ListNode();
dummyNode.next = head;<br />
ListNode prev = dummyNode;
current = prev.next;
ListNode next = current.next;
</code>
</pre>


<p class="paragraph-heading">
Next we replace <code class="inline">current.next</code> reference with <code class="inline">next.next</code> reference.
</p>
<img src="####BASEURL####reverse-linked-list/reverse-2.png" alt="Reverse Linked List 2" /> 
<pre>
<code class="language-java">
current.next = next.next;
</code>
</pre>


<p class="paragraph-heading">
Then we replace <code class="inline">next.next</code> reference with <code class="inline">prev.next</code> reference.
</p>
<img src="####BASEURL####reverse-linked-list/reverse-3.png" alt="Reverse Linked List 3" /> 
<pre>
<code class="language-java">
next.next = prev.next;
</code>
</pre>


<p class="paragraph-heading">
Then we replace <code class="inline">prev.next</code> reference with <code class="inline">next</code> reference.
</p>
<img src="####BASEURL####reverse-linked-list/reverse-4.png" alt="Reverse Linked List 4" /> 
<pre>
<code class="language-java">
prev.next = next;
</code>
</pre>


<p class="paragraph-heading">
Then we update <code class="inline">next</code> with <code class="inline">current.next</code> reference.
</p>
<img src="####BASEURL####reverse-linked-list/reverse-5.png" alt="Reverse Linked List 5" /> 
<pre>
<code class="language-java">
next = current.next;
</code>
</pre>


<p class="paragraph-heading">
Now that we understand how to reverse singly linked list, this problem becomes fairly simple. All we have to do is apply the reverse linked list logic until current element index <code class="inline">i</code> is not equal to <code class="inline">k</code> where <code class="inline">k</code> is number of elements which needs to be reversed in a group.
</p>
<pre>
<code class="language-java">
int i = 1;
while(next != null) {
    if(total &lt; k) return dummyNode.next;
    //When current element i completes a group our logic should stop reversing elements in a current group
    if(i % k == 0) {
        total -= k;
        prev = current;
        current = next;
        next = next.next;
    }
    else {
        current.next = next.next;
        next.next = prev.next;
        prev.next = next;
        next = current.next;
    }
    i++;
}
</code>
</pre>


<h2 class="heading">Time Complexity</h2>
<blockquote>
<p>
O(N) <br />
Where N is total number of elements in input list. 
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