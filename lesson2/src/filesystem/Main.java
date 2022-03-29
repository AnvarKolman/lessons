package filesystem;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        File txtFile = new File("one", ".txt");
        File docFile = new File("two", ".doc");
        File file = new File("file", ".file");
        File xmlFile = new File("xmlFile", ".xml");
        File pdfFile = new File("pdfFile", ".pdf");

        Folder emptyFolder = new Folder("emptyFolder");
        Folder parent = new Folder("parentFolder", txtFile, emptyFolder, docFile, file, xmlFile, pdfFile);

        System.out.println("File path = " + txtFile.getPath());

        File nFile = getFile(parent, 3);
        System.out.println(nFile == null ? "File not exist" : "Extension = " + nFile.getExtension());
        File notEx = getFile(parent, 10);
        System.out.println(notEx == null ? "File not exist" : "Extension = " + notEx.getExtension());
    }

    private static File getFile(Folder folder, long n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N <= 0");
        }
        System.out.println("N = " + n);
        return Stream.of(folder.getChilds())
                .filter(File.class::isInstance)
                .map(File.class::cast)
                .skip(n - 1).findFirst()
                .orElse(null);
    }
}
