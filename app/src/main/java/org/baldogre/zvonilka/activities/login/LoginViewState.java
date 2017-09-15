package org.baldogre.zvonilka.activities.login;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.viewstate.MvpViewStateActivity;
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;

/**
 * Created by daniyar on 14.09.17.
 */

public class LoginViewState extends MvpViewStateActivity {
    ViewState state;

    public LoginViewState() {
        super();
        state = new ViewState() {
            @Override
            public void apply(MvpView view, boolean retained) {
                
            }
        };
    }

    @NonNull
    @Override
    public MvpPresenter createPresenter() {
        return null;
    }

    @NonNull
    @Override
    public ViewState createViewState() {
        return null;
    }

    @Override
    public void onNewViewStateInstance() {

    }
}
