package com.example.searchlist.service;

import com.example.searchlist.client.NaverClient;
import com.example.searchlist.dto.ReqImageSearch;
import com.example.searchlist.dto.ReqLocalSearch;
import com.example.searchlist.dto.WishListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NaverService {
    private final NaverClient client;

    public WishListDto search(String query) {
        var localReq = new ReqLocalSearch();
        localReq.setQuery(query);
        var localRes = client.searchLocal(localReq);

        if (localRes.getTotal() > 0) { //검색 결과가 있는 경우
            var localItem = localRes.getItems().stream().findFirst().get();
            var imgQuery = localItem.getTitle().replaceAll("<[^>]*>", ""); // 문자열 제거 정규식
            var imgReq = new ReqImageSearch();

            imgReq.setQuery(imgQuery);

            var imgRes = client.searchImage(imgReq);

            if (imgRes.getTotal() > 0) {//검색 결과중에 이미지가 있는 경우
                var imgItem = imgRes.getItems().stream().findFirst().get();
                var result = new WishListDto();
                result.setTitle(localItem.getTitle());
                result.setCategory(localItem.getCategory());
                result.setAddress(localItem.getAddress());
                result.setReadAddress(localItem.getRoadAddress());
                result.setHomePageLink(localItem.getLink());
                result.setImgLink(imgItem.getLink());

                return result;
            }
        }
        return new WishListDto();
    }
}
