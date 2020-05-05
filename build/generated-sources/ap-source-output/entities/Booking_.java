package entities;

import entities.BookingDetail;
import entities.Customer;
import entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-05T10:54:57")
@StaticMetamodel(Booking.class)
public class Booking_ { 

    public static volatile SingularAttribute<Booking, Date> createdAt;
    public static volatile SingularAttribute<Booking, Date> checkin;
    public static volatile CollectionAttribute<Booking, BookingDetail> bookingDetailCollection;
    public static volatile SingularAttribute<Booking, String> id;
    public static volatile SingularAttribute<Booking, Date> checkout;
    public static volatile SingularAttribute<Booking, User> user;
    public static volatile SingularAttribute<Booking, Short> status;
    public static volatile SingularAttribute<Booking, Customer> customer;

}