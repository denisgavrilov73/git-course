import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun main(args: Array<String>) {
    while (true) {
        try {
            println("Пожалуйста, введите уравнение (без пробелов), например, 1.21+1.\nПоддерживаемые операции +, -, /,*, %.\nДля завершения программы введите [N]")
            val input = readLine() ?: break
            if (input.uppercase() == "N") {
                break
            }
            val changeOp = input.replace(Regex("[+%,/*-]")) {
                when (it.value) {
                    "+" -> " + "
                    "-" -> " - "
                    "*" -> " * "
                    "/" -> " / "
                    "%" -> " % "
                    "," -> "."
                    else -> it.value
                }
            }
            val userInput =  changeOp.trim().split(" ")
            val num1 = userInput[0].toDouble()
            val op = userInput[1]
            val num2 = userInput[2].toDouble()
            val result = when (op) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> if (num2 != 0.0) num1 / num2 else  "На ноль делить нельзя"
                "%" -> (num1 * num2) / 100
                else -> "Неизвестная операция"
            }
            val df = DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH))
            df.maximumFractionDigits = 340

            println(df.format(result))

        }catch (e: Exception) {
            println("Проверьте правильность ввода:")
        }

    }

}
