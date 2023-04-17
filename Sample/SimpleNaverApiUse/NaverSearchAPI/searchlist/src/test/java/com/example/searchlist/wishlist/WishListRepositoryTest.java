package com.example.searchlist.wishlist;

import com.example.searchlist.wishlist.entity.WishListEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WishListRepositoryTest {

    @Autowired
    private WishListRepository repository;

    private WishListEntity create() {
        var wishList = new WishListEntity();
        wishList.setTitle("title");
        wishList.setCategory("category");
        wishList.setAddress("address");
        wishList.setReadAddress("road address");
        wishList.setHomePageLink("");
        wishList.setImgLink("");
        wishList.setVisited(false);
        wishList.setVisitCount(0);
        wishList.setLastVisitDate(null);
        return wishList;
    }

    @Test
    public void saveTest() {
        var entity = create();
        var expected = repository.save(entity);
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(1, expected.getIndex());
    }

    @Test
    public void findByIdTest() {
        var entity = create();
        var expected = repository.findById(1);
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(expected.get().getCategory(), "category");
    }

    @Test
    public void deleteTest() {
        saveTest();
        repository.deleteById(1);
        var expected = repository.listAll().isEmpty();
        Assertions.assertTrue(expected);
    }

    @Test
    public void listAllTest() {
        var entity1 = create();
        var entity2 = create();
        var entity3 = create();

        repository.save(entity1);
        repository.save(entity2);
        repository.save(entity3);

        int count = repository.listAll().size();
        Assertions.assertEquals(3, count);
    }

    @Test
    public void updateTest() {
        var entity = create();
        var expected = repository.save(entity);
        String preTitle = repository.findById(1).get().getTitle();
        Assertions.assertEquals(preTitle,"title");
        expected.setTitle("update test");
        repository.save(expected);
        Assertions.assertEquals(repository.findById(1).get().getTitle(),"update test");
    }
}
