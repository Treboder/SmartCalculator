package calculator

import java.util.*

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val app = Application()
        app.menu()
    }
}

internal class Application {
    private val calculator: Calculator
    fun menu() {
        val sc = Scanner(System.`in`)
        while (true) {
            val line = sc.nextLine().trim { it <= ' ' }.replace("\\s+".toRegex(), " ")
            if (line.isBlank()) {
                continue
            }
            if (ACTION_EXIT == line) {
                break
            }
            if (ACTION_HELP == line) {
                printHelp()
                continue
            }
            if (line[0] == '/') {
                println(Validation.ERR_UNKNOWN_COMMAND)
                continue
            }
            if (line.contains("=")) {
                calculator.doAssignment(line)
                continue
            }
            if (calculator.setExpression(line)) {
                println(calculator.calculate())
            }
        }
        println("Bye!")
        sc.close()
    }

    fun printHelp() {
        println("The program calculates the sum and difference of numbers.")
    }

    companion object {
        private const val ACTION_EXIT = "/exit"
        private const val ACTION_HELP = "/help"
    }

    init {
        calculator = PostfixCalculator()
    }
}