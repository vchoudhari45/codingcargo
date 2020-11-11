[comment]: metadata=Java Solution to problem My Calendar III using TreeMap Data Structure.
[comment]: keywords=My Calendar III, TreeMap Data Structure
[comment]: robots=index, follow


<h1>My Calendar III</h1>
<p>
This page explains Java solution to problem <code class="inline">My Calendar III</code> using <code class="inline">TreeMap</code> data structure.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Implement a <code class="inline">MyCalendarIii</code> class to store your events. A new event can always be added.
</p>
<p>
Your class will have one method, <code class="inline">book(int start, int end)</code>. Formally, this represents a booking on the half open interval <code class="inline">[start, end)</code>, the range of real numbers <code class="inline">x</code> such that <code class="inline">start <= x < end</code>.
</p>
<p>
A K-booking happens when K events have some non-empty intersection (ie., there is some time that is common to all <code class="inline">K</code> events.)
</p>
<p>
For each call to the method <code class="inline">MyCalendar.book</code>, return an integer <code class="inline">K</code> representing the largest integer such that there exists a K-booking in the calendar.
</p>


<b>Example 1:</b>
<blockquote>
<p>
<b>Input</b>: <br/>
MyCalendarThree(); <br />
MyCalendarThree.book(10, 20); // returns 1<br />
MyCalendarThree.book(50, 60); // returns 1<br />
MyCalendarThree.book(10, 40); // returns 2<br />
MyCalendarThree.book(5, 15); // returns 3<br />
MyCalendarThree.book(5, 10); // returns 3<br />
MyCalendarThree.book(25, 55); // returns 3<br />
<b>Explanation</b>: <br/>
The first two events can be booked and are disjoint, so the maximum K-booking is a 1-booking. <br />
The third event [10, 40) intersects the first event, and the maximum K-booking is a 2-booking. <br />
The remaining events cause the maximum K-booking to be only a 3-booking. <br />
Note that the last event locally causes a 2-booking, but the answer is still 3 because <br />
eg. [10, 20), [10, 40), and [5, 15) are still triple booked. <br />
</p>
</blockquote>

<b>Example 2:</b>
<blockquote>
<p>
<b>Input</b>: A = [1,2], B = [3,4]<br/>
<b>Output</b>: 2.50000<br/>
<b>Explanation</b>: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5<br/>
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
O(N<sup>2</sup>) Where <br />
N is total number of bookings 
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(N) Where <br />
N is total number of bookings
</p>
</blockquote>