## Frog Jump II

### Problem Statement

    There are N stones, numbered 1,2,…,N. For each i (1 ≤ i ≤ N), the height of Stone i is h(i)

    There is a frog who is initially on Stone 1. He will repeat the following action some number of times to reach Stone N:

    If the frog is currently on Stone i, jump to one of the following: Stone i+1,i+2,…,i+K. Here, a cost of of ∣h(i) − h(j)∣ is incurred, where j is the stone to land on.
    
    Find the minimum possible total cost incurred before the frog reaches Stone N.

#### Constraints

    All values in input are integers.
    2 ≤ N ≤ 10^5
    1 ≤ K ≤ 100
    1 ≤ h(i) ≤ 10^4
 
#### Input

    Input is given from Standard Input in the following format:
    N
    h1, h2 . . . hN
​
 
#### Output

    Print the minimum possible total cost incurred.

#### Sample Input 1

    10 4
    40 10 20 70 80 10 20 70 80 60

#### Sample Output 1

    40
    If we follow the path 1 → 4 → 8 → 10, the total cost incurred would be 
    ∣40−70∣+∣70−70∣+∣70−60∣=40.
