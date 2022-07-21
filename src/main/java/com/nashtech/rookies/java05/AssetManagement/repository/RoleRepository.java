package com.nashtech.rookies.java05.AssetManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nashtech.rookies.java05.AssetManagement.Model.Entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

}
