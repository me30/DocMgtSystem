package com.commons.auth.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commons.auth.model.DocumentDetails;
import com.commons.auth.model.User;
import com.commons.auth.repository.DocumentDetailsRepository;
import com.commons.auth.utility.AppConstant;

@Service
public class DocumentServiceImpl implements DocumentService{
	@Autowired
    private DocumentDetailsRepository documentDetailsRepository;
	@Override
	public void saveDocumentDetails(User user, String documenttitle, String documentshortdescription, String fileOriginalname) {
		
		DocumentDetails documentDetails = new DocumentDetails();
		documentDetails.setShortDescription(documentshortdescription);;
		documentDetails.setTitle(documenttitle);
		documentDetails.setCreatedBy(user);
		documentDetails.setCreatedDate(new Date());
		documentDetails.setState(AppConstant.STATE_NEW);
		documentDetails.setDocname(fileOriginalname);
		documentDetailsRepository.save(documentDetails);
	}
	
	@Override
	public List<DocumentDetails> findAllByUserId(User user) {
		return documentDetailsRepository.findAllByCreatedBy(user);
	}
	
	@Override
	public List<DocumentDetails> findAllNewDocument() {
		return documentDetailsRepository.findAllByState(AppConstant.STATE_NEW);
	}

	@Override
	public boolean approveDoc(long parseLong, User user) {
		DocumentDetails documentDetails = documentDetailsRepository.findOne(parseLong);
		documentDetails.setState(AppConstant.STATE_APPROVED);
		documentDetails.setApproveBy(user);
		documentDetails.setApprovedDate(new Date());
		documentDetailsRepository.save(documentDetails);
		return true;
	}

	@Override
	public boolean rejectedDoc(long parseLong, User user) {
		DocumentDetails documentDetails = documentDetailsRepository.findOne(parseLong);
		documentDetails.setState(AppConstant.STATE_REJECTED);
		documentDetails.setApproveBy(user);
		documentDetails.setApprovedDate(new Date());
		documentDetailsRepository.save(documentDetails);
		return true;
	}

	@Override
	public DocumentDetails findById(long id) {
		return documentDetailsRepository.findOne(id);
	}
	
	@Override
	public boolean docDownlaod(long parseLong, User user) {
		// TODO Auto-generated method stub
		return false;
	}
}
