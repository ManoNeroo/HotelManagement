package entities;

import entities.Booking;
import entities.Rights;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-05T10:54:57")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Rights> rights;
    public static volatile SingularAttribute<User, String> fullName;
    public static volatile SingularAttribute<User, String> id;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile CollectionAttribute<User, Booking> bookingCollection;

}