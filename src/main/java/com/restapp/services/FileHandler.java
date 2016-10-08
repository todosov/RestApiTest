package com.restapp.services;

import com.restapp.entity.File;
import com.restapp.entity.Row;
import org.apache.commons.codec.digest.DigestUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tadasyan
 */
public class FileHandler {

    @Inject
    private DataService dataService;

    public void fileProcessor(InputPart inputPart) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputPart.getBody(InputStream.class, null)));
        String line;
        List<Row> rows = new LinkedList<>();
        while ((line = bufferedReader.readLine()) != null){
            Row row = Row.builder()
                    .id(DigestUtils.md5(line))
                    .content(line)
                    .build();
            rows.add(row);
        }
        String fileName = "";
        String[] contentDispositionHeader = inputPart.getHeaders().getFirst("Content-Disposition").split(";");
        for (String name : contentDispositionHeader){
            if (name.trim().startsWith("filename")){
                String[] tmp = name.split("=");
                fileName = tmp[1].trim().replaceAll("\"","");
            }
        }
        File file = File.builder()
                .name(fileName)
                .rows(rows)
                .build();
        dataService.addFile(file);
    }
}
