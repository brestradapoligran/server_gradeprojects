package com.grade.project.domain.model;

import com.grade.project.domain.enums.object.ObjectTypeEnum;

import java.util.List;

public class FiltersObjectModel {

    private String searchWord;
    private List<ObjectTypeEnum> objectTypes;

    public FiltersObjectModel() {
    }

    public FiltersObjectModel(String searchWord, List<ObjectTypeEnum> objectTypes) {
        this.searchWord = searchWord;
        this.objectTypes = objectTypes;
    }

    public FiltersObjectModel(List<ObjectTypeEnum> objectTypes) {
        this.objectTypes = objectTypes;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public List<ObjectTypeEnum> getObjectTypes() {
        return objectTypes;
    }

    public void setObjectTypes(List<ObjectTypeEnum> objectTypes) {
        this.objectTypes = objectTypes;
    }
}
