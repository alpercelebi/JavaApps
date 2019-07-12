import random

mat = []
say = 0
x = [1, 3, 5, 6, 4, 589, 6, 4, 35]
sat = int(input("satır sayısını giriniz:"))
sut = int(input("sütun sayısını giriniz:"))
for i in range(sut):
    mat = mat + [[] * sat]
for i in range(sut):
    for k in range(sat):
        if i == k:
            mat[i].append(1)
        else:
            mat[i].append(0)

for i in mat:
    print (i)


