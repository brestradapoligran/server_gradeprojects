package com.grade.project.application.command;

import com.grade.project.domain.enums.object.ObjectStatusEnum;
import com.grade.project.domain.enums.object.ObjectTypeEnum;

import java.util.List;

public class FiltersObjectCommand {

    private String searchWord;
    private List<ObjectTypeEnum> objectTypes;
    private List<ObjectStatusEnum> objectStatuses;

    public FiltersObjectCommand() {
    }

    public FiltersObjectCommand(String searchWord, List<ObjectTypeEnum> objectTypes, List<ObjectStatusEnum> objectStatuses) {
        this.searchWord = searchWord;
        this.objectTypes = objectTypes;
        this.objectStatuses = objectStatuses;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public List<ObjectTypeEnum> getObjectTypes(){
        return objectTypes;
    }

    public List<ObjectStatusEnum> getObjectStatuses() {
        return objectStatuses;
    }
}
