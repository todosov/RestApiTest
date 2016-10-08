package com.restapp.controller;

import com.restapp.services.DataService;
import com.restapp.services.FileHandler;
import lombok.Data;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.jboss.resteasy.util.Base64;

import javax.inject.Inject;
import javax.ws.rs.*;
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
    private FileHandler fileHandler;

    @Inject
    private DataService dataService;

    @Path("/upload")
    @POST
    @Consumes({"multipart/form-data"})
    public Response uploadFiles(MultipartFormDataInput input){
        List<InputPart> inputParts = input.getFormDataMap().get("files");
        if (inputParts == null)
            return Response.status(Response.Status.BAD_REQUEST).build();
        inputParts.stream().forEach(inputPart -> {
            try {
                fileHandler.fileProcessor(inputPart);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return Response.ok().build();
    }

    @Path("/result")
    @GET
    @Produces("application/json")
    public Response test(){
        return Response.ok(dataService.getStringCounts()).build();
    }

}
