package com.abc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

    private String document_id;
    private String collection_id;
    private String status;
    private String file_name;
    private String created_date;
    private String revision_number;

    @Override
    public String toString() {
        return "ClassPojo [document_id = " + document_id + ", collection_id = " + collection_id + ", status = " + status + ", file_name = " + file_name + ", created_date = " + created_date + ", revision_number = " + revision_number + "]";
    }
}
