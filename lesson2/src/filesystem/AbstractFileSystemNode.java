package filesystem;

import java.util.Objects;

public abstract class AbstractFileSystemNode implements FileSystemNode {

    protected FileSystemNode parent;
    protected String name;

    protected AbstractFileSystemNode(String name) {
        this.name = Objects.requireNonNull(name, "Name is null");
    }

    @Override
    public final void setParent(FileSystemNode parent) {
        this.parent = parent;
    }

    @Override
    public final FileSystemNode getParent() {
        return parent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public final String getPath() {
        return getParent() == null ? "/" + getName() : getParent().getPath() + "/" + getName();
    }
}
