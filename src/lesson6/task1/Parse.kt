@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson6.task1

// Урок 6: разбор строк, исключения
// Максимальное количество баллов = 13
// Рекомендуемое количество баллов = 11
// Вместе с предыдущими уроками (пять лучших, 2-6) = 40/54

/**
 * Пример
 *
 * Время представлено строкой вида "11:34:45", содержащей часы, минуты и секунды, разделённые двоеточием.
 * Разобрать эту строку и рассчитать количество секунд, прошедшее с начала дня.
 */
fun timeStrToSeconds(str: String): Int {
    val parts = str.split(":")
    var result = 0
    for (part in parts) {
        val number = part.toInt()
        result = result * 60 + number
    }
    return result
}

/**
 * Пример
 *
 * Дано число n от 0 до 99.
 * Вернуть его же в виде двухсимвольной строки, от "00" до "99"
 */
fun twoDigitStr(n: Int) = if (n in 0..9) "0$n" else "$n"

/**
 * Пример
 *
 * Дано seconds -- время в секундах, прошедшее с начала дня.
 * Вернуть текущее время в виде строки в формате "ЧЧ:ММ:СС".
 */
fun timeSecondsToStr(seconds: Int): String {
    val hour = seconds / 3600
    val minute = (seconds % 3600) / 60
    val second = seconds % 60
    return String.format("%02d:%02d:%02d", hour, minute, second)
}

/**
 * Пример: консольный ввод
 */
fun main() {
    println("Введите время в формате ЧЧ:ММ:СС")
    val line = readLine()
    if (line != null) {
        val seconds = timeStrToSeconds(line)
        if (seconds == -1) {
            println("Введённая строка $line не соответствует формату ЧЧ:ММ:СС")
        } else {
            println("Прошло секунд с начала суток: $seconds")
        }
    } else {
        println("Достигнут <конец файла> в процессе чтения строки. Программа прервана")
    }
}


/**
 * Средняя (4 балла)
 *
 * Дата представлена строкой вида "15 июля 2016".
 * Перевести её в цифровой формат "15.07.2016".
 * День и месяц всегда представлять двумя цифрами, например: 03.04.2011.
 * При неверном формате входной строки вернуть пустую строку.
 *
 * Обратите внимание: некорректная с точки зрения календаря дата (например, 30.02.2009) считается неверными
 * входными данными.
 */
fun dateStrToDigit(str: String): String {
    val parts = str.split(" ")
    val months = mutableMapOf<String, String>(
        "января" to "01",
        "февраля" to "02",
        "марта" to "03",
        "апреля" to "04",
        "мая" to "05",
        "июня" to "06",
        "июля" to "07",
        "августа" to "08",
        "сентября" to "09",
        "октября" to "10",
        "ноября" to "11",
        "декабря" to "12"
    )
    var digitDate = ""
    if (parts[1] == "января" && parts.size == 3) {
        if (parts[0].toInt() in 10..31) digitDate = parts[0] + months["января"] + parts[2]
        if (parts[0].toInt() < 10) digitDate = parts[0][1].toString() + months["января"] + parts[2]
    }
    if (parts[1] == "февраля" && parts.size == 3) {
        if (parts[0].toInt() in 10..28) digitDate = parts[0] + months["февраля"] + parts[2]
        if (parts[0].toInt() < 10) digitDate = parts[0][1].toString() + months["февраля"] + parts[2]
    }
    if (parts[1] == "марта" && parts.size == 3) {
        if (parts[0].toInt() in 10..31) digitDate = parts[0] + months["марта"] + parts[2]
        if (parts[0].toInt() < 10) digitDate = parts[0][1].toString() + months["марта"] + parts[2]
    }
    if (parts[1] == "апреля" && parts.size == 3) {
        if (parts[0].toInt() in 10..30) digitDate = parts[0] + months["апреля"] + parts[2]
        if (parts[0].toInt() < 10) digitDate = parts[0][1].toString() + months["апреля"] + parts[2]
    }
    if (parts[1] == "мая" && parts.size == 3) {
        if (parts[0].toInt() in 10..31) digitDate = parts[0] + months["мая"] + parts[2]
        if (parts[0].toInt() < 10) digitDate = parts[0][1].toString() + months["мая"] + parts[2]
    }
    if (parts[1] == "июня" && parts.size == 3) {
        if (parts[0].toInt() in 10..30) digitDate = parts[0] + months["июня"] + parts[2]
        if (parts[0].toInt() < 10) digitDate = parts[0][1].toString() + months["июня"] + parts[2]
    }
    if (parts[1] == "июля" && parts.size == 3) {
        if (parts[0].toInt() in 10..31) digitDate = parts[0] + "." + months["июля"] + "." + parts[2]
        if (parts[0].toInt() < 10) digitDate = parts[0][1].toString() + "." + months["июля"] + "." + parts[2]
    }
    if (parts[1] == "августа" && parts.size == 3) {
        if (parts[0].toInt() in 10..31) digitDate = parts[0] + months["августа"] + parts[2]
        if (parts[0].toInt() < 10) digitDate = parts[0][1].toString() + months["августа"] + parts[2]
    }
    if (parts[1] == "сентября" && parts.size == 3) {
        if (parts[0].toInt() in 10..30) digitDate = parts[0] + months["сентября"] + parts[2]
        if (parts[0].toInt() < 10) digitDate = parts[0][1].toString() + months["сентября"] + parts[2]
    }
    if (parts[1] == "октября" && parts.size == 3) {
        if (parts[0].toInt() in 10..31) digitDate = parts[0] + months["октября"] + parts[2]
        if (parts[0].toInt() < 10) digitDate = parts[0][1].toString() + months["октября"] + parts[2]
    }
    if (parts[1] == "ноября" && parts.size == 3) {
        if (parts[0].toInt() in 10..30) digitDate = parts[0] + "." + months["ноября"] + "." + parts[2]
        if (parts[0].toInt() < 10) digitDate = parts[0][1].toString() + "." + months["ноября"] + "." + parts[2]
    }
    if (parts[1] == "декабря" && parts.size == 3) {
        if (parts[0].toInt() in 10..31) digitDate = parts[0] + months["декабря"] + parts[2]
        if (parts[0].toInt() < 10) digitDate = parts[0][1].toString() + months["декабря"] + parts[2]
    }
    return digitDate
}

