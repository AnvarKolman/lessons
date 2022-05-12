package filesystem

fun main() {
    val txtFile = File("one", ".txt")
    val docFile = File("two", ".doc")
    val file = File("file", ".file")
    val xmlFile = File("xmlFile", ".xml")
    val pdfFile = File("pdfFile", ".pdf")

    val emptyFolder = Folder("emptyFolder")
    val parent = Folder("parentFolder", txtFile, emptyFolder, docFile, file, xmlFile, pdfFile)

    println("File path = ${txtFile.path()}")

    val nFile = fileForIndex(parent, 3)
    println(if (nFile == null) "File not exist" else "Extension = " + nFile.extension)
    val notEx = fileForIndex(parent, 10)
    println(if (notEx == null) "File not exist" else "Extension = " + notEx.extension)
}

fun fileForIndex(folder: Folder, index: Int): File? {
    if (folder.childs.size < index) return null
    println("N = $index");
    return folder.childs.filterIsInstance<File>()[index - 1]
}