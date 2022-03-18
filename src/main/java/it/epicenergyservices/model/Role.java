package it.epicenergyservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "role")
public class Role {
	
	
	

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;public Role(ERole roleName) {
	super();
	this.roleName = roleName;
}

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private ERole roleName;
    
    
    
}
