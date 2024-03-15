str = input()
if (str[0] != '"' or str[-1] != '"'): print("CE")
else: 
    str = str[1:len(str)-1]
    if (len(str.strip(" ")) == 0): print("CE")
    else: print(str)