package com.barreto.listatarefas

data class Task (val name:String, val category:TaskCategory, var isSelected:Boolean = false)