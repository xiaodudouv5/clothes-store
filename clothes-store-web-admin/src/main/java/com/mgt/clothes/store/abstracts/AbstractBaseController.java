package com.mgt.clothes.store.abstracts;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName AbstractBaseController
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/18 3:41
 * @Version 1.0
 **/

public class AbstractBaseController<T extends AbstractBaseEntity,S extends BaseCrudService<T>> {
    @Autowired
    protected S service;

}
