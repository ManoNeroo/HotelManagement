package entities;

import entities.Room;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-05T10:54:57")
@StaticMetamodel(RoomType.class)
public class RoomType_ { 

    public static volatile SingularAttribute<RoomType, Double> price;
    public static volatile SingularAttribute<RoomType, String> name;
    public static volatile CollectionAttribute<RoomType, Room> roomCollection;
    public static volatile SingularAttribute<RoomType, Integer> id;

}