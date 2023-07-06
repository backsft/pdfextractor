package com.WorkingPDF.HomeController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PDFController {

	
	@Value("${django.api.url}")
    private String djangoApiUrl;
	
	
	//calling django api 

    @PostMapping("/callpython")
    public ResponseEntity<String> callPythonAPI(@RequestParam("file") MultipartFile file) {
        try {
            // Create the multi-part request body
            MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
            requestBody.add("file", new ByteArrayResource(file.getBytes()) {
                @Override
                public String getFilename() {
                    return file.getOriginalFilename();
                }
            });

            // Create headers with Content-Type as multipart/form-data
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            // Create the request entity with the body and headers
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

            // Create a RestTemplate to make the POST request
            RestTemplate restTemplate = new RestTemplate();

            // Send the POST request to the Django API
            ResponseEntity<String> response = restTemplate.exchange(
                    djangoApiUrl,
                    HttpMethod.POST,
                    requestEntity,
                    String.class
            );

            // Return the response from the Django API
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to call the Python API");
        }
    }

    
    @GetMapping("/testpythonhello")
    public ResponseEntity<String> testPythonHello() {
        String djangoApiUrl = "http://127.0.0.1:8000/hello/";

        RestTemplate restTemplate = new RestTemplate();

        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the request entity with headers
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        // Send GET request to Django API
        ResponseEntity<String> response = restTemplate.exchange(
                djangoApiUrl,
                HttpMethod.GET,
                requestEntity,
                String.class
        );

        // Return the response from the Django API
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
