package com.example.searchlist.db;

import com.example.searchlist.db.entity.MemoryEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryDbRepositoryAbstract<T extends MemoryEntity> implements MemoryDbRepository<T> {

    private final List<T> db = new ArrayList<>();
    private int index = 0;

    @Override
    public Optional<T> findById(int idx) {
        return db.stream().filter(it -> it.getIndex() == index).findFirst();
    }

    @Override
    public T save(T input) {
        //update-> db 데이터 O, insert -> db 데이터 X
        var entity = db.stream().filter(it -> it.getIndex() == input.getIndex()).findFirst();

        if (entity.isEmpty()) {
            //데이터 추가
            input.setIndex(++index);
        } else {
            //데이터 갱신
            var preIndex = entity.get().getIndex();
            deleteById(preIndex);
        }
        db.add(input);

        return input;
    }

    @Override
    public List<T> listAll() {
        return db;
    }

    @Override
    public void deleteById(int idx) {
        var entity = db.stream().filter(it -> it.getIndex() == idx).findFirst();
        if (entity.isPresent()) {
            db.remove(entity.get());
        }
    }
}
