import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

fun main(args: Array<String>) = runBlocking {
    //supervisorScope {
        launch(SupervisorJob() + CoroutineExceptionHandler { _: CoroutineContext, _: Throwable -> }) {
            launch {
                println("#5")
                delay(1000)
                println("#6")
            }
            launch {
                println("#7")
                delay(1000)
                throw Exception()
                println("#8")
            }
        }
        println("#2")
        delay(2000)
        //cancel()
        println("#3")
        println("#4")
    //}
}


