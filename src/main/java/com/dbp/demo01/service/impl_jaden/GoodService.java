package com.dbp.demo01.service.impl_jaden;

import java.util.List;
import java.util.Optional;

import com.dbp.demo01.model.Good;

public interface GoodService {
    List<Good> findAll();
    Optional<Good> findById(int goodNo);
    Optional<Good> save(Good good);
    Optional<Good> update(Good good);
    Optional<Good> delete(String goodNo);
}
