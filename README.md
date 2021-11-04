# cordova-plugin-android-webview-dark-mode

#### Apache Cordova plugin to enable dark mode support for Android WebView's

### Goals

In order for the Android WebView's to support dark modem we need to explicitly enable it.
This will allow the webview to properly use the `(prefers-color-scheme: dark)` media query.

For that we need to use the `Configuration.UI_MODE_NIGHT_YES`, `WebSettingsCompat.setForceDark` and `WebSettingsCompat.setForceDarkStrategy` configurations.
You can read more here: https://developer.android.com/guide/webapps/dark-theme

### Supported platforms

-   **Android**

#### Prerequisites/Warnings

AndroidX is required. Therefore only **cordova-android >= 9.0.0** is supported.  
You need to enable AndroidX in your `config.xml` by setting `AndroidXEnabled` to `true`.

On your application you will need to add a metatag with the value `<meta name="color-scheme" content="dark light">`
https://web.dev/color-scheme/#the-color-scheme-meta-tag

As for how to handle the dark theme on your application, please refer to this article:
https://css-tricks.com/a-complete-guide-to-dark-mode-on-the-web/

---

Built by (c) João Barata. Released under the MIT license.
