import glob

def openfile(doc):
    try:
        with open (doc , 'r', encoding='utf-16') as file:
         for i in file:
                if "Заглушка" in i:
                    print("Заглушка" + " " + i + " " + doc)
    except:
        UnicodeError


def foldersearch(folder):
    fold = glob.iglob(str.format(folder + '\**\*.txt'), recursive=True)
    for string in fold:
        if("Test" not in string):
            openfile(string)

a = input()
foldersearch(a)

