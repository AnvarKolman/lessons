package filesystem

abstract class AbstractFileSystemNode(
    override var nodeName: String = ""
) : FileSystemNode {

    final override var parent: FileSystemNode? = null

    final override fun path(): String {
        return if (parent == null) "/$nodeName" else parent!!.path() + "/$nodeName"
    }

}