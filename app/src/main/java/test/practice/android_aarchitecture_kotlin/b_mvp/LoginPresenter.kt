package test.practice.android_aarchitecture_kotlin.b_mvp

import android.os.Handler
import java.util.*

class LoginPresenter(val view: LoginView) {

    //repo obj : do all network linking in repo class


    fun performLogin() {
        view.showProgress(true)
        delayFunction({
            val emailAddress = view.getEmailAddress()
            val password = view.getPassword()
            if(emailAddress.isNotBlank() && password.isNotBlank())
            {
                view.isLoginSuccess(true)
            }
            else{
                view.isLoginSuccess(false)
            }
            view.showProgress(false)
        }, 4000)

    }

    fun delayFunction(function: ()-> Unit, delay: Long) {
        Handler().postDelayed(function, delay)
    }
}