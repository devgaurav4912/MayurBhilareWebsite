package com.backend.MayurBhilareBackend.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.MayurBhilareBackend.Entity.SectionMaster;


@Repository
public interface SectionMasterRepository extends JpaRepository<SectionMaster,Long>{

	
	Optional<SectionMaster> findByName(String name);

}
