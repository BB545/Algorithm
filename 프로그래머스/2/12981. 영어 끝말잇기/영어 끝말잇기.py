def solution(n, words):
    a=[]
    b=[0,0]
    a.append(words[0])
    total = 0
    for i in range(1,len(words)):
        total=total+1
        if words[i] not in a and list(words[i-1])[-1]==list(words[i])[0]:
            a.append(words[i])
        else:
            b[0]=total%n+1
            b[1]=total//n+1
            break
    print(b)
    return b     