package com.commons.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commons.auth.model.DocumentDetails;
import com.commons.auth.model.User;

public interface DocumentDetailsRepository extends JpaRepository<DocumentDetails, Long>{

	List<DocumentDetails> findAllByCreatedBy(User user);

	List<DocumentDetails> findAllByState(String state);

}
