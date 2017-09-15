
package org.baldogre.zvonilka.entity;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

public class UserInfo
{
  private String Name;
  private java.util.Date updated;
  private String PhoneNumber;
  private java.util.Date created;
  private String ownerId;
  private Integer Rules;
  private String objectId;
  private List<ToDo> ToDo;
  private List<Call> Call;
  public String getName()
  {
    return Name;
  }

  public void setName( String Name )
  {
    this.Name = Name;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getPhoneNumber()
  {
    return PhoneNumber;
  }

  public void setPhoneNumber( String PhoneNumber )
  {
    this.PhoneNumber = PhoneNumber;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public Integer getRules()
  {
    return Rules;
  }

  public void setRules( Integer Rules )
  {
    this.Rules = Rules;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public List<ToDo> getToDo()
  {
    return ToDo;
  }

  public void setToDo( List<ToDo> ToDo )
  {
    this.ToDo = ToDo;
  }

  public List<Call> getCall()
  {
    return Call;
  }

  public void setCall( List<Call> Call )
  {
    this.Call = Call;
  }

                                                    
  public UserInfo save()
  {
    return Backendless.Data.of( UserInfo.class ).save( this );
  }

  public void saveAsync( AsyncCallback<UserInfo> callback )
  {
    Backendless.Data.of( UserInfo.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( UserInfo.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( UserInfo.class ).remove( this, callback );
  }

  public static UserInfo findById( String id )
  {
    return Backendless.Data.of( UserInfo.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<UserInfo> callback )
  {
    Backendless.Data.of( UserInfo.class ).findById( id, callback );
  }

  public static UserInfo findFirst()
  {
    return Backendless.Data.of( UserInfo.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<UserInfo> callback )
  {
    Backendless.Data.of( UserInfo.class ).findFirst( callback );
  }

  public static UserInfo findLast()
  {
    return Backendless.Data.of( UserInfo.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<UserInfo> callback )
  {
    Backendless.Data.of( UserInfo.class ).findLast( callback );
  }

  public static List<UserInfo> find( DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( UserInfo.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<UserInfo>> callback )
  {
    Backendless.Data.of( UserInfo.class ).find( queryBuilder, callback );
  }
}