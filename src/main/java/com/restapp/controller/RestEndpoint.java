package com.restapp.controller;

import com.restapp.services.DataService;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.jboss.resteasy.util.Base64;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by tadasyan
 */
@Path("/api")
public class RestEndpoint {

    @Inject
    private DataService dataService;

    @Path("/upload")
    @POST
    @Consumes({"multipart/form-data"})
    public Response uploadFiles(MultipartFormDataInput input){
//        Map<String, List<InputPart>> uploadFiles;
//        if (input != null)
//            uploadFiles = input.getFormDataMap();
        List<InputPart> inputParts = input.getFormDataMap().get("files");
        if (inputParts == null)
            return Response.status(Response.Status.BAD_REQUEST).build();
//        inputParts.stream().forEach(inputPart -> {
//
//        });
        return Response.ok().build();
    }

    @Path("/test")
    @GET
    @Consumes("text/html")
    public Response test(){

        return Response.ok().build();
    }

    private String getFileName(InputPart inputPart){
        String[] contentDispositionHeader = inputPart.getHeaders().getFirst("Content-Disposition").split(";");
        for (String name : contentDispositionHeader){
            if (name.trim().startsWith("filename")){
                String[] tmp = name.split("=");
                return tmp[1].trim().replaceAll("\"","");
            }
        }
        return "";
    }

    private void getFileBody(InputPart inputPart) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputPart.getBody(InputStream.class, null)));
        String line;
        while ((line = bufferedReader.readLine()) != null){

        }
    }
}
