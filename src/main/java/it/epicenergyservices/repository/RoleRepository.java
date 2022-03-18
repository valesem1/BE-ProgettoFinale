package it.epicenergyservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicenergyservices.model.ERole;
import it.epicenergyservices.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByRoleName(ERole role);

}
