[comment]: metadata=Java Solution to problem <strong>Merge K Sorted Lists</strong> using <strong>Linked List</strong> Data Structure.
[comment]: keywords=Merge K Sorted Lists, Priority Queue
[comment]: robots=index, follow






<h1>Merge K Sorted Lists</h1>
<p>
This page explains Java solution to problem <code class="inline">Merge K Sorted Lists</code> using <a href="####BASEURL####what-is-priority-queue" class="absolute" target="_blank" rel="noopener noreferrer">Priority Queue</a>.
</p>





<h2 class="heading">Problem Statement</h2>
<p>
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order. Merge all the linked-lists into one sorted linked-list and return it.
</p>





<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: lists = [[1,4,5],[1,3,4],[2,6]]<br/>
<b>Output</b>: [1,1,2,3,4,4,5,6]<br/>
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: lists = [[]]<br/>
<b>Output</b>: []<br/>
</p>
</blockquote>





<h2 class="heading">Solution</h2>
<p>
We will be using Priority Queue for solving this problem, so let's start by defining a Priority Queue of ListNode and assigning custom comparator to it. Custom comparator will return ListNode with least value at head position on poll request.
</p>
<p>
Next we will add all the input lists into the Priority Queue.
</p>
<pre>
<code class="language-java">
PriorityQueue&lt;ListNode&gt; pq = new PriorityQueue&lt;&gt;(new Comparator&lt;&gt;(){
   public int compare(ListNode l1, ListNode l2) {
       return Integer.compare(l1.val, l2.val);
   } 
});<br />
//Adding all elements from input lists into the Priority Queue.
for(ListNode list: lists) if(list != null) pq.offer(list);
</code>
</pre>





<p class="paragraph-heading">
Now we will poll the elements from Priority queue and append to a ListNode reference, which will be returned as an answer. And since all the elements in a single ListNode are already sorted it will return the elements in ascending order and we will get final ListNode in a sorted order. 
</p>
<pre>
<code class="language-java">
final ListNode res = new ListNode(-1);
ListNode head = res;
while(!pq.isEmpty()) {
    ListNode node = pq.poll();
    head.next = node;
    head = head.next;
    if(node.next != null) pq.offer(node.next);
}
return res.next;
</code>
</pre>




<h2 class="heading">Time Complexity</h2>
<blockquote>
<p>
O(N * log(K)) <br />
Where N is total number of elements in the final list and K is number of input lists. 
</p>
</blockquote>




<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(K)
Where K is number of input lists.
</p>
</blockquote>




<h2 class="heading">Complete Java code</h2>
If you have any suggestions in below code, please create a pull request <a href="####LINK_PLACEHOLDER####" target="_blank" rel="noopener noreferrer" class="absolute">here</a>
<pre>
<code class="language-java">
####CODE_PLACEHOLDER####
</code>
</pre>