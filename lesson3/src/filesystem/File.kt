package filesystem

data class File(
    var name: String,
    var extension: String
) : AbstractFileSystemNode(name)