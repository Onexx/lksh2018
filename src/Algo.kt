import java.util.*

val scan = java.util.Scanner(System.`in`)

fun min(a: Int, b: Int): Int{
    if(a < b){
        return a
    }
    else{
        return b
    }
}

fun search(index: String, value:String, memory: Deque<Pair<String, String>>){
    for(i in memory){
        var t: Int = min(i.first.length, index.length)
        for(j in i.first.chars()){

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
        }
        if(inp == "Delete" || inp == "delete"){
            var index: String = scan.next()
            var value: String = scan.next()
            for(i in memory){
                if(i.first == index || i.second == value){
                    println("Deleting value ${i.second} with index ${i.first}")
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