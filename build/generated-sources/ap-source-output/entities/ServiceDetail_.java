package entities;

import entities.BookingDetail;
import entities.Service;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-05T10:54:57")
@StaticMetamodel(ServiceDetail.class)
public class ServiceDetail_ { 

    public static volatile SingularAttribute<ServiceDetail, Integer> amount;
    public static volatile SingularAttribute<ServiceDetail, Date> createdDate;
    public static volatile SingularAttribute<ServiceDetail, BookingDetail> bookingDetail;
    public static volatile SingularAttribute<ServiceDetail, Service> service;
    public static volatile SingularAttribute<ServiceDetail, Integer> id;

}