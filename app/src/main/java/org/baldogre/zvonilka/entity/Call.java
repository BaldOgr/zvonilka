
package org.baldogre.zvonilka.entity;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

public class Call
{
  private java.util.Date updated;
  private String objectId;
  private String ownerId;
  private String Reason;
  private String Result;
  private java.util.Date CallDate;
  private java.util.Date created;
  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getReason()
  {
    return Reason;
  }

  public void setReason( String Reason )
  {
    this.Reason = Reason;
  }

  public String getResult()
  {
    return Result;
  }

  public void setResult( String Result )
  {
    this.Result = Result;
  }

  public java.util.Date getCallDate()
  {
    return CallDate;
  }

  public void setCallDate( java.util.Date CallDate )
  {
    this.CallDate = CallDate;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

                                                    
  public Call save()
  {
    return Backendless.Data.of( Call.class ).save( this );
  }

  public void saveAsync( AsyncCallback<Call> callback )
  {
    Backendless.Data.of( Call.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Call.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Call.class ).remove( this, callback );
  }

  public static Call findById( String id )
  {
    return Backendless.Data.of( Call.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<Call> callback )
  {
    Backendless.Data.of( Call.class ).findById( id, callback );
  }

  public static Call findFirst()
  {
    return Backendless.Data.of( Call.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<Call> callback )
  {
    Backendless.Data.of( Call.class ).findFirst( callback );
  }

  public static Call findLast()
  {
    return Backendless.Data.of( Call.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<Call> callback )
  {
    Backendless.Data.of( Call.class ).findLast( callback );
  }

  public static List<Call> find( DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( Call.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<Call>> callback )
  {
    Backendless.Data.of( Call.class ).find( queryBuilder, callback );
  }
}