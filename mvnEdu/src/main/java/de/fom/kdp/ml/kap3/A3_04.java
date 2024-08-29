package de.fom.kdp.ml.kap3;

public class A3_04 {

    public static void main(String[] args) {
        // Example full path
        String fullPath = "C:\\Eigene Dateien\\Javatest\\Beispiel.java";

        // Extracting the directory
        String directory = fullPath.substring(0, fullPath.lastIndexOf("\\"));

        // Extracting the filename without extension
        String fileNameWithExtension = fullPath.substring(fullPath.lastIndexOf("\\") + 1);
        String fileName = fileNameWithExtension.substring(0, fileNameWithExtension.lastIndexOf("."));

        // Extracting the extension
        String extension = fileNameWithExtension.substring(fileNameWithExtension.lastIndexOf(".") + 1);

        // Output the results
        System.out.println("Extension:\t" + extension);
        System.out.println("Dateiname:\t" + fileName);
        System.out.println("Verzeichnis:\t" + directory);
    }
}
