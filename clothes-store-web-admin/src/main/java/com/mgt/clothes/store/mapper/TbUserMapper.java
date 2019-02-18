package com.mgt.clothes.store.mapper;

import com.mgt.clothes.store.abstracts.BaseCrudMapper;
import com.mgt.clothes.store.entity.TbUser;
import org.springframework.stereotype.Repository;

/**
 * @ClassName TbUserMapper
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/16 16:14
 * @Version 1.0
 **/
@Repository
public interface TbUserMapper {
    /**
     * 用户登陆
     * @param tbUser
     * @return
     */
    TbUser getByLoginId(TbUser tbUser);

}
