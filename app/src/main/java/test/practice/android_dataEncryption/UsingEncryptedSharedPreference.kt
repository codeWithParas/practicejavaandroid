package test.practice.android_dataEncryption

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import test.practice.R

/*
* Some References
* Android Reference : https://developer.android.com/topic/security/data?authuser=3#kotlin
* Using AES Keystore : https://www.youtube.com/watch?v=D_q07P1sfcc
* Using Encrypted Preferences : https://proandroiddev.com/encrypted-preferences-in-android-af57a89af7c8
*
* Using JNI (Best approach to make reverse engineering impossible)
* https://medium.com/novumlogic/hiding-sensitive-data-in-android-app-dbd64e88224f
*
* JNI : https://rammic.github.io/2015/07/28/hiding-secrets-in-android-apps/
* Hiding Password : https://github.com/pillfill/hiding-passwords-android
* */

class UsingEncryptedSharedPreference : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_security)

        /*val sharedPrefsFile: String = te
        val sharedPreferences: SharedPreferences = EncryptedSharedPreferences.create(
            sharedPrefsFile,
            mainKeyAlias,
            applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        with (sharedPreferences.edit()) {
            // Edit the user's shared preferences...
            apply()
        }*/
    }
}