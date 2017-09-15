
package org.baldogre.zvonilka.entity;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.DataQueryBuilder;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String ownerId;
    private String Name;
    private String objectId;
    private java.util.Date Birthday;
    private java.util.Date created;
    private String Note;
    private java.util.Date updated;
    private String PhoneNumber;
    private List<ToDo> ToDo;
    private List<Call> Calls;

    public String getOwnerId() {
        return ownerId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getObjectId() {
        return objectId;
    }

    public java.util.Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(java.util.Date Birthday) {
        this.Birthday = Birthday;
    }

    public java.util.Date getCreated() {
        return created;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public java.util.Date getUpdated() {
        return updated;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public List<ToDo> getToDo() {
        return ToDo;
    }

    public void setToDo(List<ToDo> ToDo) {
        this.ToDo = ToDo;
    }

    public List<Call> getCalls() {
        return Calls;
    }

    public void setCalls(List<Call> Calls) {
        this.Calls = Calls;
    }

    public void addCall(Call call) {
        if (this.Calls == null) {
            Calls = new ArrayList<>();
        }
        Calls.add(call);
    }


    public Client save() {
        return Backendless.Data.of(Client.class).save(this);
    }

    public void saveAsync(AsyncCallback<Client> callback) {
        Backendless.Data.of(Client.class).save(this, callback);
    }

    public Long remove() {
        return Backendless.Data.of(Client.class).remove(this);
    }

    public void removeAsync(AsyncCallback<Long> callback) {
        Backendless.Data.of(Client.class).remove(this, callback);
    }

    public static Client findById(String id) {
        return Backendless.Data.of(Client.class).findById(id);
    }

    public static void findByIdAsync(String id, AsyncCallback<Client> callback) {
        Backendless.Data.of(Client.class).findById(id, callback);
    }

    public static Client findFirst() {
        return Backendless.Data.of(Client.class).findFirst();
    }

    public static void findFirstAsync(AsyncCallback<Client> callback) {
        Backendless.Data.of(Client.class).findFirst(callback);
    }

    public static Client findLast() {
        return Backendless.Data.of(Client.class).findLast();
    }

    public static void findLastAsync(AsyncCallback<Client> callback) {
        Backendless.Data.of(Client.class).findLast(callback);
    }

    public static List<Client> find(DataQueryBuilder queryBuilder) {
        return Backendless.Data.of(Client.class).find(queryBuilder);
    }

    public static void findAsync(DataQueryBuilder queryBuilder, AsyncCallback<List<Client>> callback) {
        Backendless.Data.of(Client.class).find(queryBuilder, callback);
    }
}