package apiEngine.client;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class Configuration {
    private String servicePath;
    private String contentType;
//    private Map<String, String> headers;
}
