package com.nfu.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nfu.drug.pojo.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface SupplierMapper extends BaseMapper<Supplier> {

}
