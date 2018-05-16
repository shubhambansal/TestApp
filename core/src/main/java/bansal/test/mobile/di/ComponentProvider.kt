package de.zalando.lounge.di

interface ComponentProvider {
    fun <T> getComponent(componentType: Class<T>): T
}
