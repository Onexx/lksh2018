/*
* File only for main function. Please keep it clean. Use other files for storing functions.
* */

import java.util.*

val scan = java.util.Scanner(System.`in`)

fun main(args: Array<String>){
    var inp: String
    val memory = Vector<Pair<String, String> >()
    println("Write 'help' for help")
    println("To exit from the program type 'exit'")
    while(true){
        inp = scan.next()
        inp = inp.toLowerCase()
        if(inp == "add"){
            add(memory) // Simply adds in memory pair of index and value (stores in Functions.kt)
            continue
        }
        if(inp == "delete"){
            delete(memory) // Deletes pair using index and/or value (stores in Functions.kt)
            continue
        }
        if(inp == "search"){
            search(memory) // Searching for pair in memory using written parts of index and value (stores in Functions.kt)
            continue
        }
        if(inp == "help"){
            helpMain() //Help function in HelpMessages.kt file. Shows help about current commands.
            continue
        }
        if(inp == "show"){
            show(memory)
            continue
        }
        if(inp == "exit"){
            println("Closing")
            break
        }
        println("Incorrect input")
    }
}