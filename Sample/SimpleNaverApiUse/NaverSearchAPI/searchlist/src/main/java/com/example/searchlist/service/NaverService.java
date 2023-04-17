package com.example.searchlist.service;

import com.example.searchlist.client.NaverClient;
import com.example.searchlist.dto.ReqImageSearch;
import com.example.searchlist.dto.ReqLocalSearch;
import com.example.searchlist.dto.WishListDto;
import com.example.searchlist.wishlist.WishListRepository;
import com.example.searchlist.wishlist.entity.WishListEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class NaverService {
    private final NaverClient client;
    private final ObjectMapper mapper;
    private final WishListRepository repository;

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

    public void add(WishListDto dto) {
        var entity = dtoToEntity(dto);

        repository.save(entity);
        entityToDto(entity);
    }

    public void addVisited(int index) {
        var dto = repository.findById(index);
        log.info("index : {}", index);
        log.info("dto : {}", dto);
        if (dto.isPresent()) {
            var item = dto.get();
            item.setVisited(true);
            item.setVisitCount(item.getVisitCount() + 1);
        }
    }

    public void delete(int index) {
        repository.deleteById(index);
    }

    public List<WishListDto> findAll() {
        return repository.listAll().stream().map(this::entityToDto).toList();
    }


    private WishListEntity dtoToEntity(WishListDto dto) {
        return mapper.convertValue(dto, WishListEntity.class);
    }

    private WishListDto entityToDto(WishListEntity entity) {
        return mapper.convertValue(entity, WishListDto.class);
    }
}
