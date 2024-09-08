### Problem

#### A student is preparing for a test from Amazon Academy for a scholarship.

#### The student is required to completely read n chapters for the test where the 
#### i-th chapter has pages[i] number of pages. The chapters are read in increasing
#### order of the index. Each day, the student can either read until the end of a 
#### chapter or at most x pages, whichever is smaller. The number of pages remaining
#### to read decreases by x in the latter case.

#### For example, if pages = [5, 3, 4] and x = 4:

####	•	Day 1: The student reads 4 pages of the first chapter. 
####        Pages remaining: [1, 3, 4]
####    •	Day 2: The student can only read till the end of the first chapter. Pages 
####        remaining: [0, 3, 4]
####    •	Day 1: The student can read either till the end of first chapter or at most 4  ####        pages whichever is smaller i.e. 4 pages

### Explanation

#### You are given an array of size “N” ; you are given a capacity of “k” ; 
#### Each element can be reduced by at most k in 1 move. You are allowed 
#### to make maximum “d” moves. Find the minimum possible value of “k” 


    Logic https://onecompiler.com/cpp/42afenytw

    C++ - https://onecompiler.com/cpp/42afer5hx

    Java - https://onecompiler.com/java/42afex4ye

    Python - https://onecompiler.com/python/42afez23v

    TC - O(N*limit) limit = max number in the array 
    Takes O(1) space. 

    Pattern of K - 

    FFFFFFFFFFTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT


    All you have to do is find the first occurrence of “T” which can be done by linear search. 

    But you can do it by Binary search for optimization. 


    Logic https://ideone.com/lbdx7n 

    C++ - https://onecompiler.com/cpp/42aff4vqz
    Java - https://onecompiler.com/java/42affbn4u
    Python - https://onecompiler.com/python/42affcxw9

    TC - O(N*log(limit))

    Takes O(1) size.
