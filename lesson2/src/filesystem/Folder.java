package filesystem;

public class Folder extends AbstractFileSystemNode{

    private FileSystemNode[] childNodes;

    public Folder(String name, FileSystemNode... childNodes) {
        super(name);
        this.childNodes = childNodes;
        for (FileSystemNode child : this.childNodes) {
            child.setParent(this);
        }
    }

    public FileSystemNode[] getChilds() {
        return childNodes;
    }

}
