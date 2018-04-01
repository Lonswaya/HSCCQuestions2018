import math
import sys

def checkConstraint(x, low, high):
    if (x < low or x > high):
        print('INVALID INPUT')
        exit(0)

Fs = int(sys.stdin.readline().strip())
Fp = int(sys.stdin.readline().strip())
Bs = int(sys.stdin.readline().strip())
Bp = int(sys.stdin.readline().strip())
X = float(sys.stdin.readline().strip())

checkConstraint(Fs, 0, 20000)
checkConstraint(Fp, 0, 1000)
checkConstraint(Bs, 0, 10000)
checkConstraint(Bp, 0, 1000)
checkConstraint(X, 0, 1000)

lowestPrice = 0
maxProfit = 0

for i in [x / 100.0 for x in range(1, 100001, 1)]:
    N = max(0, min(300, math.floor((300000)/(i) - i*X)))
    p = N*(i - Fp - Bp) - (Fs + Bs)
    if p > maxProfit:
        lowestPrice = i
        maxProfit = p

print(lowestPrice)
print("%.2f" % (maxProfit))