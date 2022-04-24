import string
def CountNumOfSentences(text):
    textt = str(text)
    special="!?"

    textt = textt.strip()
    textt = textt.translate(textt.maketrans(special,".."))
    words = textt.split(".")

    return len(words)-1

def DictionaryOfText(text):
    textt = str(text)

    d = dict()
    textt = textt.strip()
    textt = textt.translate(textt.maketrans("", "", string.punctuation))
    words = textt.split(" ")
    for word in words:
        if word in d:
            d[word] = d[word] + 1
        else:
            d[word] = 1
    return d
    
def CountNumOfWords(text):
    d=DictionaryOfText(text)
    return len(d)

def FrequencyOfWords(text):
    d = DictionaryOfText(text)

    for key in d.keys():
        print(key, ":", d[key])

def ListApearOnlyWords(text):
    d=DictionaryOfText(text)
    for key in d.keys():
        if d[key]==1:
            print(key, ":", d[key])


