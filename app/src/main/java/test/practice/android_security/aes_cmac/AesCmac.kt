package test.practice.android_security.aes_cmac

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.MasterKeys
//import jdk.nashorn.internal.runtime.ScriptingFunctions.readLine
import test.practice.R
import java.io.File
import java.io.FileReader
import java.io.IOException
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey


class AesCmac : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aes_cmac)

        findViewById<Button>(R.id.butRead).setOnClickListener(View.OnClickListener {

            readFile()
        })

        findViewById<Button>(R.id.butWrite).setOnClickListener(View.OnClickListener {

            writeFile()
        })
    }

    private fun writeFile() {

        // Although you can define your own key generation parameter specification, it's
    // recommended that you use the value specified here.
        val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
        val masterKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)

    // Creates a file with this name, or replaces an existing file
    // that has the same name. Note that the file name cannot contain
    // path separators.
        val fileToWrite = "my_sensitive_data.txt"
        /*val encryptedFile = EncryptedFile.Builder(
                File(directory, fileToWrite),
                context,
                masterKeyAlias,
                EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB
        ).build()*/

        /*encryptedFile.openFileOutput().bufferedWriter().use {
            it.write("MY SUPER-SECRET INFORMATION")
        }*/
    }

    private fun readFile() {

        // Although you can define your own key generation parameter specification, it's
        // recommended that you use the value specified here.
        val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
        val masterKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)

        val fileToRead = "my_sensitive_data.txt"
        /*val encryptedFile = EncryptedFile.Builder(
                File(directory, fileToRead),
                this,
                masterKeyAlias,
                EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB
        ).build()*/

        /*val stringBuffer = StringBuffer()
        try {
            BufferedReader(FileReader(encryptedFile)).use({ reader ->
                var line: String = reader.readLine()
                while (line != null) {
                    stringBuffer.append(line).append('\n')
                    line = reader.readLine()
                }
            })
        } catch (e: IOException) { // Error occurred opening raw file for reading.
        } finally {
            val contents = stringBuffer.toString()
        }*/
    }


}