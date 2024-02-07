def solution(s):
    a=0
    b=0
    for i in range(0,len(s)):
        if s[i]=='p' or s[i]=='P':
            a=a+1
        elif s[i]=='y' or s[i]=='Y':
            b=b+1
        else:
            i=i+1
    if a==b:
        return True
    else:
        return False