


B = [5 8 10 2 5 5] 

P[i] = sum of the first “i” numbers in the array 

for(i=1;i<=n;i++){

p[i] = p[i-1]+b[i]

}

For any integer “y” you can output p[y] in O(1) because all p have been pre-calculated from 1 to N.

P1[i] = maximum sum of subarray ending at index “i”

Can be calculated in O(N^2) using brute force. 



for(i=1;i<=n;i++){
     sum = 0
     t = 0 
     for(j=i;j>=1;j–){  
          sum = sum + b[j] 
          //sum = sum(j…….i)
          t = max(t,sum) 
      }
      p1[i]=t
} 

O(N) - 
for(i=1;i<=n;i++){
      p1[i]=max(p1[i-1]+b[i],b[i],0)
} 

Max(p1[1]......................p1[n]) = max sum subarray for the whole array 

C++ https://ideone.com/PuM3Y2. 
Java. https://ideone.com/5uK0R6. 
Py https://ideone.com/5t6xcg 

Kadane’s Algorithm:- Same as above just remove the p1[]

T = 0 
for(i=1;i<=n;i++){
      current=max(prv+b[i],b[i],0)
      prv=current  
      T=max(T,current)
} 

print(T)  = max sum subarray for the whole array 

C++ https://ideone.com/lNZWLQ. 
Py https://ideone.com/PXZgi1 
Java. https://ideone.com/CR84rN.  
—-------------------------------------------------------------------

Given an array find two subarrays of maximum sum which are not intersecting 
(Both the subarrays are allowed to be 0) 

Iterate over all possible partitions. 

When stick is at end of first position answer is g1 

When stick is at end of second position answer is g2
.
.
.
.
.
.
.
.
.
.

……………………………………………………………………………………….

Max(g1,............................................)


 G[i] = left best subarray + right best subarray 


s1[i] = best sum subarray starting at index “i” (calculate from backwards.)

Left best subarray = max(p1[1],................p1[i]) 

Right best subarray = max(s1[n],.............s1[i+1]) 



C++ - https://ideone.com/8OiD21
Java - https://ideone.com/cWWNHm
Py - https://ideone.com/etxH65
