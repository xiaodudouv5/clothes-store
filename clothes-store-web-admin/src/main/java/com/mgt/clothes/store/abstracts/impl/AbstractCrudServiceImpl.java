package com.mgt.clothes.store.abstracts.impl;

import com.mgt.clothes.store.abstracts.AbstractBaseEntity;
import com.mgt.clothes.store.abstracts.BaseCrudMapper;
import com.mgt.clothes.store.abstracts.BaseCrudService;
import com.mgt.clothes.store.entity.PageInfo;
import com.mgt.clothes.store.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AbstractCrudServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/18 3:35
 * @Version 1.0
 **/
@Service
public class AbstractCrudServiceImpl <T extends AbstractBaseEntity,M extends BaseCrudMapper<T>> implements BaseCrudService<T> {

    @Autowired
    private M mapper;
    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public PageInfo<T> page(T entity, int start, int length, int draw) {
        Map<String,Object> params = new HashMap<>();
        //将获取的值传入一个对象（遵循驼峰命名）
        params.put(StringUtils.toLowerCaseFirstOne(entity.getClass().getSimpleName()),entity);
        params.put("start",start);
        params.put("length",length);

        int count = mapper.count(entity);

        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(mapper.page(params));

        return pageInfo;
    }

    @Override
    public int count(T entity) {
        return mapper.count(entity);
    }

    @Override
    public void save(T entity) {
        //添加
        if(entity.nowInsert(entity)){
            mapper.add(entity);
        }
        //修改
        else {
            mapper.update(entity);
        }

    }

    @Override
    public T getById(Long id) {
        return mapper.getById(id);
    }

    @Override
    public void delete(T entity) {
        mapper.delete(entity);
    }
}
