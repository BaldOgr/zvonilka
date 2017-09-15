
package org.baldogre.zvonilka.entity;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

public class ToDo
{
  private String objectId;
  private String ownerId;
  private Integer Status;
  private java.util.Date ToDoDate;
  private String Description;
  private java.util.Date created;
  private java.util.Date updated;
  public String getObjectId()
  {
    return objectId;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public Integer getStatus()
  {
    return Status;
  }

  public void setStatus( Integer Status )
  {
    this.Status = Status;
  }

  public java.util.Date getToDoDate()
  {
    return ToDoDate;
  }

  public void setToDoDate( java.util.Date ToDoDate )
  {
    this.ToDoDate = ToDoDate;
  }

  public String getDescription()
  {
    return Description;
  }

  public void setDescription( String Description )
  {
    this.Description = Description;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

                                                    
  public ToDo save()
  {
    return Backendless.Data.of( ToDo.class ).save( this );
  }

  public void saveAsync( AsyncCallback<ToDo> callback )
  {
    Backendless.Data.of( ToDo.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( ToDo.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( ToDo.class ).remove( this, callback );
  }

  public static ToDo findById( String id )
  {
    return Backendless.Data.of( ToDo.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<ToDo> callback )
  {
    Backendless.Data.of( ToDo.class ).findById( id, callback );
  }

  public static ToDo findFirst()
  {
    return Backendless.Data.of( ToDo.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<ToDo> callback )
  {
    Backendless.Data.of( ToDo.class ).findFirst( callback );
  }

  public static ToDo findLast()
  {
    return Backendless.Data.of( ToDo.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<ToDo> callback )
  {
    Backendless.Data.of( ToDo.class ).findLast( callback );
  }

  public static List<ToDo> find( DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( ToDo.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<ToDo>> callback )
  {
    Backendless.Data.of( ToDo.class ).find( queryBuilder, callback );
  }
}