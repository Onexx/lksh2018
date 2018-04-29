import java.util.*

val scan = java.util.Scanner(System.`in`)

fun search(index: String, value:String, memory: Deque<Pair<String, String>>){
    var result = ArrayDeque<Pair<String, String>>()
    for(i in memory){
        //var t: Int = min(i.first.length, index.length)
        var pos = 0
        for(j in i.first.chars()){
            if(index[pos] == i.first[j]){
                pos++
            }
            else{
                pos = 0
            }
            if(pos == index.length - 1){
                result.addLast(i)
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

fun delete(index: String, value:String, memory: Deque<Pair<String, String>>){
    for(i in memory){
        if(i.first == index || i.second == value){
            println("Deleting pair ${i.first} - ${i.second}")
            memory.remove(Pair(i.first, i.second))
        }
    }
}

fun main(args: Array<String>){
    var inp = ""
    var memory: Deque<Pair<String,String>>  = ArrayDeque<Pair<String, String> >()
    println("Add instructions")
    while(inp != "Exit" || inp != "exit"){
        if(inp == "Add" || inp == "add"){
            val index: String = scan.next()
            var value: String = scan.next()
            memory.addLast(Pair(index, value))
            println("Completed")
        }
        if(inp == "Delete" || inp == "delete"){
            var index: String = scan.next()
            var value: String = scan.next()
            for(i in memory){
                if(i.first == index || i.second == value){
                    println("Deleting pair ${i.first} - ${i.second}")
                    memory.remove(Pair(i.first, i.second))
                }
            }
        }
        if(inp == "Find" || inp == "find"){
            var index: String = scan.next()
            var value: String = scan.next()
            search(index, value, memory)
        }
        inp = scan.next()
    }
}