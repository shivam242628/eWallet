package com.shivam.springBoot.service;

import com.shivam.springBoot.convertor.IConverter;
import com.shivam.springBoot.entity.BaseEntity;
import com.shivam.springBoot.entity.BaseVo;
import com.shivam.springBoot.exception.RecordNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public class BaseDataService<T extends BaseEntity<T>, V extends BaseVo<V>> implements IDataService<V> {

    private JpaRepository<T, Integer> repo;

    private IConverter<T, V> converter;

    BaseDataService(JpaRepository<T, Integer> repo, IConverter<T, V> converter) {
        this.repo = repo;
        this.converter = converter;
    }

    @Override
    public V save(V vo) {
        T t = converter.mapVoToEntity(vo);
        T save = repo.save(t);
        return converter.mapEntityToVo(save);
    }

    @Override
    public List<V> getAll() {
        List<T> all = repo.findAll();
        return all
                .stream()
                .map(converter::mapEntityToVo)
                .collect(Collectors.toList());
    }

    @Override
    public V update(int id, V vo) throws RecordNotFoundException {
        Optional<T> op = repo.findById(id);
        T t = op.orElse(null);
        if (t == null) {
            throw new RecordNotFoundException("No record with id " + id + " found in database");
        } else {
            vo.withId(t.getId());
            T t1 = converter.mapVoToEntity(vo);
            T save = repo.save(t1);
            return converter.mapEntityToVo(save);
        }
    }

    @Override
    public V delete(int id) {
        Optional<T> op = repo.findById(id);
        T t = op.orElse(null);
        if (t == null) {
            throw new RecordNotFoundException("No record with id " + id + " found in database");
        } else {
            repo.deleteById(id);
            return converter.mapEntityToVo(t);
        }
    }

    @Override
    public V findById(int id) {
        Optional<T> optional = repo.findById(id);
        T t = optional.orElse(null);
        if (t == null) {
            throw new RecordNotFoundException("No record with id " + id + " found in database");
        } else {
            return converter.mapEntityToVo(t);
        }
    }

    @Override
    public List<V> deleteAll() {
        List<T> all = repo.findAll();
        repo.deleteAll();
        return all
                .stream()
                .map(converter::mapEntityToVo)
                .collect(Collectors.toList());
    }

}
