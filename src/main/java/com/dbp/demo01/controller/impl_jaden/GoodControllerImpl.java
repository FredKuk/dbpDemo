package com.dbp.demo01.controller.impl_jaden;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbp.demo01.model.Good;
import com.dbp.demo01.service.impl_jaden.GoodService;

@RestController
@RequestMapping("/jaden/good")
public class GoodControllerImpl {

    @Autowired
    private GoodService goodService;

    @GetMapping("")
    @ResponseBody
    public List<Good> findAll(){
        return goodService.findAll();
    }

    @GetMapping("/{goodNo}")
    @ResponseBody
    public Optional<Good> findById(@PathVariable String goodNo){
        return goodService.findById(Integer.parseInt(goodNo));
    }

    @PostMapping(value = "", produces = "application/json")
    @ResponseBody
    public Optional<Good> save(@RequestBody Good good) {
        return goodService.save(good);
    }


    @PutMapping(value = "", produces = "application/json")
    @ResponseBody
    public Optional<Good> update(@RequestBody Good good) {
        return goodService.update(good);
    }

    @PatchMapping("/{goodNo}")
    @ResponseBody
    public Optional<Good> delete(@PathVariable String goodNo) {
        return goodService.delete(goodNo);
    }    


}
