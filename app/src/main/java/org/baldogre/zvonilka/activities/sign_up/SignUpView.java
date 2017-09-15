package org.baldogre.zvonilka.activities.sign_up;

import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by daniyar on 15.09.17.
 */

public interface SignUpView extends MvpView {
    void showProgress(boolean show);
    void showEmailError();
    void showPasswordError();
    void showToast(String text, int length);

    void onRegistered();
}
