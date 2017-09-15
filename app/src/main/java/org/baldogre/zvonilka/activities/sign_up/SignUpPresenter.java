package org.baldogre.zvonilka.activities.sign_up;

import android.widget.Toast;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

/**
 * Created by daniyar on 15.09.17.
 */

public class SignUpPresenter extends MvpBasePresenter<SignUpView> {
    private SignUpTask signUpTask;

    private void cancelSignUpTaskIfRunning(){
        if (signUpTask != null){
            signUpTask.cancel(true);
        }
    }

    public void login(String login, String password){
        cancelSignUpTaskIfRunning();

        getView().showProgress(true);
        if (!confirmEmail(login)){
            getView().showEmailError();
            return;
        }
        if (!confirmPassword(password)) {
            getView().showPasswordError();
        }
        signUpTask = new SignUpTask(login, password, new SignUpTask.SignUpTaskListener() {
            @Override
            public void onRegistered() {
                if(isViewAttached()){
                    getView().showProgress(false);
                    getView().onRegistered();
                }
            }

            @Override
            public void onError(String message) {
                if (isViewAttached()){
                    getView().showToast(message, Toast.LENGTH_LONG);
                    getView().showProgress(false);
                }
            }

        });
        signUpTask.execute();
    }

    private boolean confirmPassword(String password) {
        return password.length() >= 6;
    }

    private boolean confirmEmail(String login) {
        return login.contains("@");
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if (!retainInstance){
            cancelSignUpTaskIfRunning();
        }
    }
}
