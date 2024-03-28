package me.iamsahil.reactnativeintegrationdemo

import android.widget.Toast
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

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
        Toast.makeText(reactApplicationContext, "Response from React Native: $response", Toast.LENGTH_SHORT).show()
    }
}
