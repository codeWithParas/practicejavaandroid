package com.test.kotlinpractice

import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec

fun main() {

    val ZERO_IV: IvParameterSpec = IvParameterSpec(ByteArray(16));
    var str: String = "test"
    val plaintext: ByteArray = str.toByteArray()
    print(">> OK : " + plaintext)
    val keygen = KeyGenerator.getInstance("AES")
    keygen.init(256)
    val key: SecretKey = keygen.generateKey()
    val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
    //val cipher = Cipher.getInstance("AES/ECB/NoPadding")
    cipher.init(Cipher.ENCRYPT_MODE, key, ZERO_IV)
    val ciphertext: ByteArray = cipher.doFinal(plaintext)
    val iv: ByteArray = cipher.iv

    print("\n>> OK : " + bytesToHex(ciphertext))
    print("\n>> OK : " + bytesToHex(iv))

    val md = MessageDigest.getInstance("SHA-256")
    val digest: ByteArray = md.digest(ciphertext)
    val digestiv: ByteArray = md.digest(iv)
    print("\n>> OK : " + bytesToHex(digest))
    print("\n>> OK : " + bytesToHex(digestiv))

    /*val s = Signature.getInstance("SHA256withECDSA")
            .apply {
                initSign(key)
                update(digest)
            }
    val signature: ByteArray = s.sign()*/


}

fun bytesToHex(hashInBytes: ByteArray): String? {
    val sb = StringBuilder()
    for (i in hashInBytes.indices) {
        sb.append(Integer.toString(0xff and (hashInBytes[i]) + 0x100, 16).substring(1))
    }
    return sb.toString()
}

fun bytesToHex2(hashInBytes: ByteArray): String? {
    val sb = StringBuilder()
    for (i in hashInBytes.indices) {
        val hex = Integer.toHexString(0xff and hashInBytes[i].toInt())
        if (hex.length == 1) sb.append('0')
        sb.append(hex)
    }
    return sb.toString()
}

fun bytesToHex3(hashInBytes: ByteArray): String? {
    val sb = StringBuilder()
    for (b in hashInBytes) {
        sb.append(String.format("%02x", b))
    }
    return sb.toString()
}

