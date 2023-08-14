package com.example.shared_dart_impl_sample

import FlutterAPI
import android.content.Context
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.embedding.engine.loader.FlutterLoader
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class FlutterChannel(private val context: Context) {
//    private var methodChannel: MethodChannel
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

//            methodChannel = MethodChannel(
//                dartExecutor.binaryMessenger,
//                "dart_channel"
//            )
            api = FlutterAPI(dartExecutor.binaryMessenger)
        }
    }

//    suspend fun invokeMethod(method: String, arguments: Any?): Any? {
//        suspendCoroutine { continuation ->
//            methodChannel.invokeMethod(method, arguments, object : MethodChannel.Result {
//                override fun success(result: Any?) {
//                    continuation.resume(result)
//                }
//                override fun error(errorCode: String, errorMessage: String?, errorDetails: Any?) {
//                    continuation.resumeWithException(RuntimeException(message = errorMessage))
//                }
//                override fun notImplemented() {
//                    continuation.resumeWithException(NotImplementedError("Method not implemented"))
//                }
//            })
//        }
//    }

    suspend fun ping(): String = suspendCoroutine { continuation ->
        api.ping { continuation.resume(it) }
    }
}