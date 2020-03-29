package test.practice.android_aarchitecture_kotlin.b_mvp

interface LoginView {

    fun getEmailAddress() : String
    fun getPassword() : String
    fun showProgress(show : Boolean)
    fun isLoginSuccess(isLogin : Boolean)
}