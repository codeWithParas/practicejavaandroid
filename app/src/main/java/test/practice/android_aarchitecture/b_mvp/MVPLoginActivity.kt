package test.practice.android_aarchitecture.b_mvp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.mvp_login_activity.*
import test.practice.R

class MVPLoginActivity : AppCompatActivity(), LoginView
{
    val presenter by lazy { LoginPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mvp_login_activity)

        loginButton.setOnClickListener { presenter.performLogin() }
    }

    override fun getEmailAddress(): String {

        return emailEditText.text.toString()
    }

    override fun getPassword(): String {

        return passwordEditText.text.toString()
     }

    override fun showProgress(show: Boolean) {
        if(show){
            progressBar.visibility = View.VISIBLE
        }else {
            progressBar.visibility = View.GONE
        }
    }

    override fun isLoginSuccess(isLogin: Boolean) {
        if (isLogin){
            Toast.makeText(this, "Login Success", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
        }

    }
}