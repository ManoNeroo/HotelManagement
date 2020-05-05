package entities;

import entities.Booking;
import entities.Room;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-05T10:54:57")
@StaticMetamodel(BookingDetail.class)
public class BookingDetail_ { 

    public static volatile SingularAttribute<BookingDetail, Date> createdAt;
    public static volatile SingularAttribute<BookingDetail, Booking> booking;
    public static volatile SingularAttribute<BookingDetail, Double> servicePrice;
    public static volatile SingularAttribute<BookingDetail, Integer> id;
    public static volatile SingularAttribute<BookingDetail, Room> room;

}