Subarrays with XOR ‘K’
======================

Easy

![](https://files.codingninjas.in/yellow-spark-22969.svg)


Problem statement
-----------------

Send feedback

Given an array _**‘A’**_ consisting of _**‘N’**_ integers and an integer _**‘B’**_, find the number of subarrays of array ‘A’ whose bitwise XOR( ⊕ ) of all elements is equal to ‘B’.

  

A subarray of an array is obtained by removing some(zero or more) elements from the front and back of the array.

  

**Example:**

    Input: ‘N’ = 4 ‘B’ = 2
    ‘A’ = [1, 2, 3, 2]
    
    Output: 3
    
    Explanation: Subarrays have bitwise xor equal to ‘2’ are: [1, 2, 3, 2], [2], [2].
    

Detailed explanation ( Input/output format, Notes, Images )

**Input Format**

    The first line contains two integers, ‘N’ and ‘B’, denoting the size of the array ‘A’ and integer ‘B’, respectively.
    The following line contains ‘N’ integers, denoting the ‘A’.
    

**Output format:**

    Return the number of subarrays of array ‘A’ whose bitwise xor of all elements is equal to ‘B’.
    

**Note:-**

    You don't need to print anything. Just implement the given function.
    

**Sample Input 1:**

    4 2
    1 2 3 2
    

**Sample Output 1 :**

    3
    

**Explanation Of Sample Input 1:**

    Input: ‘N’ = 4 ‘B’ = 2
    ‘A’ = [1, 2, 3, 2]
    
    Output: 3
    
    Explanation: Subarrays have bitwise xor equal to ‘2’ are: [1, 2, 3, 2], [2], [2].
    

**Sample Input 2:**

    4 3
    1 2 3 3
    

**Sample Output 2:**

    4
    

**Sample Input 3:**

    5 6
    1 3 3 3 5 
    

**Sample Output 3:**

    2
    

**Constraints:**

    1 <= N <= 10^3
    1 <= A[i], B <= 10^9
    
    Time Limit: 1-sec
