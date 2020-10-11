  #https://programmers.co.kr/learn/courses/30/lessons/12930?language=python3

def solution(s):
    '''
        단어 단위로 구분하여 홀수는 대문자, 짝수는 소문자로 변환한다.
        '각 단어는 하나 이상의 공백문자로 구분되어 있습니다.' 라는 문구를 주의하자.
        만약 'a  bc'인 경우 'A Bc'가 아닌 'A  Bc'로 반환하여야한다.
    '''
    # 리스트가 아닌 문자열로 선언하여 불필요한 형변환 과정을 생략한다.
    result = ''
    # 띄어쓰기를 기준으로 split하여 반복문을 진행한다.
    for word in s.split(" "):
        for i in range(len(word)):
            # 기준에 따라 대, 소문자로 변환한다.
            if i % 2 == 0: result += word[i].upper()
            else: result += word[i].lower()
        # split으로 인해 사라진 공백을 마지막으로 추가한다.
        result += ' '
    return result[:-1]

    # 위의 코드를 리스트 컴프리헨션을 이용하여 단축한 코드는 아래와 같다.
    result = ''
    for i in s.split(" "):
        result += (''.join([i % 2 == 0 and v.upper() or v.lower() for i, v in enumerate(list(i))])) + " "
    return result[:-1]