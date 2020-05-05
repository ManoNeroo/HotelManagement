package entities;

import entities.Booking;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-05T10:54:57")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, Date> birthday;
    public static volatile SingularAttribute<Customer, Date> createdAt;
    public static volatile SingularAttribute<Customer, Short> gender;
    public static volatile SingularAttribute<Customer, String> identityCardNumber;
    public static volatile SingularAttribute<Customer, String> phone;
    public static volatile SingularAttribute<Customer, String> name;
    public static volatile SingularAttribute<Customer, String> id;
    public static volatile CollectionAttribute<Customer, Booking> bookingCollection;
    public static volatile SingularAttribute<Customer, String> email;

}