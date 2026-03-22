<h2><a href="https://www.geeksforgeeks.org/problems/minimum-x-xor-a--170645/1">Minimum X (xor) A</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given two integers&nbsp;<strong>a</strong> and <strong>b</strong>, the task is to find an integer&nbsp;<strong>x</strong> such that <strong>(x XOR a)</strong> is minimum possible and the count of set bit in&nbsp;<strong>x</strong> is equal to the count of set bits in <strong>b</strong>.</span></p>
<p><span style="font-size: 18px;"><strong>Example 1:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong> 
a = 3, b = 5
<strong>Output:</strong> 3
<strong>Explanation:</strong>
Binary(a) = Binary(3) = 011
Binary(b) = Binary(5) = 101
The XOR will be minimum when x = 3
i.e. (3 XOR 3) = 0 and the number
of set bits in 3 is equal
to the number of set bits in 5.</span></pre>
<p><span style="font-size: 18px;"><strong>Example 2:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong> 
a = 7, b = 12
<strong>Output:</strong> 6
<strong>Explanation:</strong>
(7)<sub>2</sub>= 111
(12)<sub>2</sub>= 1100
The XOR will be minimum when x = 6 
i.e. (6 XOR 7) = 1 and the number 
of set bits in 6 is equal to the 
number of set bits in 12.</span></pre>
<div><strong><span style="font-size: 18px;">Your task :</span></strong></div>
<div><span style="font-size: 18px;">You don't need to read input or print anything. Your task is to complete the function <strong>minVal()</strong> that takes integer a and b as input and returns the value of x according to the question.</span></div>
<div>&nbsp;</div>
<div><strong><span style="font-size: 18px;">Constraints :</span></strong></div>
<div><span style="font-size: 18px;">1 &lt;= a, b &lt;= 10<sup>9</sup></span></div>
<div>&nbsp;</div></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Adobe</code>&nbsp;<code>IBM</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Bit Magic</code>&nbsp;<code>Data Structures</code>&nbsp;