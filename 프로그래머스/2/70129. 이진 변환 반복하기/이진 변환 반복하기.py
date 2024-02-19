def solution(s):
    numc=0
    num0=0
    binary=""
    while True:
        if s=="1":
            break
        num0=num0+s.count("0")
        s=s.replace("0","")
        num=len(s)
        s=bin(num)[2:]
        numc=numc+1
    print(numc, num0)
    return [numc, num0]