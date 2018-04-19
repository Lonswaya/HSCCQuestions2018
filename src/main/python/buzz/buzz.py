
import sys

N = int(sys.stdin.readline().strip())

if (N < 20 or N > 1000):
    print('INVALID INPUT')
    exit(0);

for i in range(1, N+1):
    if i % 5 == 0 and i % 7 == 0 and i % 15 == 0:
        print('BizzFuzzBuzz')
    elif i % 7 == 0 and i % 15 == 0:
        print('FuzzBuzz')
    elif i % 5 == 0 and i % 15 == 0:
        print('BizzBuzz')
    elif i % 5 == 0 and i % 7 == 0:
        print('BizzFuzz')
    elif i % 15 == 0:
        print('Buzz')
    elif i % 7 == 0:
        print('Fuzz')
    elif i % 5 == 0:
        print('Bizz')
    else:
        print(i)
