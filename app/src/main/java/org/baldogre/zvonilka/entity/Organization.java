
package org.baldogre.zvonilka.entity;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

public class Organization
{
  private String objectId;
  private java.util.Date updated;
  private String Name;
  private String Description;
  private String Photo;
  private String ownerId;
  private java.util.Date created;
  private List<Client> Clients;
  private List<BackendlessUser> Users;
  public String getObjectId()
  {
    return objectId;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getName()
  {
    return Name;
  }

  public void setName( String Name )
  {
    this.Name = Name;
  }

  public String getDescription()
  {
    return Description;
  }

  public void setDescription( String Description )
  {
    this.Description = Description;
  }

  public String getPhoto()
  {
    return Photo;
  }

  public void setPhoto( String Photo )
  {
    this.Photo = Photo;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public List<Client> getClients()
  {
    return Clients;
  }

  public void setClients( List<Client> Clients )
  {
    this.Clients = Clients;
  }

  public List<BackendlessUser> getUsers()
  {
    return Users;
  }

  public void setUsers( List<BackendlessUser> Users )
  {
    this.Users = Users;
  }

                                                    
  public Organization save()
  {
    return Backendless.Data.of( Organization.class ).save( this );
  }

  public void saveAsync( AsyncCallback<Organization> callback )
  {
    Backendless.Data.of( Organization.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Organization.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Organization.class ).remove( this, callback );
  }

  public static Organization findById( String id )
  {
    return Backendless.Data.of( Organization.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<Organization> callback )
  {
    Backendless.Data.of( Organization.class ).findById( id, callback );
  }

  public static Organization findFirst()
  {
    return Backendless.Data.of( Organization.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<Organization> callback )
  {
    Backendless.Data.of( Organization.class ).findFirst( callback );
  }

  public static Organization findLast()
  {
    return Backendless.Data.of( Organization.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<Organization> callback )
  {
    Backendless.Data.of( Organization.class ).findLast( callback );
  }

  public static List<Organization> find( DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( Organization.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<Organization>> callback )
  {
    Backendless.Data.of( Organization.class ).find( queryBuilder, callback );
  }
}