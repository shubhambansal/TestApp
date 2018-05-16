package dependencies

object versions{

    val supportlibrary = "27.1.0"
    val dagger = "2.14.1"
    val fragmentargs = "3.0.0"
    val rxjava = "2.1.5"
    val rxandroid = "2.0.1"
    val paperparcel = "2.0.4"
    val timber = "4.7.0"
    val retrofit = "2.3.0"
    val okhttp = "3.9.0"
    val crashlytics = "2.6.7@aar"
    val leakcanary = "1.3.1"
    val picasso = "2.5.2"
    val picasso2okhttp3downloader = "1.0.2"
    val ktlint = "0.20.0"
    val moshi = "1.5.0"
    val room = "1.0.0"

    // versions for build dependencies
    val kotlin = "1.2.31"
    val gradleplugin = "3.1.0"
    val detekt = "1.0.0.RC6"

    // versions for testing dependencies
    val junit = "4.12"
    val mockito = "2.8.9"
    val espresso = "3.0.0"
    val espressosupport = "1.0"
    val espressookhttpidlingresource = "1.0.0"

}

object libs {

    val timber = "com.jakewharton.timber:timber:${versions.timber}"
    val crashlytics = "com.crashlytics.sdk.android:crashlytics:${versions.crashlytics}"
    val leakcanary = "com.squareup.leakcanary:leakcanary-android-no-op:${versions.leakcanary}"
    val ktlint = "com.github.shyiko:ktlint:${versions.ktlint}"
    val moshi = "com.squareup.moshi:moshi:${versions.moshi}"

    object build {
        val gradleplugin = "com.android.tools.build:gradle:${versions.gradleplugin}"
        val detektplugin = "gradle.plugin.io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${versions.detekt}"

        object kotlin {
            val kotlinstdlib = "org.jetbrains.kotlin:kotlin-stdlib:${versions.kotlin}"
            val kotlingradleplugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${versions.kotlin}"
        }
    }

    object retrofit {
        val retrofit = "com.squareup.retrofit2:retrofit:${versions.retrofit}"
        val convertermoshi = "com.squareup.retrofit2:converter-moshi:${versions.retrofit}"
        val adapterrxjava2 = "com.squareup.retrofit2:adapter-rxjava2:${versions.retrofit}"
    }

    object okhttp {
        val okhttp = "com.squareup.okhttp3:okhttp:${versions.okhttp}"
        val okhttplogginginterceptor = "com.squareup.okhttp3:logging-interceptor:${versions.okhttp}"
    }

    object picasso {
        val picasso = "com.squareup.picasso:picasso:${versions.picasso}"
        val picasso2okhttp3downloader = "com.jakewharton.picasso:picasso2-okhttp3-downloader:${versions.picasso2okhttp3downloader}"
    }

    object room{
        val runtime = "android.arch.persistence.room:runtime:${versions.room}"
        val compile = "android.arch.persistence.room:compiler:${versions.room}"
        val rx = "android.arch.persistence.room:rxjava2:${versions.room}"
        val testing = "android.arch.persistence.room:testing:${versions.room}"
    }

    object dagger {
        val runtime = "com.google.dagger:dagger:${versions.dagger}"
        val compiler = "com.google.dagger:dagger-compiler:${versions.dagger}"
        val jsr250 = "javax.annotation:jsr250-api:1.0"
    }

    object fragmentargs {
        val runtime = "com.hannesdorfmann.fragmentargs:annotation:${versions.fragmentargs}"
        val compiler = "com.hannesdorfmann.fragmentargs:processor:${versions.fragmentargs}"
    }

    object paperparcel {
        val runtime = "nz.bradcampbell:paperparcel:${versions.paperparcel}"
        val compiler = "nz.bradcampbell:paperparcel-compiler:${versions.paperparcel}"
    }

    object rx {
        val rxjava = "io.reactivex.rxjava2:rxjava:${versions.rxjava}"
        val rxandroid = "io.reactivex.rxjava2:rxandroid:${versions.rxandroid}"
    }

    object androidsupport {
        val supportv4 = "com.android.support:support-v4:${versions.supportlibrary}"
        val design = "com.android.support:design:${versions.supportlibrary}"
        val recyclerviewv7 = "com.android.support:recyclerview-v7:${versions.supportlibrary}"
        val cardviewv7 = "com.android.support:cardview-v7:${versions.supportlibrary}"
        val appcompatv7 = "com.android.support:appcompat-v7:${versions.supportlibrary}"
        val palettev7 = "com.android.support:palette-v7:${versions.supportlibrary}"
        val annotations = "com.android.support:support-annotations:${versions.supportlibrary}"
    }

    object testing {
        val junit = "junit:junit:${versions.junit}"

        object mockito {
            val android = "org.mockito:mockito-android:${versions.mockito}"
            val inline = "org.mockito:mockito-inline:${versions.mockito}"
        }

        object espresso {
            val core = "com.android.support.test.espresso:espresso-core:${versions.espresso}"
            val contrib = "com.android.support.test.espresso:espresso-contrib:${versions.espresso}"
            val idlingresource = "com.android.support.test.espresso:espresso-idling-resource:${versions.espresso}"
            val intents = "com.android.support.test.espresso:espresso-intents:${versions.espresso}"
            val support = "com.android.support.test:runner:${versions.espressosupport}"
            val espressookhttpidlingresource = "com.jakewharton.espresso:okhttp3-idling-resource:${versions.espressookhttpidlingresource}"
        }
    }
}