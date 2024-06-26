package com.nfu.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nfu.drug.pojo.BillInfo;
import com.nfu.drug.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

    String selectUser();

    void updateStatus(@Param("username") String username);

    void cleanStatus();

    String inSellDrug();

    String stockNum();

    String inSellDrugType();

    String allProblemDrugNum();

    String allReturnDrugNum();

    String drugAllNum();

    String selectType(String username);

    //List<BillInfo> queryDrugInfoListBySName(@Param("sName") String sname);

    List<User> queryUserListByUsername(@Param("username") String username);
}
