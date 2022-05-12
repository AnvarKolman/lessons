package filesystem

class Folder(name: String, vararg childNodes: FileSystemNode) : AbstractFileSystemNode(name) {

    var childs: List<FileSystemNode?> = childNodes.asList().onEach {
        it.parent = this@Folder
    }

}