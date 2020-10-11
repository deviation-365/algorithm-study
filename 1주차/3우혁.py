  #https://leetcode.com/problems/two-sum/submissions/

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        '''
            주어진 리스트에서 target은 무조건 존재하기에 예외처리가 필요없다.
        '''
        # 딕셔너리를 선언한다.
        nums_map = {}
        # 인덱스가 필요하므로 list를 enumerate로 변환한다.
        for i, num in enumerate(nums):
            # *1 타겟에서 반복문의 현재 숫자를 뺀 값이 nums_map에 있다면 반환한다.
            # 예) nums = [2, 7, 11], target = 9
            # *2 num이 2일 때, 7이 nums_map에 존재하지 않는다. 그러므로 2를 추가한다.
            # 이 때, nums_map는 { 2 : 0 }이 된다.
            # num이 7일 때, 2는 nums_map에 존재한다. 그러므로 nums_map[2]의 값인 0과 현재 인덱스 1을 반환한다.
            # 반환값 [0, 1]
            if target - num in nums_map:
                return nums_map[target - num], i # *3
            nums_map[num] = i # *2