/**
 * Средняя (4 балла)
 *
 * Дата представлена строкой вида "15.07.2016".
 * Перевести её в строковый формат вида "15 июля 2016".
 * При неверном формате входной строки вернуть пустую строку
 *
 * Обратите внимание: некорректная с точки зрения календаря дата (например, 30 февраля 2009) считается неверными
 * входными данными.
 */
fun dateDigitToStr(digital: String): String {
    val parts = digital.split(".")
    var dateStr = ""
    val months = mutableMapOf<String, String>(
        "01" to " января ",
        "02" to " февраля ",
        "03" to " марта ",
        "04" to " апреля ",
        "05" to " мая ",
        "06" to " июня",
        "07" to " июля ",
        "08" to " августа ",
        "09" to " сентября ",
        "10" to " октября ",
        "11" to " ноября ",
        "12" to " декабря "
    )
    if (parts[1] == "01" && parts.size == 3) {
        if (parts[0].toInt() in 10..31) dateStr = parts[0] + months["01"] + parts[2]
        if (parts[0].toInt() < 10) dateStr = parts[0][1].toString() + months["01"] + parts[2]
    }
    if (parts[1] == "02" && parts.size == 3) {
        if (parts[0].toInt() in 10..28) dateStr = parts[0] + months["02"] + parts[2]
        if (parts[0].toInt() < 10) dateStr = parts[0][1].toString() + months["02"] + parts[2]
    }
    if (parts[1] == "03" && parts.size == 3) {
        if (parts[0].toInt() in 10..31) dateStr = parts[0] + months["03"] + parts[2]
        if (parts[0].toInt() < 10) dateStr = parts[0][1].toString() + months["03"] + parts[2]
    }
    if (parts[1] == "04" && parts.size == 3) {
        if (parts[0].toInt() in 10..30) dateStr = parts[0] + months["04"] + parts[2]
        if (parts[0].toInt() < 10) dateStr = parts[0][1].toString() + months["04"] + parts[2]
    }
    if (parts[1] == "05" && parts.size == 3) {
        if (parts[0].toInt() in 10..31) dateStr = parts[0] + months["05"] + parts[2]
        if (parts[0].toInt() < 10) dateStr = parts[0][1].toString() + months["05"] + parts[2]
    }
    if (parts[1] == "06" && parts.size == 3) {
        if (parts[0].toInt() in 10..30) dateStr = parts[0] + months["06"] + parts[2]
        if (parts[0].toInt() < 10) dateStr = parts[0][1].toString() + months["06"] + parts[2]
    }
    if (parts[1] == "07" && parts.size == 3) {
        if (parts[0].toInt() in 10..31) dateStr = parts[0] + months["07"] + parts[2]
        if (parts[0].toInt() < 10) dateStr = parts[0][1].toString() + months["07"] + parts[2]
    }
    if (parts[1] == "08" && parts.size == 3) {
        if (parts[0].toInt() in 10..31) dateStr = parts[0] + months["08"] + parts[2]
        if (parts[0].toInt() < 10) dateStr = parts[0][1].toString() + months["08"] + parts[2]
    }
    if (parts[1] == "09" && parts.size == 3) {
        if (parts[0].toInt() in 10..30) dateStr = parts[0] + months["09"] + parts[2]
        if (parts[0].toInt() < 10) dateStr = parts[0][1].toString() + months["09"] + parts[2]
    }
    if (parts[1] == "10" && parts.size == 3) {
        if (parts[0].toInt() in 10..31) dateStr = parts[0] + months["10"] + parts[2]
        if (parts[0].toInt() < 10) dateStr = parts[0][1].toString() + months["10"] + parts[2]
    }
    if (parts[1] == "11" && parts.size == 3) {
        if (parts[0].toInt() in 10..30) dateStr = parts[0] + months["11"] + parts[2]
        if (parts[0].toInt() < 10) dateStr = parts[0][1].toString() + months["11"] + parts[2]
    }
    if (parts[1] == "12" && parts.size == 3) {
        if (parts[0].toInt() in 10..31) dateStr = parts[0] + months["12"] + parts[2]
        if (parts[0].toInt() < 10) dateStr = parts[0][1].toString() + months["12"] + parts[2]
    }
    return dateStr
}
// я пробовал сделать так, чтобы в мапе в значении была пара <название месяца, макс.кол-во дней> и с помощью цикла
// проверять количесво дней в данном месяце, но у меня не получилось, как и в прошлой задаче
/**
 * Средняя (4 балла)
 *
 * Номер телефона задан строкой вида "+7 (921) 123-45-67".
 * Префикс (+7) может отсутствовать, код города (в скобках) также может отсутствовать.
 * Может присутствовать неограниченное количество пробелов и чёрточек,
 * например, номер 12 --  34- 5 -- 67 -89 тоже следует считать легальным.
 * Перевести номер в формат без скобок, пробелов и чёрточек (но с +), например,
 * "+79211234567" или "123456789" для приведённых примеров.
 * Все символы в номере, кроме цифр, пробелов и +-(), считать недопустимыми.
 * При неверном формате вернуть пустую строку.
 *
 * PS: Дополнительные примеры работы функции можно посмотреть в соответствующих тестах.
 */
