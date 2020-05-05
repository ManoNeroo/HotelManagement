package entities;

import entities.ServiceDetail;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-05T10:54:57")
@StaticMetamodel(Service.class)
public class Service_ { 

    public static volatile SingularAttribute<Service, Integer> amount;
    public static volatile CollectionAttribute<Service, ServiceDetail> serviceDetailCollection;
    public static volatile SingularAttribute<Service, Double> price;
    public static volatile SingularAttribute<Service, String> name;
    public static volatile SingularAttribute<Service, String> id;

}