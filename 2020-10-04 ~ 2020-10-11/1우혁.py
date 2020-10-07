  #https://programmers.co.kr/learn/courses/30/lessons/17681

def solution(n, arr1, arr2):
    '''
        이진수로 변환이 필요한 문제이다.
        파이썬에는 십진수로 된 두 정수의 or 연산 시
        두 정수를 이진수 1로 변환 후 비교하여
        두 정수의 변환된 이진수의 자릿 수의 1인 부분을 교집합으로 처리한 뒤,
        십진수로 변환하여 반환하는 기능이 있다.
        예) a, b = 5, 14
            a|b
            a = 101
            b = 1110
            ->  1111
            ->  15
    '''
    answer = []
    for i in range(n):
        answer.append(
            # 두 정수의 이진수 1의 교집합을 바이너리로 형변환한다.
            # 파이썬의 이진수 변환은 이진수 앞에 0b가 붙는다.
            # 예) bin(15) == '0b1111'
            # 때문에 앞의 두 자리를 제외한 값으로 슬라이싱한다.
            bin(arr1[i] | arr2[i])[2:]
                # zfill 함수는 n자리가 되도록 좌측에 0을 추가하는 함수.
                .zfill(n)
                # 기준에 맞도록 글자를 변환한다.
                .replace('1', '#')
                .replace('0', ' ')
        )
    return answer

    # 위의 코드를 리스트 컴프리헨션을 이용하여 단축한 코드는 아래와 같다.
    return [bin(arr1[i] | arr2[i])[2:].zfill(n).replace('1', '#').replace('0', ' ') for i in range(n)]