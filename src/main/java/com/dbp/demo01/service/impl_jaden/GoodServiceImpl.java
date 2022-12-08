package com.dbp.demo01.service.impl_jaden;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbp.demo01.model.Good;
import com.dbp.demo01.repository.impl_jaden.GoodJadenRepository;

@Service
public class GoodServiceImpl implements GoodService{
    
    @Autowired
    private GoodJadenRepository goodJadenRepository;

    @Override
    public List<Good> findAll() {
        return goodJadenRepository.findAll();
    }

    @Override
    public Optional<Good> findById(int goodNo){
        return goodJadenRepository.findById(goodNo);
    }

    @Override
    public Optional<Good> save(Good good) {
        return Optional.ofNullable(goodJadenRepository.save(good));
    }

    @Override
    public Optional<Good> update(Good good) {
        Optional<Good> updateGood = goodJadenRepository.findById(good.getGoodNo());
        
        updateGood.ifPresent(
            target->{
                target.setName(good.getName());
                target.setChangeDate(null);
                goodJadenRepository.save(target);
            }
        );
        return updateGood;
    }

    @Override
    public Optional<Good> delete(String goodNo) {
        Optional<Good> deleteGood = goodJadenRepository.findById(Integer.parseInt(goodNo));
        
        deleteGood.ifPresent(
            target->{
                target.setStat(0);
                target.setChangeDate(null);
                goodJadenRepository.save(target);
            }
        );
        return deleteGood;
    }
}
