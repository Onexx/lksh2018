/*
* File made for storing help messages. You may add help about your commands in this file.
* */
fun helpMain(){
    println("Program have 4 commands:\n" +
            "'add'\n" +
            "'delete'\n" +
            "'search'\n" +
            "'show'\n" +
            "type name of command to get info about it or 'c' to cancel")
    var inp: String
    while(true) {
        inp = scan.next()
        inp = inp.toLowerCase()
        if (inp == "c") {
            println("Cancelled")
            println("type 'help' for help")
            return
        }
        if (inp == "add") {
            helpAdd()
            println("Type 'help' for help")
            break
        }
        if (inp == "delete") {
            helpDelete()
            println("Type 'help' for help")
            break
        }
        if (inp == "search") {
            helpSearch()
            println("Type 'help' for help")
            break
        }
        if (inp == "show") {
            helpShow()
            println("Type 'help' for help")
            break
        }
        println("Incorrect input")
    }
}
fun helpAdd(){
    println("['Add' help]")
    println("Function 'add' adds in memory pair of <index> and <value>\n" +
            "To use it type 'add' and pair of <index> and <value> separated by space")
}

fun helpDelete(){
    println("['Delete' help]")
    println("Function 'delete' deletes from memory pair with written <index> and/or <value>\n" +
            "To use it type 'delete' and pair of <index> and <value>\n" +
            "If you don't want to search by <index> or by <value>, just fill it with any symbols that haven't yet been added to memory\n" +
            "If several results are found the choice will be offered\n" +
            "To select an option just type it's number or type 'c' to cancel")
}
fun helpSearch(){
    println("['Search' help]")
    println("Function 'search' searches for pair in memory, which includes part of the entered <index> and <value>\n" +
            "To use it type 'search' and part of <index> and <value>\n" +
            "If you don't want to search by <index> or by <value>, just fill it with any symbols that haven't yet been added to memory\n" +
            "Search results shown by pages, that can be switched by '<' and '>' commands\n" +
            "To exit the results view, type 'finish' command or it's shorter form 'fin' or 'f'")
}
fun helpShow(){
    println("['Show' help]")
    println("Function 'show' prints all pairs that are now in memory\n" +
            "To use it just type word 'show'\n" +
            "Pairs are showing by pages, that can be switched using '<' and '>' commands\n" +
            "To exit the view mode, type 'finish' command or it's  shorter form 'fin' or 'f'")
}