"""
Given a string s, return the length of the longest substring without repeating characters.
concept: Sliding window, hash map, two pointers
Time: O(n)
"""
def length_of_longest_substring(s: str) -> int:
    last_index_seen = {} # char -> last index
    left = 0
    max_len = 0

    for right, ch in enumerate(s):
        if ch in last_index_seen and last_index_seen[ch] >= left:
            left = last_index_seen[ch] +1
        
        last_index_seen[ch] = right
        max_len = max(max_len, right-left+1)
    
    return max_len


"""
Subarray Sum Equals K: Given an array nums and an integer k, return the number of contiguous subarrays whose sum equals k.
Concepts: Prefix sum, hash map
Time: O(n)

nums = [1, 2, 3]
k = 3
print(subarray_sum(nums, k))  # 2 -> [1,2], [3]

"""
from collections import defaultdict
from typing import List

def count_contiguous_subarrays(arr: List[int], k:int) -> int :
    prefix_count = defaultdict(int) # sum -> count
    prefix_count[0] = 1
    prefix_sum = 0
    count = 0

    for a in arr:
        prefix_sum += a
        count += prefix_count[prefix_sum-k]
        prefix_count[prefix_sum] += 1
    
    return count

"""
Product of Array Except Self

nums = [1, 2, 3, 4]
print(product_except_self(nums))  # [24, 12, 8, 6]
Time: O(n) – two linear passes
"""

def product_array_except_self(arr:List[int]) -> List[int]:
    n = len(arr)
    res = [1] * n
    
    prefix = 1
    for i in range(n):
        res[i] = prefix
        prefix *= arr[i]
    
    suffix = 1
    for i in range(n-1,-1,-1):
        res[i] *= suffix
        suffix *= arr[i]
    
    return res

"""
Top K Frequent Elements

nums = [1,1,1,2,2,3]
k = 2
print(top_k_frequent(nums, k))  # [1,2] (order may vary but those two)

Building counter: O(n)
Heapify: O(m) where m = unique elements
Pop k items: O(k log m)
Overall: O(n + m + k log m)

"""
from collections import Counter
import heapq
def top_k_frequent(nums:List[int], k:int) -> List[int]:
    
    counts = Counter(nums)
    heap = [(-count, nums) for num, count in counts.items()]
    res = []
    for i in range(k):
        count, num = heapq.heappop(heap)
        res.append(num)
    return res

"""
Merge Intervals
intervals = [[1,3],[2,6],[8,10],[15,18]]
print(merge_intervals(intervals))  # [[1,6],[8,10],[15,18]]

Sort: O(n log n)
Merge pass: O(n)
Overall: O(n log n)
"""
def merge_intervals(intervals: List[int]) -> List[int]: 
    intervals.sort(key = lambda x: x[0])
    start=0
    end=0
    merged = [intervals[0]]
    for start, end in intervals[1:]:
        if merged[-1][1]>=start:
            merged[-1][1] = max(merged[-1][1], end)
        else:
            merged.append([start, end])
    return merged


"""
Number of Islands (Grid DFS)
grid = [
    ["1","1","0","0","0"],
    ["1","1","0","0","0"],
    ["0","0","1","0","0"],
    ["0","0","0","1","1"]
]
print(num_islands(grid))  # 3

Time: O(R * C) – each cell visited at most once
Space: O(R * C) for visited + O(min(R, C)) stack in worst case
"""
def num_islands(grid: List[List[str]]) -> int:
    rows, cols = len(grid), len(grid[0])
    visited =[[False] * cols for _ in rows]
    
    def dfs(r :int , c: int):
        stack=[(r,c)]
        while stack:
            x,y = stack.pop()
            for dx, dy in [(-1,0), (1,0), (0,-1), (-1,-1)]:
                nx, ny = x + dx, y + dy
                if (0<=nx < rows and 0<=ny < cols
                    and not visited[nx][ny] and grid[nx][ny] == '1'):
                    stack.append((nx,ny))
                    visited[nx][ny] = True

    count=0
    for r in range(rows):
        for c in range(cols):
            if grid[r][c] == '1' and not visited[r][c]:
                visited[r][c] = True
                dfs(r, c)
                count += 1
 
    return count


"""
Coin change
"""
import math
def coin_change(coins: List[int], amount: int) -> int:
    dp = [math.inf]* (amount+1)
    dp[0]=0
    for c in coins:
        for a in range (c, amount+1):
            dp[a] = min(dp[a], dp[a-c]+1)
    
    return dp[amount] if dp[amount]!=math.inf else -1
