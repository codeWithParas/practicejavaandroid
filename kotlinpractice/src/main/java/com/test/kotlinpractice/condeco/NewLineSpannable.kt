package com.test.kotlinpractice.condeco

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class NewLineSpannable {

    fun extractFloorFromWorkspaceId(fromWsTypeId: String) {
        val ids = fromWsTypeId.split('_').filterIndexed { index, value -> index != 2 }
        val builder = StringBuilder()
        ids.forEachIndexed { index, id ->
            if (index == ids.size - 1) {
                builder.append(id)
            } else {
                builder.append("${id}_")
            }
        }
        print(builder.toString())
    }

    /*fun compareDate() {
        val res = it.replace("[^0-9]".toRegex(), "").toLong()
        val nextRefreshTime = getDate(res, "dd/MM/yyyy hh:mm")
        val currentTime = getDate(Date().time, "dd/MM/yyyy hh:mm")
        stringToDate(currentTime).after(stringToDate(nextRefreshTime))
    }*/

    fun getDate(milliSeconds: Long, dateFormat: String?): String {
        // Create a DateFormatter object for displaying date in specified format.
        val formatter = SimpleDateFormat(dateFormat)

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliSeconds
        return formatter.format(calendar.time)
    }

    fun stringToDate(localDate: String): Date {
        val dateString = localDate.replace(" [AP]M$".toRegex(), "")

        val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH)

        return formatter.parse(dateString)
            ?: throw ParseException("Failed to convert to date from string: $dateString", 0)
    }
}

fun main(vararg args: String) {

    //NewLineSpannable().extractFloorFromWorkspaceId("11_15_17_2")

    val a = arrayOf(
        Student(0, "A Test"),
        Student(0, "A Test"),
        Student(0, "B Test"),
        Student(2, "E Test"),
        Student(2, "D Test"),
        Student(2, "F Test"),
        Student(1, "C Test"),
    )

    val sorted = a.groupBy { it.id }.flatMap {
        it.value.sortedBy { it.name }
    }.sortedBy { it.id }.map {
        print("\nTesting -> ${it.id}  ${it.name}")
    }

    //print("\nTesting -> ${sorted.size}")
}

class Student(i: Int, s: String) {
    val id: Int = i
        get() = field
    val name: String = s
        get() = field
}