package myandroid.app.hhobzic.a5solutionadsdk

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.android.gms.ads.*
import com.google.android.gms.ads.AdView

class AdMobBanner(
) {
    fun loadBannerAd(context: Context, admobBannerId: String, container: FrameLayout) {
        val adView = AdView(context)
        adView.adUnitId = admobBannerId
        adView.setAdSize(AdSize.BANNER)

        adView.adListener = object : AdListener() {
            override fun onAdFailedToLoad(p0: LoadAdError) {
                super.onAdFailedToLoad(p0)
                Log.d("MyBanner", "onAdFailedToLoad: Admob Fail")
            }

            override fun onAdLoaded() {
                super.onAdLoaded()
                adView.let {
                    it.parent?.let {
                        (it as ViewGroup).removeView(adView)
                        it.removeAllViews()
                        Log.d("MyBanner", "onAdLoaded: child")
                    }
                }
                container.addView(adView)
                container.visibility = View.VISIBLE
            }
        }
        val adRequest = AdRequest.Builder().build()
        // Start loading the ad in the background.
        adView.loadAd(adRequest)
    }

    companion object{
        fun loadBannerAd(context: Context, admobBannerId: String, container: FrameLayout) {
            // Check if the device is connected to any network (Wi-Fi or cellular)
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)

            // Check if the device is connected to any network
            val isConnected = networkCapabilities != null

            if (isConnected) {
                // Proceed with loading the ad if connected to any network
                val adView = AdView(context)
                adView.adUnitId = admobBannerId
                adView.setAdSize(AdSize.BANNER)

                adView.adListener = object : AdListener() {
                    override fun onAdFailedToLoad(p0: LoadAdError) {
                        super.onAdFailedToLoad(p0)
                        Log.d("MyBanner", "onAdFailedToLoad: Admob Fail")
                    }

                    override fun onAdLoaded() {
                        super.onAdLoaded()
                        adView.let {
                            it.parent?.let {
                                (it as ViewGroup).removeView(adView)
                                it.removeAllViews()
                                Log.d("MyBanner", "onAdLoaded: child")
                            }
                        }
                        container.addView(adView)
                        container.visibility = View.VISIBLE
                    }
                }
                val adRequest = AdRequest.Builder().build()
                // Start loading the ad in the background.
                adView.loadAd(adRequest)
            } else {
                // Handle cases where the device is not connected to any network
                Log.d("MyBanner", "Device is not connected to any network.")
            }
        }

    }
        fun loadFullBannerAd(context: Context, admobBannerId: String, container: FrameLayout) {
            val adView = AdView(context)
            adView.adUnitId = admobBannerId
            adView.setAdSize(AdSize.FULL_BANNER)

            adView.adListener = object : AdListener() {
                override fun onAdFailedToLoad(p0: LoadAdError) {
                    super.onAdFailedToLoad(p0)
                    Log.d("MyBanner", "onAdFailedToLoad: Admob Fail")
                }

                override fun onAdLoaded() {
                    super.onAdLoaded()
                    adView.let {
                        it.parent?.let {
                            (it as ViewGroup).removeView(adView)

                            it.removeAllViews()
                            Log.d("MyBanner", "onAdLoaded: child")
                        }
                    }
                    container.addView(adView)
                    container.visibility = View.VISIBLE
                }
            }
            val adRequest = AdRequest.Builder().build()
            // Start loading the ad in the background.
            adView.loadAd(adRequest)
        }

}