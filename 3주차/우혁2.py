# https://leetcode.com/problems/swap-nodes-in-pairs/
class Solution:
    '''
        페어 단위로 노드를 스왑한다.
        단순하게 생각하면 1 - 2 - 3 - 4에서 1과 2, 3과 4를 서로 바꾸기만 하면 될 거 같지만
        1이 4를 가르켜야 함을 유의한다.
        만약 1과 2, 3과 4를 서로 바꾸기만 한다면 아래와 같은 결과가 나오게 된다.
        2 -> 1
        1 -> 3
        3 -> None
        4 -> 3
        위의 문제를 해결하기 위해서 별도의 공간 또는 재귀함수가 필요하다.
    '''
    def swapPairs(self, head: ListNode) -> ListNode:
        # head가 비어있거나 next가 없다면 재귀 종료 조건에 해당한다.
        if not head or not head.next:
            return head
        # prev는 현재 노드, cur은 다음 노드를 초기 값으로 지정한다.
        # 이후 prev에 현재 노드를, cur에 현재 노드의 다음 노드로 위치를 바꾸게 되면, 두 노드의 위치를 바꾸는 셈.
        # 재귀 호출로 다음 노드 cur의 다음 값을 전달한다.
        # cur의 next로 prev를 지정한다.
        # 1 - 2 - 3 - 4의 흐름은 아래와 같다.
        # 1) prev = 1
        # 2) cur = 2
        # 3) prev.next = 재귀호출(3)
        # 4) cur.next = 1
        # 5) prev = 3
        # 6) next = 4
        # 7) prev.next = 재귀호출(None)
        # 8) cur.next = 3
        # 9) 재귀호출(None) 종료, None 반환, 3의 next는 None가 된다.
        # 10) 재귀호출(3)종료, 4 반환, 1의 Next는 4가 된다.
        # 11) 2 반환
        prev, cur = head, head.next
        prev.next, cur.next = self.swapPairs(cur.next), prev       
        return cur
