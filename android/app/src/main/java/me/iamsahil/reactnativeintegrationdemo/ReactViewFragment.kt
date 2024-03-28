package me.iamsahil.reactnativeintegrationdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.facebook.react.BuildConfig
import com.facebook.react.PackageList
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactPackage
import com.facebook.react.ReactRootView
import com.facebook.react.common.LifecycleState
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
import me.iamsahil.reactnativeintegrationdemo.databinding.FragmentReactViewBinding


class ReactViewFragment : Fragment() , DefaultHardwareBackBtnHandler {

    private var reactInstanceManager: ReactInstanceManager? = null
    private var reactRootView: ReactRootView? = null


    private  var _binding : FragmentReactViewBinding? = null
    private val binding : FragmentReactViewBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReactViewBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val packages: MutableList<ReactPackage> = PackageList(activity?.application).packages

        // Packages that cannot be autolinked yet can be added manually here, for example:
        packages.add(MyReactNativePackage())

        reactInstanceManager = ReactInstanceManager.builder()
            .setApplication(activity?.application)
            .setCurrentActivity(activity)
            .setBundleAssetName("index.android.bundle")
            .setJSMainModulePath("index")
            .addPackages(packages)
            .setUseDeveloperSupport(BuildConfig.DEBUG)
            .setInitialLifecycleState(LifecycleState.RESUMED)
            .build()


        // Create React Root View
        reactRootView = ReactRootView(requireContext())
        reactRootView?.startReactApplication(reactInstanceManager, "MyReactNativeApp", null)

        // Add React Root View to FrameLayout using View Binding
        binding.root.addView(reactRootView)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ReactViewFragment()
    }

    override fun invokeDefaultOnBackPressed() {
        super.getActivity()?.onBackPressed()
    }

    override fun onResume() {
        super.onResume()
        reactInstanceManager?.onHostResume(activity, this)
    }

    override fun onPause() {
        super.onPause()
        reactInstanceManager?.onHostPause(activity)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        reactInstanceManager?.onHostDestroy(activity)
        reactRootView?.unmountReactApplication()
    }

}