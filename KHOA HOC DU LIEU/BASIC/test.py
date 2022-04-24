from dict_package.mylib import CountNumOfWords, CountNumOfSentences, FrequencyOfWords,DictionaryOfText,ListApearOnlyWords
import sys
try:
    with open("BASIC/paper.txt",'r',encoding="utf8") as f:
        text = f.readlines()
except IOError:
    sys.exit('ERROR: Failed to load input file ' )

print("Num of Sentences : ",CountNumOfSentences(text))
print("------------------")
print("Num of Words : ", CountNumOfWords(text))
print("------------------")
FrequencyOfWords(text)
print("------------------")
ListApearOnlyWords(text)

