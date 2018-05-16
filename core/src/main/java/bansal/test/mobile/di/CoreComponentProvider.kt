package de.zalando.lounge.di

interface CoreComponentProvider {

    fun getCoreComponent(): CoreComponent
    fun <T> getComponent(componentType: Class<T>, componentBuilder: ComponentBuilder<T>): T
}
