import java.util.*

val scan = java.util.Scanner(System.`in`)

fun search(memory: Vector<Pair<String, String>>){
    if(memory.size == 0){
        println("Memory is clear")
        return
    }
    val result = Vector<Pair<String, String>>()
    val index: String = scan.next()
    val value: String = scan.next()
    for(i in memory){
        //print(value)
        var pos = 0
        for(j in 0 until i.first.length){
            if(index[pos] == i.first[j]){
                pos++
            }
            else{
                pos = 0
            }
            if(pos == index.length){
                result.add(i)
                break
            }
        }
        pos = 0
        for(j in 0 until i.second.length){
            if(value[pos] == i.second[j]){
                pos++
            }
            else{
                pos = 0
            }
            if(pos == index.length){
                result.add(i)
                break
            }
        }
    }
    if(result.size == 0){
        println("Nothing found")
    }
    else{
        println("${result.size} match(es) found:")
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
            if(memory[i].first == index && memory[i].second == value){
                println("Deleting pair ${memory[i].first} - ${memory[i].second}")
                memory.remove(Pair(memory[i].first, memory[i].second))
                return
            }
            result.add(i)
        }
    }
    if(result.size == 0){
        println("Nothing found")
        return
    }
    if(result.size == 1){
        println("Deleting pair ${memory[result[0]].first} - ${memory[result[0]].second}")
        memory.remove(Pair(memory[result[0]].first, memory[result[0]].second))
        return
    }
    //println("Write number of pair which you want to delete")
    println("Pick an option below to delete it")
    for(i in 0 until result.size){
        println("${i + 1} : ${memory[result[i]].first} - ${memory[result[i]].second}")
    }
    println("c : Cancel")
    var p: Int?
    while(true) {
        var t: String = scan.next()
        if(t == "C" || t == "c"){
            println("Cancelled")
            return
        }
        p = t.toIntOrNull()
        if(p != null){
            if(p <= result.size && p > 0){
                break
            }
            println("Incorrect input")
        }
        else{
            println("Incorrect input")
        }
    }
    println("Deleting pair ${memory[result[p!!-1]].first} - ${memory[result[p-1]].second}")
    memory.remove(Pair(memory[result[p-1]].first, memory[result[p-1]].second))
}

fun main(args: Array<String>){
    var inp = ""
    val memory = Vector<Pair<String, String> >()
    println("Write 'help' for help")
    while(inp != "exit"){
        if(inp == "add"){
            val index: String = scan.next()
            val value: String = scan.next()
            memory.add(Pair(index, value))
            println("Completed")
        }
        if(inp == "delete"){
            delete(memory)
        }
        if(inp == "find"){
            search(memory)
        }
        if(inp == "help"){
            println("help option")
        }
        inp = scan.next()
        inp = inp.toLowerCase()
    }
}