fun flattenPhoneNumber(phone: String): String = TODO()

/**
 * Средняя (5 баллов)
 *
 * Результаты спортсмена на соревнованиях в прыжках в длину представлены строкой вида
 * "706 - % 717 % 703".
 * В строке могут присутствовать числа, черточки - и знаки процента %, разделённые пробелами;
 * число соответствует удачному прыжку, - пропущенной попытке, % заступу.
 * Прочитать строку и вернуть максимальное присутствующее в ней число (717 в примере).
 * При нарушении формата входной строки или при отсутствии в ней чисел, вернуть -1.
 */
fun bestLongJump(jumps: String): Int {
    val chars = mutableListOf<Char>('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '%', '-', ' ')
    val result = mutableListOf<Int>()
    var jump = ""
    var jumps1 = ""
    var maxJump = 0
    jumps1 = jumps.replace("%", " ")
    jumps1 = jumps1.replace("-", " ")
    for (i in 1..(jumps1.length - 2)) {
        if (jumps1[i - 1] !in chars) return -1
        else if (jumps1[i - 1] != ' ' && jumps1[i] != ' ' && jumps1[i + 1] != ' ') {
            jump = jumps[i - 1].toString() + jumps1[i].toString() + jumps1[i + 1].toString()
            result.add(jump.toInt())
        }
    }
    if (result.size == 0) {
        return -1
    } else {
        result.sort()
        result.reverse()
        return result[0]
    }
}

/**
 * Сложная (6 баллов)
 *
 * Результаты спортсмена на соревнованиях в прыжках в высоту представлены строкой вида
 * "220 + 224 %+ 228 %- 230 + 232 %%- 234 %".
 * Здесь + соответствует удачной попытке, % неудачной, - пропущенной.
 * Высота и соответствующие ей попытки разделяются пробелом.
 * Прочитать строку и вернуть максимальную взятую высоту (230 в примере).
 * При нарушении формата входной строки, а также в случае отсутствия удачных попыток,
 * вернуть -1.
 */
fun bestHighJump(jumps: String): Int = TODO()

/**
 * Сложная (6 баллов)
 *
 * В строке представлено выражение вида "2 + 31 - 40 + 13",
 * использующее целые положительные числа, плюсы и минусы, разделённые пробелами.
 * Наличие двух знаков подряд "13 + + 10" или двух чисел подряд "1 2" не допускается.
 * Вернуть значение выражения (6 для примера).
 * Про нарушении формата входной строки бросить исключение IllegalArgumentException
 */
fun plusMinus(expression: String): Int = TODO()

/**
 * Сложная (6 баллов)
 *
 * Строка состоит из набора слов, отделённых друг от друга одним пробелом.
 * Определить, имеются ли в строке повторяющиеся слова, идущие друг за другом.
 * Слова, отличающиеся только регистром, считать совпадающими.
 * Вернуть индекс начала первого повторяющегося слова, или -1, если повторов нет.
 * Пример: "Он пошёл в в школу" => результат 9 (индекс первого 'в')
 */
fun firstDuplicateIndex(str: String): Int = TODO()

/**
 * Сложная (6 баллов)
 *
 * Строка содержит названия товаров и цены на них в формате вида
 * "Хлеб 39.9; Молоко 62; Курица 184.0; Конфеты 89.9".
 * То есть, название товара отделено от цены пробелом,
 * а цена отделена от названия следующего товара точкой с запятой и пробелом.
 * Вернуть название самого дорогого товара в списке (в примере это Курица),
 * или пустую строку при нарушении формата строки.
 * Все цены должны быть больше нуля либо равны нулю.
 */
fun mostExpensive(description: String): String = TODO()

/**
 * Сложная (6 баллов)
 *
 * Перевести число roman, заданное в римской системе счисления,
 * в десятичную систему и вернуть как результат.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: XXIII = 23, XLIV = 44, C = 100
 *
 * Вернуть -1, если roman не является корректным римским числом
 */
fun fromRoman(roman: String): Int = TODO()

/**
 * Очень сложная (7 баллов)
 *
 * Имеется специальное устройство, представляющее собой
 * конвейер из cells ячеек (нумеруются от 0 до cells - 1 слева направо) и датчик, двигающийся над этим конвейером.
 * Строка commands содержит последовательность команд, выполняемых данным устройством, например +>+>+>+>+
 * Каждая команда кодируется одним специальным символом:
 *	> - сдвиг датчика вправо на 1 ячейку;
 *  < - сдвиг датчика влево на 1 ячейку;
 *	+ - увеличение значения в ячейке под датчиком на 1 ед.;
 *	- - уменьшение значения в ячейке под датчиком на 1 ед.;
 *	[ - если значение под датчиком равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей следующей командой ']' (с учётом вложенности);
 *	] - если значение под датчиком не равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей предыдущей командой '[' (с учётом вложенности);
 *      (комбинация [] имитирует цикл)
 *  пробел - пустая команда
 *
 * Изначально все ячейки заполнены значением 0 и датчик стоит на ячейке с номером N/2 (округлять вниз)
 *
 * После выполнения limit команд или всех команд из commands следует прекратить выполнение последовательности команд.
 * Учитываются все команды, в том числе несостоявшиеся переходы ("[" при значении под датчиком не равном 0 и "]" при
 * значении под датчиком равном 0) и пробелы.
 *
 * Вернуть список размера cells, содержащий элементы ячеек устройства после завершения выполнения последовательности.
 * Например, для 10 ячеек и командной строки +>+>+>+>+ результат должен быть 0,0,0,0,0,1,1,1,1,1
 *
 * Все прочие символы следует считать ошибочными и формировать исключение IllegalArgumentException.
 * То же исключение формируется, если у символов [ ] не оказывается пары.
 * Выход за границу конвейера также следует считать ошибкой и формировать исключение IllegalStateException.
 * Считать, что ошибочные символы и непарные скобки являются более приоритетной ошибкой чем выход за границу ленты,
 * то есть если в программе присутствует некорректный символ или непарная скобка, то должно быть выброшено
 * IllegalArgumentException.
 * IllegalArgumentException должен бросаться даже если ошибочная команда не была достигнута в ходе выполнения.
 *
 */
fun computeDeviceCells(cells: Int, commands: String, limit: Int): List<Int> = TODO()
