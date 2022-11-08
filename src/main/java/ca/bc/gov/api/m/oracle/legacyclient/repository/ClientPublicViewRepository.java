package ca.bc.gov.api.m.oracle.legacyclient.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ca.bc.gov.api.core.repository.CoreRepository;
import ca.bc.gov.api.m.oracle.legacyclient.entity.ClientPublicViewEntity;

@Repository
public interface ClientPublicViewRepository extends CoreRepository<ClientPublicViewEntity> {
	
	@Query("select x from ClientPublicViewEntity x " +
	       "where x.clientNumber = :clientNumber")
	ClientPublicViewEntity findByClientNumber(@Param("clientNumber") String clientNumber);

}
