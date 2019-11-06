package com.abc.businesslayer;

import com.abc.dto.Item;
import com.abc.dto.ResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusinessLogic {

    /**
     * Problem 1: Write a function to capture the status vise distribution of documents.
     * The function should return appropriate data structure which will help to identify
     * how many documents belong to each status.
     *
     * @param itemsList
     * @return getStatusViseDocuments
     */
    private Map<String, List<Item>> getDocumentsByStatus(List<Item> itemsList) {

        List<Item> list;
        Map<String, List<Item>> getStatusViseDocuments = new HashMap<>();

        for (Item items : itemsList) {
            if (getStatusViseDocuments.containsKey(items.getStatus())) {
                list = getStatusViseDocuments.get(items.getStatus());
                list.add(items);
                getStatusViseDocuments.replace(items.getStatus(), list);
            } else {
                list = new ArrayList<>();
                list.add(items);
                getStatusViseDocuments.put(items.getStatus(), list);
            }
        }
        return getStatusViseDocuments;
    }

    /**
     * Problem 2: Use the function written as part of Problem 1, and write a function
     * that accepts status as an argument and returns all the documents details
     * (document_id, collection_id, file_name, created_date, revision_number) belonging to that status.
     *
     * @param itemsList
     * @param status
     * @return getAllDocumentsRelatedToStatus
     */
    private Map<String, List<Item>> getDocumentsRelatedToStatus(List<Item> itemsList, String status) {

        Map<String, List<Item>> allDocuments = getDocumentsByStatus(itemsList);
        Map<String, List<Item>> getAllDocumentsRelatedToStatus = new HashMap<>();

        if (allDocuments.containsKey(status)) {
            List<Item> list = allDocuments.get(status);
            getAllDocumentsRelatedToStatus.put(status, list);
        }
        return getAllDocumentsRelatedToStatus;
    }

    /**
     * Problem 3: Write a function that accepts file_name as an argument and returns
     * all the documents details (document_id, collection_id, status, created_date, revision_number)
     * belonging to that file_name.
     *
     * @param itemsList
     * @param fileName
     * @return getDocumentsRelatedToFileName
     */
    private Map<String, List<Item>> getDocumentsRelatedToFileName(List<Item> itemsList, String fileName) {

        Map<String, List<Item>> getDocumentsRelatedToFileName = new HashMap<>();
        List<Item> list = new ArrayList<>();

        for (Item items : itemsList) {
            if (items.getFile_name().equalsIgnoreCase(fileName)) {
                list.add(items);
            }
        }
        getDocumentsRelatedToFileName.put(fileName, list);
        return getDocumentsRelatedToFileName;
    }

    public static void main(String[] args) throws Exception {

        // parsing file "Response.json"
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader("src/main/resources/body/response.json"));

        //Converting to ResponseDTO
        ObjectMapper ob = new ObjectMapper();
        ResponseDTO rs = ob.convertValue(jsonObject, ResponseDTO.class);

        //Fetching list of Items
        List<Item> itemsList = rs.getPayload().getItems();

//        BusinessLogic businessLogic = new BusinessLogic();
//
//        // Get status vise documents
//        Map<String, List<Item>> items = businessLogic.getDocumentsByStatus(itemsList);
//        for (Map.Entry<String, List<Item>> entry : items.entrySet()) {
//
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue().size());
//        }
//
//        // Get all the documents that are related to a status
//        Map<String, List<Item>> items1 = businessLogic.getDocumentsRelatedToStatus(itemsList, "DONE");
//        for (Map.Entry<String, List<Item>> entry : items1.entrySet()) {
//
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue().size());
//        }
//
//        // Get all the documents that are related to a filename
//        Map<String, List<Item>> items2 = businessLogic.getDocumentsRelatedToFileName(itemsList, "83.pdf");
//        for (Map.Entry<String, List<Item>> entry : items2.entrySet()) {
//
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue().size());
//        }
    }
}
