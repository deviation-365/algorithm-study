def solution(arr, divisor):
    answer = sorted(list(filter(lambda x : x % divisor == 0, arr)))
    return answer or [-1]
