package ru.agladkov.delizioso.common

interface EventHandler<E> {
    fun obtainEvent(event: E)
}
