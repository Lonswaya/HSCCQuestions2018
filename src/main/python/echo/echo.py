import sys

N = int(sys.stdin.readline().strip())

if (N <= 0 or N >= 100):
    print('INVALID INPUT')
    exit(0)

for i in range(N):
    line = sys.stdin.readline().strip()
    print(line)
