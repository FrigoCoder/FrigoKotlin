package frigo.delegates

import kotlin.properties.Delegates

class ObservableUser {
    var name: String by Delegates.observable("no name") { _, old, new ->
        println("$old -> $new")
    }
}

fun main(args: Array<String>) {
    val user = ObservableUser()
    user.name = "Carl"
}
