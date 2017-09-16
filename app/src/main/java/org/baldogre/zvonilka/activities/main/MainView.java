package org.baldogre.zvonilka.activities.main;

import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by daniyar on 16.09.17.
 */

public interface MainView extends MvpView {
    void showProgress(boolean show);
    void showError(String message);
}
