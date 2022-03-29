package filesystem;

public interface FileSystemNode {

    void setParent(FileSystemNode systemNode);

    FileSystemNode getParent();

    String getName();

    String getPath();

}
