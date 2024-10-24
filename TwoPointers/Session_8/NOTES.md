Link https://www.desiqna.in/17545/google-oa-first-subsequence-13th-july 

Prerequisite:-> 

Given two string “A” and “B” 

Please tell if string “B” appears in string “A” or not 

-> B should appear as any subset(in order) in “A.”

A = “utyuyty”

B = “yyt”

-> Yes. 

A = “gg”

B = “ik” 

-> No 

A = “pppggg”

B = “gp”
-> No 


Algorithm :-> i = 0 -> index of first character of string A.
 -> j = 0 -> index of first character if string B
N = A.size() 
M = B.size()
-> My job is to find B[0] in A.   count = 0 

while(i<n && j<n){
if(A[i]!=B[j]){
    i = i + 1 
}
Else
{
   i = i + 1
   j = j + 1
   Count = count + 1 -> success -> you were able to find a matching char for b
}


if(count==B.size()){
Yes.

}
Else { No } 

TC - O(2*N) =O(N)

Takes O(1) space. 



—------------------------------------------------------------------

Real QN. => Same as before but -> You are allowed to changed at max 1 character in string B 

-> If yes, print the first matching char in both the strings. 

->If no print -1 

Assume F(A,B) return true if B exists as subsequence in A. Algorithm runs in O(N+M.) 


f(string a,string b){

//same code as above. 

}




-> Each char at index “i” can be changed from ‘a’ to ‘z’ -> only 26 options for each index “i” if you decided to change the char at “i”


-> Please know qns; is telling you to change only 1 index.” 

-> Hence you can try all combinations. 

-> Only (N-1)*26 strings are possible as string B 


-> We can calculate F(A,B) for all of them. 

B => 26*(N-1) possibilities. 


-> Out of all of them whichever gives yes is your answer 












TC - O(N*N*26) = O(10^8) 













C++ https://www.jdoodle.com/ia/19rg 
Java. - https://ide.geeksforgeeks.org/online-java-compiler/56e1ec45-520d-4b2c-9aa8-6abea4bbb34e

Py -
https://ide.geeksforgeeks.org/online-python3-compiler/1620ba29-e1c0-4db4-ae79-8b07c26aa0a0


#### Solution Link:

    https://ide.geeksforgeeks.org/online-java-compiler/76de120b-d194-48ce-b577-f53f93438a0e
