package com.example.shared_dart_impl_sample

import FlutterAPI
import android.content.Context
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.embedding.engine.loader.FlutterLoader
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class FlutterChannel(private val context: Context) {
    private var api: FlutterAPI

    init {
        FlutterEngine(context).run {
            dartExecutor.executeDartEntrypoint(
                DartExecutor.DartEntrypoint(
                    FlutterLoader().apply {
                        startInitialization(context)
                        ensureInitializationComplete(context, null)
                    }.findAppBundlePath(),
                    "nativeMain"
                )
            )
            api = FlutterAPI(dartExecutor.binaryMessenger)
        }
    }

    suspend fun ping(): String = suspendCoroutine { continuation ->
        api.ping { continuation.resume(it) }
    }
}