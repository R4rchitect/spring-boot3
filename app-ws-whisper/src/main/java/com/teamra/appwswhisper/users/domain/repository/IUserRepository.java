package com.teamra.appwswhisper.users.domain.repository;
import com.teamra.appwswhisper.users.domain.model.User;

public interface IUserRepository {
    
 //   @Query(value="SELECT * FROM usuarios where id_usuario = :id_usuario", nativeQuery=true)
    User findByIdUser(Integer id);

 /*
    public abstract Cliente findByNombres(String nombres);

    @Query(value="SELECT * FROM cliente where fecha_registro between :fecha_inicio and :fecha_final", nativeQuery=true)
    public abstract List<Cliente> findByAll_Fecha(@Param("fecha_inicio") Date fecha_inicio,@Param("fecha_final") Date fecha_final);

    @Query(value= "SELECT * FROM cliente WHERE id_proveedor = :id_proveedor and fecha_registro between :fecha_inicio and :fecha_final GROUP BY comprobante ORDER BY id;", nativeQuery=true)
    public abstract List<Cliente> findById_proveedor(@Param("id_proveedor") int id_proveedor, @Param("fecha_inicio") Date fecha_inicio,@Param("fecha_final") Date fecha_final);

    @Query(value= "select * from cliente where id_empresa= :id_empresa and fecha_registro between :fecha_inicio and :fecha_final", nativeQuery=true)
    public abstract List<Cliente> findById_empresa(@Param("id_empresa") int id_empresa, @Param("fecha_inicio") Date fecha_inicio,@Param("fecha_final") Date fecha_final);*/

}
