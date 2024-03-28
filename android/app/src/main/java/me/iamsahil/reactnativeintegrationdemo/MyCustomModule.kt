package me.iamsahil.reactnativeintegrationdemo

import android.widget.Toast
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.WritableNativeMap
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.modules.core.DeviceEventManagerModule
@ReactModule(name = "MyCustomModule")
class MyCustomModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "MyCustomModule"
    }

    @ReactMethod
    fun handleButtonClick(message: String) {
        Toast.makeText(reactApplicationContext, message, Toast.LENGTH_SHORT).show()
    }

    @ReactMethod
    fun handleResponse(response: String) {
        Toast.makeText(reactApplicationContext, "$response", Toast.LENGTH_SHORT).show()
    }

    @ReactMethod
    fun sendEventToReactNative() {
        val eventData = WritableNativeMap().apply {
            putString("message", "Hello from native app")
        }
        reactApplicationContext
            .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter::class.java)
            .emit("EventDataFromNative", eventData)
    }
}
