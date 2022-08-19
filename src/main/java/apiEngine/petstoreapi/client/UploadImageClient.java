package apiEngine.petstoreapi.client;

import io.restassured.response.Response;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadImageClient extends BaseClientPetStore {
    public final String UPLOAD_IMAGE_ENDPOINT = "/v2/pet/%s/uploadImage";


    public Response uploadImage(String userId) {
        String workingDir = System.getProperty("user.dir");
        Path path = Paths.get(workingDir, "src", "main", "resources");
        request
                .contentType("multipart/form-data")
                .multiPart("file", new File(path + "\\osdbScreen.png"));
        return post("", String.format(UPLOAD_IMAGE_ENDPOINT, userId));
    }

}
