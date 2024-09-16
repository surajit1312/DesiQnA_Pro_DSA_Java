Find count of number of subarrays with sum ==  k 

Brute force approach 1:- For Every Index j, We will count the number of Valid Subarrays which have Sum as K and Ending at index j.

C++ - https://ide.geeksforgeeks.org/online-cpp14-compiler/8a4e7825-90ca-4e73-9b93-9654453b6f3d

Java - https://ide.geeksforgeeks.org/online-java-compiler/f4e1b043-40f1-4707-b8a5-b4432d9e817c

Py - https://ide.geeksforgeeks.org/online-python3-compiler/8219bf3d-2919-4eeb-9353-5ff19dafbcaa


Time Complexity - O(N*N)
Space Complexity - O(1)


Brute Force Approach 2 -

C++ - 
https://ide.geeksforgeeks.org/online-cpp14-compiler/ea0b96c0-61ec-4f7c-8bd4-9b0a5e0c2528

Java - https://ide.geeksforgeeks.org/online-java-compiler/9ec2b9a9-1fdd-40bb-867d-5cd4aece01f8

Py - https://ide.geeksforgeeks.org/online-python3-compiler/2a275b8c-dcf6-4a7b-97d7-cf0c289746ca

Time Complexity - O(N*N)
Space Complexity - O(N)

Optimised Approach:- Maintain the Prefix sum array and for every index J we will calculate X which will be equal to sum of elements till index j - k (X = P[j]-k). Now, do cnt = cnt + freq[x]
 And update freq of current sum as freq[currentSum]++


Time Complexity - O(N)
Space Complexity - O(N)

Pseudo Code - https://ideone.com/sEtny0

C++ - https://ideone.com/6r6NEF
Java - https://ideone.com/eN29dk
Py - https://ideone.com/Va6LEz
