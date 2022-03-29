package filesystem;

public class File extends AbstractFileSystemNode {

    private String extension;

    public File(String name, String extension) {
        super(name);
        this.extension = extension;
    }

    @Override
    public String getName() {
        return name + extension;
    }

    public String getExtension() {
        return extension;
    }
}
