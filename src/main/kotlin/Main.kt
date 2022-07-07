const val day = 24 * (60 * 60)
const val hour = 60 * 60
const val min = 60

fun main() {

    println("Был(а) в сети ${agoToText(54)}")
    println("Был(а) в сети ${agoToText(56 * min)}")
    println("Был(а) в сети ${agoToText(21 * hour)}")
    println("Был(а) в сети ${agoToText(3 * day)}")
    println("Был(а) в сети ${agoToText(2 * day)}")
    println("Был(а) в сети ${agoToText(8 * day)}")

}


fun agoToText(time: Int): String {
    val text: String = when {
        time in 1..59 -> "только что"
        time in min..hour -> "${time / 60} ${minut(time / 60)} назад"
        time >= hour + 1 && time <= day -> "${time / (60 * 60)} ${hours(time / (60 * 60))} назад"
        time <= 2 * day && time > 1 * day -> "сегодня"
        time <= 3 * day && time > 2 * day -> "вчера"
        else -> "давно"
    }
    return text
}


fun hours(ho: Int) = when (ho) {
    11 -> "часов"
    1, 21 -> "час"
    2, 3, 4, 22, 23, 24 -> "часа"
    else -> "часов"
}

fun minut(mi: Int) = when (mi) {
    11 -> "минут"
    1, 21, 31, 41, 51 -> "минуту"
    2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> "минуты"
    else -> "минут"
}

