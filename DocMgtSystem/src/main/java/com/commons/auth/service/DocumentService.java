package com.commons.auth.service;

import java.util.List;

import com.commons.auth.model.DocumentDetails;
import com.commons.auth.model.User;


public interface DocumentService {
	void saveDocumentDetails(User user, String documenttitle, String documentshortdescription, String fileOriginalname);
	
	List<DocumentDetails> findAllByUserId(User user);
	
	List<DocumentDetails> findAllNewDocument();

	boolean approveDoc(long parseLong, User user);

	boolean rejectedDoc(long parseLong, User user);

	boolean docDownlaod(long parseLong, User user);
	
	DocumentDetails findById(long id);
}
