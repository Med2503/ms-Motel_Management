package com.att.Book;

import com.att.exception.ErrorException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class RoomClient {

    @Value("${application.config.room-url}")
    private String roomUrl;

    private final RestTemplate restTemplate;

    public RoomClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<RoomBookedResponse> bookRooms(List<RoomBookedRequest> request) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<List<RoomBookedRequest>> requestEntity = new HttpEntity<>(request, headers);

        ParameterizedTypeReference<List<RoomBookedResponse>> responseType = new ParameterizedTypeReference<List<RoomBookedResponse>>() {
        };

        ResponseEntity<List<RoomBookedResponse>> responseEntity = restTemplate.exchange(
                roomUrl + "/book",
                HttpMethod.POST,
                requestEntity,
                responseType
        );

        if (responseEntity.getStatusCode().isError()) {
            throw new ErrorException("can't proceed the operation");
        }

        return responseEntity.getBody();

    }
}
