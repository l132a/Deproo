package id.smartdev.deproo.ui.account

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.parse.ParseUser
import dagger.hilt.android.AndroidEntryPoint
import id.smartdev.deproo.R
import id.smartdev.deproo.databinding.ActivitySignupBinding
import id.smartdev.deproo.base.BaseActivity

@AndroidEntryPoint
class SignUpActivity : BaseActivity<ActivitySignupBinding, ViewModel>() {
    override fun getViewModelBindingVariable(): Int = NO_VIEW_MODEL_BINDING_VARIABLE

    override fun getLayoutId(): Int = R.layout.activity_signup

    override fun init() {
        getDataBinding().btSignup.setOnClickListener {
            performSignUp()
        }
    }

    private fun performSignUp() {
        val email = getDataBinding().etEmail.text.toString().trim()
        val password = getDataBinding().etPassword.text.toString().trim()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            val user = ParseUser()
            user.username = email
            user.email = email
            user.setPassword(password)
            user.signUpInBackground { e ->
                if (e == null) {
                    this.finish()
                } else {
                    ParseUser.logOut()
                    Toast.makeText(this, e.message.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}