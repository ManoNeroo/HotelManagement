package entities;

import entities.BookingDetail;
import entities.Floor;
import entities.RoomType;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-05T10:54:57")
@StaticMetamodel(Room.class)
public class Room_ { 

    public static volatile SingularAttribute<Room, Date> createdAt;
    public static volatile CollectionAttribute<Room, BookingDetail> bookingDetailCollection;
    public static volatile SingularAttribute<Room, String> name;
    public static volatile SingularAttribute<Room, String> id;
    public static volatile SingularAttribute<Room, Floor> floor;
    public static volatile SingularAttribute<Room, RoomType> roomType;
    public static volatile SingularAttribute<Room, Short> status;

}