package org.baldogre.zvonilka.activities.main.tasks;

import android.os.AsyncTask;

import org.baldogre.zvonilka.entity.Client;

import java.util.List;

/**
 * Created by daniyar on 16.09.17.
 */

public class GetClientListTask extends AsyncTask<Integer, List<Client>, List<Client>> {

    public interface GetClientListTaskListener {
        void onComplete();

        void onError(String message);
    }

    GetClientListTaskListener listener;
    int size;
    int page;

    public GetClientListTask(int page, int size, GetClientListTaskListener listener) {
        this.listener = listener;
        this.size = size;
        this.page = page;
    }

    @Override
    protected List<Client> doInBackground(Integer... params) {
        return null;
    }
}
