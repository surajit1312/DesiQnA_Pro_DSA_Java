### Problem:

#### Understanding -> You are given two sorted arrays ; both arrays were of size N ;  you have to find a pair of numbers such that sum of those numbers <=x and as close as possible to x 

#### Input

    N = 4
    A = 1 4 5 7 
    B = 10 20 30 40 
    X = 32

#### Output

    -31 (1+30)

#### Approaches

##### Brute Force

    Calculate the possible sum for all pairs of both the arrays ; and output the sum closest to X. 

    A = [A1 A2 A3 A4 A5……………….AN]
    B = [B1 B2 B3 B4 B5………………BN] 

    -> I = 1 ; J =1 TO N 
    (A[1] + B[1] ; A[1] + B[2] ; A[1] + B[3] ; A[1] + B[4] ; A[1] + B[5]..........A[1] + B[N])
    -> I = 2 ; J = 1 TO N 
    (A[2] + B[1] ; A[2.....................................A[2]+B[N])

    Pseudo Code :->
    TC :- O(N*N)
    SC : - O(1) 

    https://ideone.com/hPMCXi
    
##### Efficient

    A = [1 2 3 4 5 6 ]
    B = [800 1000 1200 1500 1550 1800]

    Target is 1100 

    I = 1 ; j = 1 → a[1] + b[1] -> 1 + 800 -> 801 
    -> it means you need to increase the sum (801) so it reaches closer to 1100 
    -> What can you do to increase the sum ? WHAT NEXT STEP YOU CAN DO TO INCREASE THE SUM. 


    -> There are two options :->
    Either you increment the i pointer ( 2 + 800)

    OR

    You increment the j pointer (1 + 1000)

    -> Whenever you have two options you cannot decide which one is better -> 2 pointer algorithm will not work 

    -> 2 pointer algorithm will only work when there is exactly 1 option → so you can move in that direction towards your solution. 


    -> Lets do it in a different manner such that we have only 1 option. 

    I = 1 
    J = N 
    Answer = -1000000000
    SO IF SUM(A[I] + B[J] > TARGET){
    J = J - 1 

    }

    IF(a[i] + b[j]<=target){
    Track = a[i] + b[j] 
    Answer = max(track,answer) 
    I++
    }

    TC :- O(2N) -> O(N) 
    SC :- O(1) 

    C++ https://ideone.com/RWa98V 
    Java https://ideone.com/FDAxu7 
    Python https://ideone.com/UMHTYK 
