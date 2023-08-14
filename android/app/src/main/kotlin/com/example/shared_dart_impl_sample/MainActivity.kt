package com.example.shared_dart_impl_sample

import android.util.Log
import io.flutter.embedding.android.FlutterActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity: FlutterActivity() {
    override fun onResume() {
        super.onResume()

        val flutterChannel = FlutterChannel(this)
        CoroutineScope(Dispatchers.Main).launch {
            try {
//                val result = flutterChannel.invokeMethod("ping", null)
                val result = flutterChannel.ping()
                Log.d("Flutter", "result = $result")
            } catch (e: Exception) {
                Log.e("Flutter", "Error invoking method", e)
            }
        }
    }
}
