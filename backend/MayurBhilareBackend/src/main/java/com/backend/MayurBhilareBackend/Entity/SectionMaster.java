package com.backend.MayurBhilareBackend.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class SectionMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long sectionId;
	String name;
	LocalDate createdOn;


	@OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ContentMaster> contentMasterList;

	public long getSectionId() {
		return sectionId;
	}

	public void setSectionId(long sectionId) {
		this.sectionId = sectionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate localDate) {
		this.createdOn = localDate;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public List<ContentMaster> getContentMasterList() {
		return contentMasterList;
	}

	public void setContentMasterList(List<ContentMaster> contentMasterList) {
		this.contentMasterList = contentMasterList;
	}

	@Override
	public String toString() {
		return "SectionMaster{" +
				"sectionId=" + sectionId +
				", name='" + name + '\'' +
				", createdOn=" + createdOn +
				'}';
	}
}
