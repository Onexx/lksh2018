/*
* File made for storing commands. Store your functions here.
* */
import java.util.*
import kotlin.math.min

var OnPage: Int = 5 // Number of results displayed on one page

fun add(memory: Vector<Pair<String, String>>){
    val index: String = scan.next()
    val value: String = scan.next()
    memory.add(Pair(index, value))
    println("Completed")
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
    println("Pick an option below to delete it")
    for(i in 0 until result.size){
        println("${i + 1} : ${memory[result[i]].first} - ${memory[result[i]].second}")
    }
    println("c : Cancel")
    var p: Int?
    while(true) {
        val t: String = scan.next()
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

fun search(memory: Vector<Pair<String, String>>){
    if(memory.size == 0){
        println("Memory is clear")
        return
    }
    val result = Vector<Pair<String, String>>()
    val index: String = scan.next()
    val value: String = scan.next()
    val used = Vector<Int>()
    for(i in 0 until memory.size){
        var pos = 0
        for(j in 0 until memory[i].first.length){
            if(index[pos] == memory[i].first[j]){
                pos++
            }
            else{
                pos = 0
            }
            if(pos == index.length){
                result.add(memory[i])
                used.add(i)
                break
            }
        }
        pos = 0
        for(j in 0 until memory[i].second.length){
            if(value[pos] == memory[i].second[j]){
                pos++
            }
            else{
                pos = 0
            }
            if(pos == value.length) {
                var key = true
                for (l in 0 until used.size){
                    if(i == used[l]){
                        key = false
                    }
                }
                if(key) {
                    result.add(memory[i])
                }
                break
            }
        }
    }
    if(result.size == 0){
        println("Nothing found")
    }
    else{
        println("${result.size} match(es) found:")
        if(result.size > OnPage) {
            var p = 0
            var inp = ""
            while (inp != "f" || inp != "finish") {
                println("[Page ${(p + 1) / OnPage + 1}]")
                for (i in p until min(result.size, p + OnPage)) {
                    println("${result[i].first} - ${result[i].second}")
                }
                println("Write 'finish' to finish the search")
                inp = scan.next()
                inp = inp.toLowerCase()
                if (inp == "f" || inp == "fin" || inp == "finish") {
                    println("Finished")
                    break
                }
                if (inp == "<") {
                    if (p - OnPage < 0) {
                        println("Can't switch page")
                        continue
                    }
                    p -= OnPage
                }
                if (inp == ">") {
                    if (p + OnPage >= result.size) {
                        println("Can't switch page")
                        continue
                    }
                    p += OnPage
                }
                println("Incorrect input")
            }
        }
        else{
            println("[Page 1]")
            for (i in 0 until result.size) {
                println("${result[i].first} - ${result[i].second}")
            }
        }
    }
}

fun show(memory: Vector<Pair<String, String>>){
    if(memory.size == 0){
        println("Memory is clear")
    }
    else{
        println("Memory contains ${memory.size} pair(s):")
        var p = 0
        var inp = ""
        if(memory.size > OnPage) {
            while (inp != "f" || inp != "finish") {
                println("[Page ${(p + 1) / OnPage + 1}]")
                for (i in p until min(memory.size, p + OnPage)) {
                    println("${memory[i].first} - ${memory[i].second}")
                }
                println("Write 'finish' to finish showing")
                inp = scan.next()
                inp = inp.toLowerCase()
                if (inp == "f" || inp == "fin" || inp == "finish") {
                    println("Finished")
                    break
                }
                if (inp == "<") {
                    if (p - OnPage < 0) {
                        println("Can't switch page")
                        continue
                    }
                    p -= OnPage
                }
                if (inp == ">") {
                    if (p + OnPage >= memory.size) {
                        println("Can't switch page")
                        continue
                    }
                    p += OnPage
                }
                println("Incorrect input")
            }
        }
        else{
            println("[Page 1]")
            for (i in 0 until memory.size) {
                println("${memory[i].first} - ${memory[i].second}")
            }
        }
    }
}