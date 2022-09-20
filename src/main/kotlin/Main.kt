import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Calendar

fun main() {
    var year: Int = Calendar.getInstance().get(Calendar.YEAR)
    val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
    var today = LocalDate.now()
    var formattedToday = today.format(formatter)

    println("$today")

    print("Enter your birth month: ")
    var birthMonth: Int = readLine()!!.toInt()
    print("Enter your birth day: ")
    var birthDay: Int = readLine()!!.toInt()

    var holdBirthday: LocalDate = LocalDate.of(year, birthMonth, birthDay)

    if (holdBirthday.isBefore(today)){
        holdBirthday = holdBirthday.plusYears(1)
        println("Your next birthday is ${holdBirthday.format(formatter)}")
    } else {
        println("Your birthday this year is ${holdBirthday.format(formatter)}!")
    }

    //var nextBirthday = holdBirthday.format(formatter)
    var daysToBirthday = today.until(holdBirthday,ChronoUnit.DAYS)
    if (daysToBirthday.toInt() == 0){
        println("Happy Birthday You!")
    } else {
        println("Yor next birthday is ${holdBirthday.format(formatter)} and there are $daysToBirthday days until then!")
    }
}