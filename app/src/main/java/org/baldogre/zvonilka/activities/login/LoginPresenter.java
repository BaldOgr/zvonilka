package org.baldogre.zvonilka.activities.login;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

/**
 * Created by daniyar on 14.09.17.
 */

public class LoginPresenter extends MvpBasePresenter<LoginView> {
    private LoginTask loginTask;

    private void cancelLoginTaskIfRunning(){
        if (loginTask != null){
            loginTask.cancel(true);
        }
    }

    public void login(String login, String password){
        cancelLoginTaskIfRunning();

        getView().showProgress(true);
        if (!login.contains("@")){
            getView().showEmailError();
            getView().showProgress(false);
            return;
        }

        if (!(password.length() >= 6)){
            getView().showPasswordError();
            getView().showProgress(false);
            return;
        }

        loginTask = new LoginTask(login, password, new LoginTask.LoginTaskListener() {
            @Override
            public void onLogin() {
                if(isViewAttached()){
                    getView().showProgress(false);
                    getView().showToast("Successful!");
                }
            }

            @Override
            public void onError(String message) {
                if (isViewAttached()){
                    getView().showProgress(false);
                    getView().showToast(message);
                }
            }
        });
        loginTask.execute();
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if (!retainInstance){
            cancelLoginTaskIfRunning();
        }
    }
}
