#https://leetcode.com/problems/relative-sort-array/
import collections
class Solution:
    '''
        주어진 수로 가능한 모든 조합을 반환하는 문제.
        단, 같은 수를 중복해서 사용할 수 없다.
    '''
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        # 풀이
        # 재귀 함수를 통해 각각의 원소를 매번 재접근한다.
        # 문제 조건에서 같은 수의 중복 사용이 불가하므로 방문 처리가 필요함을 유의한다.
        result = []
        m = len(nums)
        arr = [0] * m
        # 인덱스의 방문 여부를 저장한다.
        used = [False] * m
        # idx는 arr에 추가되어야 할 값의 인덱스를 뜻한다.
        def permute(idx):
            if idx == m and arr[:m] not in result:
                result.append(arr[:m])
                return
            for i in range(0, m):
                if used[i]:
                    continue
                arr[idx] = nums[i]
                # 현재 값을 방문 처리하고 재귀 호출 한 뒤, 방문 처리를 해제한다.
                used[i] = True
                permute(idx + 1)
                used[i] = False
        permute(0)
        return result
        