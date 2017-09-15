package org.baldogre.zvonilka.activities.login;

import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by daniyar on 14.09.17.
 */

public interface LoginView extends MvpView {
    void showProgress(boolean show);
    void showToast(String message);

    void showEmailError();

    void showPasswordError();
}
