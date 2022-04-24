"""
Tạo thêm một khoảng trắng, một mảng có độ dài n (tiền tố) , một biến (tổng) , độ dài (max_len) và một bản đồ băm (hm) để lưu trữ cặp chỉ mục tổng dưới dạng một cặp khóa-giá trị.
Di chuyển dọc theo mảng đầu vào từ đầu đến cuối.
Đối với mọi chỉ mục, hãy cập nhật giá trị của sum = sum + array [i].
Kiểm tra mọi chỉ mục, nếu tổng hiện tại có trong bản đồ băm hay không.
Nếu có, hãy cập nhật giá trị của max_len thành chênh lệch tối đa của hai chỉ số (chỉ mục hiện tại và chỉ mục trong bản đồ băm) và max_len.
Ngoài ra, hãy đặt giá trị (tổng) vào bản đồ băm, với chỉ mục là một cặp khóa-giá trị.
In độ dài tối đa (max_len).
"""
def maxLen(arr):
    hash_map = {}
    max_len = 0
    sum = 0
    for i in range(len(arr)):
        sum += arr[i] 
        if arr[i] == 0 and max_len == 0:
            max_len = 1
        if sum == 0:
            max_len = i + 1
        if sum in hash_map:
            max_len = max(max_len, i - hash_map[sum] )
        else:
            hash_map[sum] = i
    if max_len > 0:
        return max_len
    return -1
 
N=int(input())
arr = list(map(lambda x: int(x) , input().split()))
print(maxLen(arr))
