package com.example.searchlist.service;

import com.example.searchlist.dto.ReqImageSearch;
import com.example.searchlist.dto.ReqLocalSearch;
import com.example.searchlist.dto.ResImageSearch;
import com.example.searchlist.dto.ResLocalSearch;
import com.example.searchlist.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RequiredArgsConstructor
@Service
public class NaverService {
    private final BaseService service;

    @Value("${url_local}")
    private String localUrl;
    @Value("${url_image}")
    private String imageUrl;

    public ResLocalSearch searchLocal(ReqLocalSearch query) {
        URI uri = service.uriBuilder(query.toMultiValueMap(), localUrl);
        HttpHeaders headers = service.baseHeaders();

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<ResLocalSearch>() {
        };

        var response = new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, responseType);

        return response.getBody();
    }

    public ResImageSearch searchImage(ReqImageSearch query) {
        URI uri = service.uriBuilder(query.toMultiValueMap(), imageUrl);
        HttpHeaders headers = service.baseHeaders();

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<ResImageSearch>() {
        };
        var response = new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, responseType);

        return response.getBody();
    }
}
