package id.smartdev.deproo.ui.account

import androidx.lifecycle.ViewModel
import cn.pedant.SweetAlert.SweetAlertDialog
import com.parse.LogInCallback
import com.parse.ParseUser
import dagger.hilt.android.AndroidEntryPoint
import id.smartdev.deproo.R
import id.smartdev.deproo.base.BaseFragment
import id.smartdev.deproo.databinding.FragmentSignInBinding
import id.smartdev.deproo.util.Helper

@AndroidEntryPoint
class SignInFragment : BaseFragment<FragmentSignInBinding, ViewModel>() {
    override fun getViewModelBindingVariable(): Int = NO_VIEW_MODEL_BINDING_VARIABLE

    override fun getLayoutId(): Int = R.layout.fragment_sign_in

    override fun init() {
        setHasOptionsMenu(true)

        getDataBinding().btLogin.setOnClickListener {
            performLogin()
        }
    }

    private fun performLogin() {
        val email = getDataBinding().etEmail.text.toString().trim()
        val password = getDataBinding().etPassword.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()) {
            SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Error")
                .setContentText("Email/Password tidak boleh kosong")
                .show()
            return
        }

        if (!Helper.validateEmail(email)) {
            SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Error")
                .setContentText("Email tidak valid")
                .show()
            return
        }

        ParseUser.logInInBackground(email, password) { user, e ->
            if (user != null) {
                if (user.getBoolean("emailVerified")) {
                    SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Welcome")
                        .setContentText("Selamat datang, ${user.username}")
                        .show()
                } else {
                    ParseUser.logOut()
                    SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Error")
                        .setContentText("Mohon lakukan konfirmasi akun Anda melalui email")
                        .show()
                }
            } else {
                ParseUser.logOut()
                SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Error")
                    .setContentText("Email/ Password salah")
                    .show()
            }
        }
    }
}