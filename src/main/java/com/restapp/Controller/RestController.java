package com.restapp.Controller;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

/**
 * Created by tadasyan
 */
@Path("/api")
public class RestController {

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
        return Response.ok().build();
    }

    @Path("/test")
    @GET
    @Consumes("text/html")
    public String test(){
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\">\n" +
                "<meta http-equiv=\"content-type\" content=\"application/json\">\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<form action=\"http://booking.uz.gov.ua/purchase/search/\" method=\"post\">\n" +
                "  station_id_from:<br>\n" +
                "  <input type=\"text\" name=\"station_id_from\" >\n" +
                "  <br>\n" +
                "  station_id_till:<br>\n" +
                "  <input type=\"text\" name=\"station_id_till\" >\n" +
                "  <br>\n" +
                "  station_from:<br>\n" +
                "  <input type=\"text\" name=\"station_from\" ><br>\n" +
                "  station_till:<br>\n" +
                "  <input type=\"text\" name=\"station_till\" ><br>\n" +
                "  date_dep:<br>\n" +
                "  <input type=\"text\" name=\"date_dep\" ><br>\n" +
                "  time_dep:<br>\n" +
                "  <input type=\"text\" name=\"time_dep\" ><br>\n" +
                "  time_dep_till:<br>\n" +
                "  <input type=\"text\" name=\"time_dep_till\" ><br>\n" +
                "  another_ec:<br>\n" +
                "  <input type=\"text\" name=\"another_ec\" ><br>\n" +
                "  search:<br>\n" +
                "  <input type=\"text\" name=\"search\" ><br>\n" +
                "  <br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }
}
