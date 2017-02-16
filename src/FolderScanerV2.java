import java.io.*;
import java.util.Scanner;

public class FolderScanerV2 {

    public static void FolderScaner(File file) {
        try {
        if (file.isDirectory()) {
            File[] directory = file.listFiles();
            for (File enter : directory) {
                if ((enter.isFile() && enter.getCanonicalPath().contains("txt"))) {
                    FileScaner(enter);
                } else {
                    if(!enter.getCanonicalPath().contains("Test") || !enter.getCanonicalPath().contains("Video" ) || !enter.getCanonicalPath().contains(".svn" ))
                    FolderScaner(enter);
                }
            }
        }
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Не могу открыть папку");
        }
    }

    public static void FileScaner(File file) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()), "UTF-16"));
            Scanner text = new Scanner(in);
            while (text.hasNext()) {
                String line = text.next();
                if (line.contains("Заглушка")) {
                    System.out.println("Заглушка" + " " + line + " " + file.getCanonicalPath());
                }
            }
            text.close();
            in.close();
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Не могу открыть файл");
        }
    }

    public static void main(String[] args) {
        Scanner inpunt = new Scanner(System.in);
        System.out.println("Введи путь к файлу или папке");
        String path = inpunt.nextLine();
        try {
            FolderScaner(new File(path));
            inpunt.close();
        } catch (RuntimeException e ) {
            e.printStackTrace();
        }
    }
}