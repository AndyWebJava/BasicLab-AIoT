package com.basiclab.iot.system.dal.mysql.dict;

import com.basiclab.iot.framework.common.pojo.PageResult;
import com.basiclab.iot.framework.mybatis.core.mapper.BaseMapperX;
import com.basiclab.iot.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.basiclab.iot.system.controller.admin.dict.vo.type.DictTypePageReqVO;
import com.basiclab.iot.system.dal.dataobject.dict.DictTypeDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;

@Mapper
public interface DictTypeMapper extends BaseMapperX<DictTypeDO> {

    default PageResult<DictTypeDO> selectPage(DictTypePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<DictTypeDO>()
                .likeIfPresent(DictTypeDO::getName, reqVO.getName())
                .likeIfPresent(DictTypeDO::getType, reqVO.getType())
                .eqIfPresent(DictTypeDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(DictTypeDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(DictTypeDO::getId));
    }

    default DictTypeDO selectByType(String type) {
        return selectOne(DictTypeDO::getType, type);
    }

    default DictTypeDO selectByName(String name) {
        return selectOne(DictTypeDO::getName, name);
    }

    @Update("UPDATE system_dict_type SET deleted = 1, deleted_time = #{deletedTime} WHERE id = #{id}")
    void updateToDelete(@Param("id") Long id, @Param("deletedTime") LocalDateTime deletedTime);

}
