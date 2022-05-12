package filesystem

interface FileSystemNode {

    var nodeName: String

    var parent: FileSystemNode?

    fun path(): String

}