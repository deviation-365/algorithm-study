def solution(s):
    if (s.isdigit()):
        return True if len(s) == 4 or len(s) == 6 else False
    return False
