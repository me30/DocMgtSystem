package com.commons.auth.web.model;

import java.util.Date;

import com.commons.auth.model.DocumentDetails;


public class DocumentDetailsGrid {
	private Long id;
	private String title;
	private String shortDescription;
	private String docname;
	private String state;
	private Long approveById;
	private String approveByName;
	private Date approvedDate;
	private Long createdById;
	private String createdByName;
	private Date createdDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getApproveById() {
		return approveById;
	}
	public void setApproveById(Long approveById) {
		this.approveById = approveById;
	}
	public String getApproveByName() {
		return approveByName;
	}
	public void setApproveByName(String approveByName) {
		this.approveByName = approveByName;
	}
	public Date getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
	public Long getCreatedById() {
		return createdById;
	}
	public void setCreatedById(Long createdById) {
		this.createdById = createdById;
	}
	public String getCreatedByName() {
		return createdByName;
	}
	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public void entityToBean(DocumentDetails documentDetails, DocumentDetailsGrid documentDetailsGrid){
		documentDetailsGrid.setId(documentDetails.getId());
		documentDetailsGrid.setTitle(documentDetails.getTitle());
		documentDetailsGrid.setShortDescription(documentDetails.getShortDescription());
		documentDetailsGrid.setState(documentDetails.getState());
		documentDetailsGrid.setDocname(documentDetails.getDocname());
		
		if(null != documentDetails.getApproveBy()){
			documentDetailsGrid.setApproveById(documentDetails.getApproveBy().getId());
			documentDetailsGrid.setApproveByName(documentDetails.getApproveBy().getUsername());
			documentDetailsGrid.setApprovedDate(documentDetails.getApprovedDate());
		}
		
		
		documentDetailsGrid.setCreatedById(documentDetails.getCreatedBy().getId());
		documentDetailsGrid.setCreatedByName(documentDetails.getCreatedBy().getUsername());
		documentDetailsGrid.setCreatedDate(documentDetails.getCreatedDate());
	}
}
