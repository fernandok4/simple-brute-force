package br.com.kanasha

var letterQtty = 1
var tryes = 0
val letters = "fernadok4".toCharArray().toTypedArray()
var possibilities = calculatePossibilities(letterQtty, letters)

fun main() {
    var success = false
    while(!success){
        val password = generatePassword(letterQtty, letters)
        val commands = listOf("script/trySudo.sh", password)
        val process = ProcessBuilder().command(commands).start()
        process.inputStream.use {
            it.bufferedReader().use { buffer ->
                val text: String? = buffer.readLine()
                if(text != null){
                    println("Senha é: $password")
                    success = true
                }
            }
        }
    }
}

fun generatePassword(qttyLetter: Int, letters: Array<Char>): String {
    var password = ""
    return password
}

fun calculatePossibilities(qttyLetter: Int, letters: Array<Char>): Int {
    return fatorial(letters.size, qttyLetter)
}

fun fatorial(size: Int, fatNum: Int): Int {
    if(fatNum == 0 || size == 0){
        return 1
    }
    return fatNum * fatorial(fatNum - 1, size - 1)
}