package com.example.searchlist.wishlist;

import com.example.searchlist.db.MemoryDbRepositoryAbstract;
import com.example.searchlist.wishlist.entity.WishListEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {

}
