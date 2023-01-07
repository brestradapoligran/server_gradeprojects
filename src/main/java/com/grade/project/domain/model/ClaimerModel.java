package com.grade.project.domain.model;

import com.grade.project.domain.enums.user.DocumentTypeEnum;
import com.grade.project.domain.enums.user.UserTypeEnum;

public class ClaimerModel {
    private String name;
    private String lastName;
    private String document;
    private String contact;
    private DocumentTypeEnum documentType;
    private UserTypeEnum userType;

    public ClaimerModel() {
    }

    public ClaimerModel(String name, String lastName, String document, String contact, DocumentTypeEnum documentType, UserTypeEnum userType) {
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.contact = contact;
        this.documentType = documentType;
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public DocumentTypeEnum getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentTypeEnum documentType) {
        this.documentType = documentType;
    }

    public UserTypeEnum getUserType() {
        return userType;
    }

    public void setUserType(UserTypeEnum userType) {
        this.userType = userType;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
