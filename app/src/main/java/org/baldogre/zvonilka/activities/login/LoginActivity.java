package org.baldogre.zvonilka.activities.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.hannesdorfmann.mosby3.mvp.MvpActivity;

import org.baldogre.zvonilka.R;
import org.baldogre.zvonilka.activities.main.MainActivity;
import org.baldogre.zvonilka.activities.sign_up.SignUpActivity;
import org.baldogre.zvonilka.entity.crud.common.Defaults;

public class LoginActivity extends MvpActivity<LoginView, LoginPresenter> implements LoginView {

    ProgressDialog mProgressDialog;
    EditText mUsername;
    EditText mPassword;
    Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Backendless.initApp(getApplicationContext(), Defaults.APPLICATION_ID, Defaults.API_KEY);    // TODO login if has current
        initUi();

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login(mUsername.getText().toString(), mPassword.getText().toString());
            }
        });
    }

    private void initUi() {
        mUsername = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);
        mLogin = (Button) findViewById(R.id.email_sign_in_button);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage(getString(R.string.loading));


        findViewById(R.id.email_sign_up_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void showProgress(boolean show) {
        if (show){
            mProgressDialog.show();
        } else {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showEmailError() {
        mUsername.setError("Email must contains @");
        mUsername.requestFocus();
    }

    @Override
    public void showPasswordError() {
        mPassword.setError("Password length must be greater than 5");
        mPassword.requestFocus();
    }

    @Override
    public void onLogin() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
