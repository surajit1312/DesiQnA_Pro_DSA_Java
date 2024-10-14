### Problem: You are given a positive integer 'N’. Your task is to find and return the minimum number of steps that 'N' has to take to get reduced to 1. 

### You can perform any one of the following 3 steps:
#### 1) Subtract 1 from it. (n = n - ­1) ,
#### 2) If n is divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
#### 3) If n is divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).

### Explanation:

    Algorithm:- https://ideone.com/Mctn4Q.  

    p1 = 1 + dp[i-1]

    if(i%2==0){
    p2 = 1 + dp[i/2]
    }

    if(i%3==0){
    p3 = 1 + dp[i/3]
    }

    dp[i] = min(p1,min(p2,p3)) 

    —--------------------------------------------------------------------

    Reduce n to 1 
    If the number is even you can divide it by 2. 
    If the number is odd you can do +1 or -1

#### Solution Link:

    https://ide.geeksforgeeks.org/online-java-compiler/01317f46-d074-44b8-bbaf-5cfac129fb4e
