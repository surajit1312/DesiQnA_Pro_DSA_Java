# Implement Upper Bound

## Problem Statement

You are given a sorted array `arr[]` of size `n` and a value `x`. Your task is to find the index of the first element in the array that is greater than `x`. If no such element exists, return `n` (the size of the array).

### Example

Consider the following examples to better understand the problem:

#### Example 1:
- **Input:** `arr[] = [1, 2, 4, 6, 8, 10]`, `x = 5`
- **Output:** `3`
- **Explanation:** The first element greater than 5 is 6, which is at index 3.

#### Example 2:
- **Input:** `arr[] = [1, 2, 4, 6, 8, 10]`, `x = 10`
- **Output:** `6`
- **Explanation:** No element is greater than 10, so the output is 6, which is the size of the array.

#### Example 3:
- **Input:** `arr[] = [1, 2, 4, 6, 8, 10]`, `x = 0`
- **Output:** `0`
- **Explanation:** The first element greater than 0 is 1, which is at index 0.

## Constraints

- `1 <= n <= 10^5`
- `1 <= arr[i] <= 10^9`
- `arr` is sorted in non-decreasing order.

## Explanation

    -> Given a sorted array of size “N”; find the index of the number in the array which is just greater than x and as close as possible to x.

    -> Upper Bound (x) = Returns index of the number which is just greater than x and as close as possible to x.

## Links

    C++ Code : - https://ideone.com/4TJbNc 

    Java Code : - https://ideone.com/t83TfR 

    Python Code :- https://ideone.com/zJbH4K 
