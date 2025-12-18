package classes.classesObjs

// an class can only get one abstract class, but can get many interfaces


data class Document(val text: String)

interface Printer {
    fun print(text: String): Document

    val printerName: String
}

interface TextConverter {

    val language: String
        get() = "English"

    fun convert(text: String, printerName: String): String {
        return if(text.isEmpty()) language else "Converted $text on $printerName"
    }
}

class HP : Printer, TextConverter {

    override val printerName: String = "HP"

    override fun print(text: String): Document {
        convert(text, printerName)
        println("Printing $text on $printerName")
        return Document(text)
    }

    override fun convert(text: String, printerName: String): String {
        return "Converted $text on $printerName"
    }
}

class WordPrinter : Printer, TextConverter {

    override val printerName: String = "WordPrinter"

    override fun print(text: String): Document {
        convert(text, printerName)
        println("Printing WORD REPS $text on $printerName")
        return Document(text)
    }

    override fun convert(text: String, printerName: String): String {
        return "Converted a WORD REPS $text on $printerName"
    }
}

fun main() {

    val hp = HP()
    hp.print("Hello World")

    val doc: Document = hp.print("Hello World")
    println(doc.text)

    val wordPrinter = WordPrinter()
    wordPrinter.print("Hello World")

    val doc2: Document = wordPrinter.print("Hello World")
    println(doc2.text)
}