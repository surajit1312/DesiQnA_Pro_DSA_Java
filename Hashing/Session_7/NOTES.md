Find largest/smallest subarray with sum k in Given Array


Brute Force Approach:- We will use 2 Nested for loop and where i will start from index 1 and it will end at index N. similarly J will start from i it will end at N and I denotes the starting point of any subarray and J will denote the ending point of any subarray. 

Now we will check if the sum of the elements present in the current sub array is equal to K we will update the maximum length with the current sub array's length

Pseudo Code:- https://ideone.com/dfi5m7

C++ - https://ideone.com/qu2x29
Java - https://ideone.com/yXWSxe
Py - https://ideone.com/wVb6w9


Optimised Approach:- Use the Hashmap and for every j, we will calculate i using formula p[i-1] = p[j] - k. Now we will check in map for the index where p[i-1] has come. We will calculate current Length using j-i+1 and compare this length with Max and Min length and Update them if necessary.


Pseudo Code - https://ideone.com/PSILCO

C++ - https://ide.geeksforgeeks.org/online-cpp14-compiler/5e855364-59d7-4372-abd7-e5d41f021bd0

Java - https://ide.geeksforgeeks.org/online-java-compiler/957f8f83-a8ab-4181-aa78-18f4ded1e3a2

Python - https://ide.geeksforgeeks.org/online-python3-compiler/a85bb0d4-8083-4819-b11c-8ba5e83cbf08
