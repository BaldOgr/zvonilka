package org.baldogre.zvonilka.activities.main;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

import org.baldogre.zvonilka.activities.main.tasks.GetClientListTask;
import org.baldogre.zvonilka.adapter.ClientAdapter;

/**
 * Created by daniyar on 16.09.17.
 */

public class MainPresenter extends MvpBasePresenter<MainView> {
    public static MainPresenter presenter;
    MainModel model;

    public MainPresenter() {
        model = new MainModel();
    }

    public static MainPresenter getPresenter() {
        if (presenter == null) {
            presenter = new MainPresenter();
        }
        return presenter;
    }

    public void getClientList(final ClientAdapter adapter) {
        getClientList(0, 10, adapter);
    }

    public void getClientList(int page, int size, final ClientAdapter adapter) {
        GetClientListTask task = new GetClientListTask(page, size, new GetClientListTask.GetClientListTaskListener() {
            @Override
            public void onComplete() {
                adapter.notifyDataSetChanged();
                getView().showProgress(false);
            }

            @Override
            public void onError(String message) {
                getView().showError(message);
            }
        });
        task.execute();
    }

}
