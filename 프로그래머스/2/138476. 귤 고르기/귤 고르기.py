from collections import Counter

def solution(k, tangerine):
    tangerine_counts = Counter(tangerine)
    
    sorted_counts = sorted(tangerine_counts.values(), reverse=True)
    
    sum_count = 0
    min_count = 0

    for i in sorted_counts:
        sum_count += i
        min_count += 1
        if sum_count >= k:
            return min_count