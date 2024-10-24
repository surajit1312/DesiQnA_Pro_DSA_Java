### Problem:  Given an array of size “N”; find the longest subarray which has all distinct number in it 

#### Input: 

    [ 3 2 4 5 2 6 7 8 9 10] 

#### Output:

    8 

#### Approach

##### Brute-Force

    Pseudo Code: https://ideone.com/7c0Qrz. 
    C++: https://ideone.com/1W6GWZ
    Java: https://ideone.com/tvp8zy
    Py: https://ideone.com/

    TC - O(N*N)
    space.-> O(N) 


    You start at index i = 1 and try to find the largest subarray starting at i = 1 O(N)
    You start at index i = 2 and try to find the largest subarray starting at i = 2 O(N)

    You start at index i = 3 and try to find the largest subarray starting at i = 3 O(N.) 
    ,
    ,
    ,
    ,
    ,
    ,

    [1 3 8 4 8 2 10 11 15 18 111]

    At i = 0 largest valid subarray is [1 3 8 4] 

    At i = 1 largest valid subarray is [3 8 4.]

    The observation that you should do no calculation for i = 1 

    And directly make i = 3(Why?)

##### Optimal Approach:

    Pseudo Code: https://ideone.com/FwN3ib


    C++: https://ideone.com/lBdEdm
    Java: https://ideone.com/lqU9TH
    Py: https://ideone.com/qHiF5n

    TC : O(2*N.)

    -> O(N.) space. 

    We used hashamp for this problem average time complexity will be O(N.) but in worst it can take O(N^2) because hashmap takes O(N^2) in worst case which happens very rarely 

    Instead of hashmap if you use sorteddic in Py  Or Treemap in Java or map in C++

    In that case even the worst case time complexity will be O(NlogN.)

#### Solution:

    https://ide.geeksforgeeks.org/online-java-compiler/ca6ef17c-f9b1-42d1-9e16-67682a0d282b
