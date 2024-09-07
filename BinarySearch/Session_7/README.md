<h2><a href="https://leetcode.com/problems/koko-eating-bananas">Koko Eating Bananas</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Koko loves to eat bananas. There are <code>n</code> piles of bananas, the <code>i<sup>th</sup></code> pile has <code>piles[i]</code> bananas. The guards have gone and will come back in <code>h</code> hours.</p>

<p>Koko can decide her bananas-per-hour eating speed of <code>k</code>. Each hour, she chooses some pile of bananas and eats <code>k</code> bananas from that pile. If the pile has less than <code>k</code> bananas, she eats all of them instead and will not eat any more bananas during this hour.</p>

<p>Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.</p>

<p>Return <em>the minimum integer</em> <code>k</code> <em>such that she can eat all the bananas within</em> <code>h</code> <em>hours</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> piles = [3,6,7,11], h = 8
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> piles = [30,11,23,4,20], h = 5
<strong>Output:</strong> 30
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> piles = [30,11,23,4,20], h = 6
<strong>Output:</strong> 23
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= piles.length &lt;= 10<sup>4</sup></code></li>
	<li><code>piles.length &lt;= h &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= piles[i] &lt;= 10<sup>9</sup></code></li>
</ul>

#### Link - https://leetcode.com/problems/koko-eating-bananas/description/ 

#### Meaning :- Given an array of size “N”; b[i] tells you the numbers of bananas in box “i” ; you have to select k which is your eating power 

#### And you have to select k in such a manner that you are able to eat all bananas in <=h hours; 

#### Explanation:

    In 1 hour you can only eat k bananas! 

    -> [5 8 6 3 1] h = 8 

    K = 1 …………………………….Takes 23 hours. 
    K = 2……………………………..Takes 13 hours. 
    K = 3………………………………Takes 9 hours.
    K = 4……………………………….Takes 8 hours.


    Hence K = 4 is the answer because it gets the job done in <=8 hours. 


#### Observation

    As the value of K increases the time taken decreases. 


    K = 5…………………………………Takes 7 hours.
    K = 6…………………………………It will surely take <=7 hours. 

    K = 5,6,7,...............................INFINITY ALL ARE CORRECT ANSWERS BECAUSE THEY DO THE JOB IN <=8 HOURS.

    BUT QUESTIONS IS ASKING THE MIN VALUE OF K HENCE WE OUTPUT K = 4. 


    -> FFFTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT


    Write the code to find occurrence of “T”

    -> H can never be < N. H>=N. 

    K = 1…2,,,,3…..4……………………………………………..Max_number in the array 

#### Brute force algorithm

    ->n.
    ->read(n)
    ->b[n+1]
    -> h. read(h.)
    for(i=1;i<=n;i++){
        read(b[i])
        
        tr = max(tr,b[i])
    }

    answer = 0 
    for(k=1;k<=v;k++){ //o(v)
        
        if(check(k,b)==false.){
            
        }
        else{
            answer = k 
            break 
        }
        
    }


    print(k)


    check(k,b){
        sum = 0 
        for(i=1;i<=n;i++){
            if(b[i]%k==0){
            sum = sum + (b[i]//k)
            }
            else   {
            sum = sum + (b[i]//k) + 1     
            }
        }
        if(sum<=h){
            return true;
        }
        return false;
    }

    TC :- O(N*V) [N = 10^5 ; V = 10^9] = 10^14 > 10^8 -> Not efficient 

    —----------------------------------------------------------------------

#### Binary Search algorithm

    FFFFFTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT

    -> Given this sequence; find the first occurrence of “T” using binary search. 


    Algorithms. - https://ideone.com/DAJT9n.

    TC :- o(2n*logV) = O(N*logV) = (10^5*LOG(10^9)) =10^5*30 = 3*10^6 < 10^8 -> Hence it is efficient 

 
    C++ https://leetcode.com/problems/koko-eating-bananas/submissions/1203824967/

    Java https://leetcode.com/problems/koko-eating-bananas/submissions/1203826491/

    Py https://leetcode.com/problems/koko-eating-bananas/submissions/1203827728/ 
