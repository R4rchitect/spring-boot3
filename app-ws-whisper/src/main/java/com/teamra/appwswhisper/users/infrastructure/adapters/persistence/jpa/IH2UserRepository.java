package com.teamra.appwswhisper.users.infrastructure.adapters.persistence.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IH2UserRepository extends CrudRepository<UserEntity, Integer>{
    
    @Query(value="SELECT * FROM usuarios where id_usuario = :id_usuario", nativeQuery=true)
    Optional<UserEntity> findById(@Param("id_usuario") Integer id);

}
