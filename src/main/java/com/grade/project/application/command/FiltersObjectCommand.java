package com.grade.project.application.command;

import com.grade.project.domain.enums.ObjectTypeEnum;

import java.util.List;

public class FiltersObjectCommand {

    private String searchWord;
    private List<ObjectTypeEnum> objectTypes;

    public FiltersObjectCommand() {
    }

    public FiltersObjectCommand(String searchWord, List<ObjectTypeEnum> objectTypes) {
        this.searchWord = searchWord;
        this.objectTypes = objectTypes;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public List<ObjectTypeEnum> getObjectTypes(){
        return objectTypes;
    }
}
