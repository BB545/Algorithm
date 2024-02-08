def solution(s):
    a=s.split()
    a=list(map(int,a))
    b=min(a)
    c=max(a)
    #answer=("%d %d" %(b,c))
    #print(answer)
    return str(b)+" "+str(c)
        
            