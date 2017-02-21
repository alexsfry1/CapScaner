import codecs

def openfile(a):
    with open (a , 'r', encoding='utf-16') as file:
        f = file
        for i in f:
            if "Заглушка" in i:
                print("Заглушка" + " " + a)



a = input()
openfile(a)