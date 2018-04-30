import java.util.*

val scan = java.util.Scanner(System.`in`)

fun search(memory: Vector<Pair<String, String>>){
    val result = Vector<Pair<String, String>>()
    for(i in memory){
        val index: String = scan.next()
        val value: String = scan.next()
        print(value)
        var pos = 0
        for(j in i.first.chars()){
            if(index[pos] == i.first[j]){
                pos++
            }
            else{
                pos = 0
            }
            if(pos == index.length - 1){
                result.add(i)
            }
        }
    }
    if(result.size == 0){
        println("Nothing found")
    }
    else{
        println("${result.size} matches found:")
        for(i in result){
            println("${i.first} - ${i.second}")
        }
    }
}

fun delete(memory: Vector<Pair<String, String>>){
    val index: String = scan.next()
    val value: String = scan.next()
    val result: Vector<Int> = Vector()
    for(i in 0 until memory.size){
        if(memory[i].first == index || memory[i].second == value){
            result.add(i)
        }
    }
    when (result.size){
        0 -> println("Nothing found")
        1 -> { println("Deleting pair ${memory[result[0]].first} - ${memory[result[0]].second}")
            memory.remove(Pair(memory[result[0]].first, memory[result[0]].second)) }
        else -> {
            println("Write number of pair, which you want to delete")
            for(i in 0 until result.size){
                println("${i + 1}) ${memory[result[i]].first} - ${memory[result[i]].second}")
            }
            var p = scan.nextInt()
            while(p > result.size || p <= 0) {
                println("Incorrect input")
                p = scan.nextInt()
            }
            println("Deleting pair ${memory[result[p-1]].first} - ${memory[result[p-1]].second}")
            memory.remove(Pair(memory[result[p-1]].first, memory[result[p-1]].second))
        }
    }
}

fun main(args: Array<String>){
    var inp = ""
    val memory = Vector<Pair<String, String> >()
    println("Write 'help' for help")
    while(inp != "Exit" || inp != "exit"){
        if(inp == "Add" || inp == "add"){
            val index: String = scan.next()
            val value: String = scan.next()
            memory.add(Pair(index, value))
            println("Completed")
        }
        if(inp == "Delete" || inp == "delete"){
            delete(memory)
        }
        if(inp == "Find" || inp == "find"){
            search(memory)
        }
        if(inp == "Help" || inp == "help"){
            println("help option")
        }
        inp = scan.next()
    }
}