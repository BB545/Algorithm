def solution(s):
    s=s.split(" ")
    a=[]
    for i in s:
        if i:
            a.append(i[0].upper()+i[1:].lower())
        else:
            a.append(i)
    return " ".join(a)

#title : 문장에서 단어별 첫문자 대문자로 바꿈, 나머지는 소문자
#capitalize : 문장이나 단어에서 첫문자 대문자로, 나머지는 소문자
#s.split(" ") : 추가적인 공백을 별도로 분리해 저장가능
