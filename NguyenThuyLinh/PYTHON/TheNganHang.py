
import re
out=[]
for _ in range(int(input())):
    CC = input()
    try:
        assert re.fullmatch(r'[456]\d{3}(-|)\d{4}(-|)\d{4}(-|)\d{4}',CC)
        assert not(re.search(r'(\d)\1{3,}',CC.replace("-","")))
        
    except AssertionError:
        out.append(False)
    else:
        out.append(True)
for i in range(len(out)):
    print(out[i])