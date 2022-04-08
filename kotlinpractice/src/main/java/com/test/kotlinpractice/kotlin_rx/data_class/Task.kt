package com.test.kotlinpractice.kotlin_rx.data_class

data class Task(val description: String, val isComplete: Boolean, val priority: Int)

data class TaskList(val taskList: Collection<Task>)

fun createTaskModel(): Collection<Task> {
    val taskList = mutableListOf<Task>()
    taskList.add(Task("Morning Walk", true, 1))
    taskList.add(Task("Morning Breakfast", true, 1))
    taskList.add(Task("Office", true, 1))
    taskList.add(Task("Lunch", false, 1))
    taskList.add(Task("Shopping", true, 1))
    taskList.add(Task("Dinner", true, 1))
    taskList.add(Task("Sleep", false, 1))

    return taskList
}