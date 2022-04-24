
def binary_search(arr, low, high, x):
    if(x < arr[0]):
        return -1
    if high >= low:

        mid = (high + low) // 2

        if arr[mid] == x:
            return arr[mid]

        elif arr[mid] > x:
            return binary_search(arr, low, mid - 1, x)

        else:
            return binary_search(arr, mid + 1, high, x)

    else:
        return arr[(high + low) // 2]

N = int(input())
V = list(map(int, input().split()))
M = int(input())
out = []

for i in range(M):
    a = int(input())
    out.append(binary_search(V, 0, len(V) - 1, a))

for i in range(len(out)):
    print(out[i])
