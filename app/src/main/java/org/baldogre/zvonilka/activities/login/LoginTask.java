package org.baldogre.zvonilka.activities.login;

import android.os.AsyncTask;
import android.util.Log;

import com.backendless.Backendless;
import com.backendless.exceptions.BackendlessException;

/**
 * Created by daniyar on 14.09.17.
 */

public class LoginTask extends AsyncTask<Integer, Integer, BackendlessException> {

    public interface LoginTaskListener{
        void onLogin();
        void onError(String message);
    }

    private String login;
    private String password;
    private LoginTaskListener listener;

    public LoginTask(String login, String password, LoginTaskListener listener) {
        this.login = login;
        this.password = password;
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected BackendlessException doInBackground(Integer... params) {
        try {
            Log.i("LoginTask", login);
            Log.i("LoginTask", password);
            Backendless.UserService.login(login, password);
        } catch (BackendlessException ex) {
            Log.i("LoginTask", ex.getCode());
            Log.i("LoginTask", ex.getMessage());
            return ex;
        }
        return null;
    }

    @Override
    protected void onPostExecute(BackendlessException ex) {
        super.onPostExecute(ex);
        if (ex == null) {
            listener.onLogin();
        } else {
            listener.onError(ex.getMessage());
        }
    }
}
