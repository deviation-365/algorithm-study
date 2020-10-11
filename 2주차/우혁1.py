#https://leetcode.com/problems/relative-sort-array/
import collections
class Solution:
    '''
        두 개의 리스트를 arr2에 나온 값을 기준으로 정렬한 뒤, arr1의 남은 값을 더 하는 문제.
        파이썬의 Counter 함수를 사용했다.
    '''
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        counter = collections.Counter(arr1)
        result = []
        for i in arr2:
            # arr2에 있는 값들을 카운팅된 갯수를 기준으로 곱한 뒤,
            # 리스트 result에 더한다.
            result += [i] * counter[i]
            # 처리된 값은 카운트를 0으로 변경한다.
            counter[i] = 0
        result2 = []
        for i in counter:
            # arr2에 등장하지 않는 값은 따로 합산한다.
            if counter[i] != 0:
                result2 += [i] * counter[i]
        # 문제의 조건에 맞도록 정렬한다.
        result2.sort()
        return result + result2