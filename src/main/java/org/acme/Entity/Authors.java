package org.acme.Entity;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity
public class Authors extends PanacheEntity{
		public String first_name;
		public String last_name;
}
