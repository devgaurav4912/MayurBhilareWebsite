package com.backend.MayurBhilareBackend.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.backend.MayurBhilareBackend.Entity.SectionMaster;


public interface SectionMasterService {

	public SectionMaster addSection(SectionMaster section);

	public List<SectionMaster> getSection();
	
	

	public Optional<SectionMaster> getSectionById(Long sectionId);

	public ResponseEntity<?> deleteSection(long sectionId);

	public SectionMaster updateSection(long sectionId, SectionMaster master);


}
