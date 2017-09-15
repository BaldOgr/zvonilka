package org.baldogre.zvonilka.activities.sign_up;

import android.os.AsyncTask;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.exceptions.BackendlessException;

/**
 * Created by daniyar on 15.09.17.
 */

public class SignUpTask extends AsyncTask<Integer, Integer, BackendlessException> {
    String login;
    String password;
    SignUpTaskListener listener;

    public SignUpTask(String login, String password, SignUpTaskListener listener) {
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
            BackendlessUser user = new BackendlessUser();
            user.setEmail(login);
            user.setPassword(password);
            user = Backendless.UserService.register(user);
            if (user == null) {

            }
        } catch (BackendlessException ex) {
            return ex;
        }
        return null;
    }

    @Override
    protected void onPostExecute(BackendlessException o) {
        super.onPostExecute(o);
        if (o == null) {
            listener.onRegistered();
        } else {
            listener.onError(o.getMessage());
        }
    }

    public interface SignUpTaskListener {
        void onRegistered();

        void onError(String message);
    }
}
