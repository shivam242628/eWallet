package com.shivam.springBoot.controller;

import com.shivam.springBoot.entity.BaseEntity;
import com.shivam.springBoot.entity.BaseVo;
import com.shivam.springBoot.service.IDataService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public abstract class BaseController<T extends BaseEntity<T>, V extends BaseVo<V>> {

    private IDataService<V> iDataService;

    public BaseController(IDataService<V> iDataService) {
        this.iDataService = iDataService;
    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public V save(@RequestBody V v) {
        return iDataService.save(v);
    }

    @GetMapping(value = "", consumes = "application/json", produces = "application/json")
    public List<V> findAll() {
        return iDataService.getAll();
    }

    @GetMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public V findById(@PathVariable("id") Integer id) {
        return iDataService.findById(id);
    }

    @DeleteMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public V deleteById(@PathVariable("id") int id) {
        return iDataService.delete(id);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public V update(@PathVariable("id") int id, @RequestBody V v) {
        return iDataService.update(id, v);
    }
}
