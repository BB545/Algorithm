def solution(s):
    s=s.split(" ")
    a=[]
    for i in s:
        if i:
            a.append(i[0].upper()+i[1:].lower())
        else:
            a.append(i)
            
    print(s)
    return " ".join(a)