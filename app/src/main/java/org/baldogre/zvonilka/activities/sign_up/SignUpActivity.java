package org.baldogre.zvonilka.activities.sign_up;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;

import org.baldogre.zvonilka.R;
import org.baldogre.zvonilka.activities.login.LoginView;

public class SignUpActivity extends MvpActivity<SignUpView, SignUpPresenter> implements SignUpView {
    EditText mEmail;
    EditText mPassword;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initUi();
    }

    @NonNull
    @Override
    public SignUpPresenter createPresenter() {
        return new SignUpPresenter();
    }

    private void initUi() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        mEmail = (EditText) findViewById(R.id.sign_up_email);
        mPassword = (EditText) findViewById(R.id.sign_up_password);
        findViewById(R.id.sign_up_action).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login(mEmail.getText().toString(), mPassword.getText().toString());
            }
        });
    }

    @Override
    public void showProgress(boolean show) {
        if (show){
            progressDialog.show();
        } else {
            progressDialog.cancel();
        }
    }

    @Override
    public void showEmailError() {
        mEmail.setError("Email must contains @");
        mEmail.requestFocus();
    }

    @Override
    public void showPasswordError() {
        mPassword.setError("Password length must be greater than 5");
        mPassword.requestFocus();
    }

    @Override
    public void showToast(String text, int length) {
        Toast.makeText(getApplicationContext(), text, length).show();
    }

    @Override
    public void onRegistered() {
        showToast("Registered!", Toast.LENGTH_LONG);
        finish();
    }
}
