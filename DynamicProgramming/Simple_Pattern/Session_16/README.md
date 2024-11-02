#### Problem: Stephen is doing an internship in a company for N days. Each day, he may choose either an easy task or a difficult task. He may also choose to perform no task at all. He chooses a difficult task on days when and only when he did not perform any work the previous day. The amount paid by the company for both the easy and difficult tasks can vary each day, but the company always pays more for difficult tasks.

#### Write an algorithm to help Stephen earn the maximum salary.

#### Input

##### The first line of the input consists of two space-separated integers - num and type, representing the number of days of the internship (N) and types of tasks available for each day (type (M) is always equal to 2), respectively.

##### The next N lines consist of M space-separated integers - easy and hard, representing the amount set to be paid for the easy task and the difficult task on that day, respectively.

#### Output

##### Print an integer representing the maximum salary that Stephen can earn.

#### Constraints

    1 ≤ num≤ 105
    type = 2
    2< hard < 104
    1 ≤ easy < hard

#### Example

##### Input:

    4  2
    1  2
    4  10
    20 21
    2  23

##### Output:
    
    33

##### Solution:

    https://ide.geeksforgeeks.org/online-java-compiler/8b1fcfe5-2d05-4196-9645-1d9f55041d10

##### Source:

    https://www.desiqna.in/10567/barclays-sde-coding-oa-questions-and-solutions-set-8-2022-dp
