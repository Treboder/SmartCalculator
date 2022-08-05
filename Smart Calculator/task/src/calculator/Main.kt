package calculator

fun main() {

    while(true) {

        var inputRaw = readLine()!!
        if(inputRaw == "/exit")
            break
        else if (inputRaw == "/help")
            println("The program calculates the sum of numbers")

        var inputSplitted = inputRaw.split(" ")
        if(inputSplitted.count() == 1) {
            if(inputSplitted.first().isNotEmpty() && !inputSplitted.first().isBlank())
                println(inputSplitted.first())
        }
        else
        {
            var sum = 0
            for(value in inputSplitted)
                if(value.isNotEmpty() && !value.isBlank())
                    sum += value.toInt()
            println(sum)
        }

    }
    println("Bye!")

}
