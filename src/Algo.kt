import java.util.*

val scan = java.util.Scanner(System.`in`)

fun main(args: Array<String>){
    var inp = ""
    var memory: Deque<Pair<String, String>>  = ArrayDeque<Pair<String, String> >()
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
        inp = scan.next()
    }
}