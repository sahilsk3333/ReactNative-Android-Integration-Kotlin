package me.iamsahil.reactnativeintegrationdemo

import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import com.facebook.react.BuildConfig
import com.facebook.react.PackageList
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactPackage
import com.facebook.react.ReactRootView
import com.facebook.react.common.LifecycleState
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
import com.facebook.soloader.SoLoader
import me.iamsahil.reactnativeintegrationdemo.databinding.ActivityMainReactBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainReactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainReactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        SoLoader.init(this, false)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.reactUiContainerLayout.id, ReactViewFragment.newInstance())
                .commit()
        }

    }


}