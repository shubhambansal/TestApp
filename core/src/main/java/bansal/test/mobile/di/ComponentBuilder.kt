package de.zalando.lounge.di

interface ComponentBuilder<T> {
    fun buildComponent(): T
}
