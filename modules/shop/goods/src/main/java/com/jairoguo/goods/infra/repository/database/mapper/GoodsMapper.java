package com.jairoguo.goods.infra.repository.database.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jairoguo.goods.infra.repository.database.po.GoodsPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jairo Guo
 */
@Mapper
public interface GoodsMapper extends BaseMapper<GoodsPO>  {
}
