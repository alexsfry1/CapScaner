import os

def openfile(doc):
    with open (doc , 'r', encoding='utf-16') as file:
        for i in file:
            if "Заглушка" in i:
                print("Заглушка" + " " + i + " " + doc)


def foldersearch(folder):
    fold = os.listdir(folder)
    for string in fold:
         path = str(folder + '/' + string)
         if(os.path.isdir(path)):
            foldersearch(path)
         elif(('txt' in path) and ('xdb' not in path) and ('Tests' not in path)):
             openfile(path)


a = input()
foldersearch(a)

