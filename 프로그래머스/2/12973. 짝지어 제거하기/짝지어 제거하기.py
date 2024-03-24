def solution(s):
    S=[]
    for i in range(len(s)):
        if len(S)==0:
            S.append(s[i])
        elif S[-1]==s[i]:
            S.pop()
        else:
            S.append(s[i])
    if len(S)==0:
        return 1
    else:
        return 0