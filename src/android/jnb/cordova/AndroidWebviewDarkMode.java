package jnb.cordova;

import android.content.res.Configuration;
import android.util.Log;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.engine.SystemWebView;

import static org.apache.cordova.CordovaActivity.TAG;
import static androidx.webkit.WebSettingsCompat.FORCE_DARK_OFF;
import static androidx.webkit.WebSettingsCompat.FORCE_DARK_ON;
import static androidx.webkit.WebSettingsCompat.DARK_STRATEGY_WEB_THEME_DARKENING_ONLY;

public class AndroidWebviewDarkMode extends CordovaPlugin {

    @Override
    protected void pluginInitialize() {
        super.pluginInitialize();
        Log.d(TAG, "Initializing DarkMode plugin");
        checkDarkMode();
        Log.d(TAG, "DarkMode plugin Enabled");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "Recheck DarkMode settings");
        checkDarkMode();
        Log.d(TAG, "DarkMode settings applied");
    }

    private void checkDarkMode() {

        android.webkit.WebSettings settings = ((SystemWebView)webView.getEngine().getView()).getSettings();

        if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
            switch ( cordova.getContext().getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) {
                case Configuration.UI_MODE_NIGHT_YES:
                    WebSettingsCompat.setForceDark( settings, FORCE_DARK_ON);
                    break;
                case Configuration.UI_MODE_NIGHT_NO:
                case Configuration.UI_MODE_NIGHT_UNDEFINED:
                default:
                    WebSettingsCompat.setForceDark(settings, FORCE_DARK_OFF);
                    break;
            }
        }
        if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK_STRATEGY)){
            WebSettingsCompat.setForceDarkStrategy(settings, DARK_STRATEGY_WEB_THEME_DARKENING_ONLY);
        }
    }
}