package com.commons.auth.utility;

public class AppConstant {

	public static long ADMIN_ID =1;
	public static String ADMIN_NAME = "ADMIN";
	
	public static long DOCUMENT_USER_ID =2;
	public static String DOCUMENT_USER_NAME = "DOCUMENT_USER";
	
	//Save the uploaded file to this folder
    public static String UPLOADED_FOLDER = "/home/minesh/Downloads/";
    
    /*
     * DOCUMENT STATE
     */
    public static String STATE_NEW = "New";
    public static String STATE_APPROVED = "Approved";
    public static String STATE_REJECTED = "Rejected";
    
    public static String EMAIL_SUBJECT_UPLOAD_DOC = "Uploaded New Document By - ";
    public static String EMAIL_TEXT_UPLOAD_DOC = " has uploaded New Document with title \"";
    
    public static String EMAIL_SUBJECT_APPROVE_DOC = " Uploaded Document Approved By - ";
    public static String EMAIL_SUBJECT_REJECTED_DOC = " Uploaded Document Rejected By - ";
    
    public static String EMAIL_TEXT_APPROVE_DOC = " has approved Document with title \"";
    public static String EMAIL_TEXT_REJECTED_DOC = " has rejected Document with title \"";
    
}
