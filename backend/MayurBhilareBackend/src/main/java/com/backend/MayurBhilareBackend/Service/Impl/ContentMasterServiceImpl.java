package com.backend.MayurBhilareBackend.Service.Impl;
import com.backend.MayurBhilareBackend.Entity.ContentMaster;
import com.backend.MayurBhilareBackend.Entity.SectionMaster;
import com.backend.MayurBhilareBackend.Repository.ContentMasterRepository;
import com.backend.MayurBhilareBackend.Repository.SectionMasterRepository;
import com.backend.MayurBhilareBackend.Service.ContentMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class ContentMasterServiceImpl implements ContentMasterService {
	
	@Autowired
    ContentMasterRepository contentMasterRepository;
	
	@Autowired
    SectionMasterRepository sectionMasterRepositiry;
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/images/content";


    @Override
    public List<ContentMaster> getAllContents() {
        return contentMasterRepository.findAll();
    }


    @Override
    public Optional<ContentMaster> getContentById(Long contentId) {
        return contentMasterRepository.findById(contentId);
    }


	

	@Override
	public void deleteById(Long contentId) {
		 contentMasterRepository.deleteById(contentId);;
	}


	@Override
	public List<Map<String, Object>> getSelectedContainFields() {
		return contentMasterRepository.getSelectedContainFields();
	}



//    public  ResponseEntity<String> addContent (ContentMaster contentMaster , MultipartFile file) throws IOException {
//
//        SectionMaster sectionMaster =sectionMasterRepositiry.findByName(contentMaster.getSection().getName()).orElse(null);
//
//
//        if (file != null && !file.isEmpty()) {
//			// Get the current date and time
//			LocalDateTime now = LocalDateTime.now();
//
//			// Define the format you want for the file name (e.g., yyyyMMdd_HHmmss)
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
//
//			// Generate a unique file name with the current date and time
//			String currentTime = now.format(formatter);
//
//			// Get the file extension
//			String originalFileName = file.getOriginalFilename();
//			String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
//
//			// Construct the new file name with date-time as name and retain the file
//			// extension
//			String newFileName = currentTime + fileExtension;
//
//			// Save the file with the new name
//			Path fileNameAndPath = Paths.get(uploadDirectory, newFileName);
//			Files.write(fileNameAndPath, file.getBytes());
//
//			// Set the new file name in customerMaster object
//			contentMaster.setContentImage(newFileName);
//			}
//
//    	if (contentMaster.getContentDate() == null) {
//            contentMaster.setContentDate(LocalDate.now()); // Set current date if not provided
//        }
//        contentMaster.setSection(sectionMaster);
//        contentMasterRepository.save(contentMaster);
//
//        return new ResponseEntity<>("Content save successfully", HttpStatus.OK);
//    }

	@Override
	public ResponseEntity<?> addContent(ContentMaster contentmaster, MultipartFile file) throws IOException {
		// TODO Auto-generated method stub

        System.out.println("ADD CONTENT--1");

        System.out.println("SECTION ID -->"+contentmaster.getSection().getSectionId());

        SectionMaster section = sectionMasterRepositiry.findById(contentmaster.getSection().getSectionId())
                .orElseThrow(() -> new RuntimeException("Section not found"));

        System.out.println("ADD CONTENT--2");

		 Set<String> allContenetSet= contentMasterRepository.findAllContentBasedOnSection(contentmaster.getSection().getName());

        System.out.println("ADD CONTENT--3");
		if(allContenetSet.contains(contentmaster.getContentTitle()))
		{
			return new ResponseEntity<>("This content already exists!!!", HttpStatus.BAD_REQUEST);
		}

        System.out.println("ADD CONTENT--4");
		// Save file if provided
    	if (file != null && !file.isEmpty()) {
			// Get the current date and time
			LocalDateTime now = LocalDateTime.now();

			// Define the format you want for the file name (e.g., yyyyMMdd_HHmmss)
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

			// Generate a unique file name with the current date and time
			String currentTime = now.format(formatter);

			// Get the file extension
			String originalFileName = file.getOriginalFilename();
			String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));

			// Construct the new file name with date-time as name and retain the file
			// extension
			String newFileName = currentTime + fileExtension;

			// Save the file with the new name
			Path fileNameAndPath = Paths.get(uploadDirectory, newFileName);
			Files.write(fileNameAndPath, file.getBytes());

			// Set the new file name in customerMaster object
			contentmaster.setContentImage(newFileName);
			}

    	if (contentmaster.getContentDate() == null) {
            contentmaster.setContentDate(LocalDate.now()); // Set current date if not provided
        }

        contentmaster.setSection(section);
        // Save the ContentMaster entity
        ContentMaster savedContentMaster1 = contentMasterRepository.save(contentmaster);

        return new ResponseEntity<>(savedContentMaster1, HttpStatus.OK);

	}


	@Override
	public ResponseEntity<?> updateContent(Long contentId, ContentMaster contentMaster,
			MultipartFile file) throws IOException {
		 // Fetch the existing content
        Optional<ContentMaster> optionalContentMaster = getContentById(contentId);
        if (!optionalContentMaster.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ContentMaster existingContentMaster = optionalContentMaster.get();
        Set<String> allContenetSet= contentMasterRepository.findAllContentBasedOnSection(contentMaster.getSection().getName());
		if(allContenetSet.contains(contentMaster.getContentTitle()))
		{
			return new ResponseEntity<>("This content already exists!!!", HttpStatus.BAD_REQUEST);
		}
     

        // Update the existing content with new values
        existingContentMaster.setContentTitle(contentMaster.getContentTitle());
        existingContentMaster.setContentPrice(contentMaster.getContentPrice());
        existingContentMaster.setContentSequence(contentMaster.getContentSequence());
        existingContentMaster.setContentDescription(contentMaster.getContentDescription());
        //existingContentMaster.setContentDate(contentMaster.getContentDate());
        if (contentMaster.getContentDate() == null) {
            existingContentMaster.setContentDate(LocalDate.now());
        }
        existingContentMaster.setContentLocation(contentMaster.getContentLocation());
        existingContentMaster.setContentLink(contentMaster.getContentLink());
        existingContentMaster.setContentImgAltTag(contentMaster.getContentImgAltTag());
        existingContentMaster.setSection(contentMaster.getSection());


        if (file != null && !file.isEmpty()) {
            // Get the current date and time
            LocalDateTime now = LocalDateTime.now();

            // Define the format for the file name (e.g., yyyyMMdd_HHmmss)
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

            // Generate a unique file name with the current date and time
            String currentTime = now.format(formatter);

            // Get the file extension
            String originalFileName = file.getOriginalFilename();
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));

            // Construct the new file name with date-time as name and retain the file extension
            String newFileName = currentTime + fileExtension;

            // Save the file with the new name
            Path fileNameAndPath = Paths.get(uploadDirectory, newFileName);
            Files.write(fileNameAndPath, file.getBytes());

            // Set the new file name in the existingContentMaster object
            existingContentMaster.setContentImage(newFileName);
        }



        // Save the updated content using the service layer
        ContentMaster savedContentMaster = contentMasterRepository.save(existingContentMaster);
        return new ResponseEntity<>(savedContentMaster, HttpStatus.OK);
	}



}
