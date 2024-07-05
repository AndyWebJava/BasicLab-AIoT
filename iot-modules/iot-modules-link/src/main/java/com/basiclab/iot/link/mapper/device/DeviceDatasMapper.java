package com.basiclab.iot.link.mapper.device;

import com.basiclab.iot.link.api.domain.device.entity.DeviceDatas;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: basiclabiot
 * @description: ${description}
 * @packagename: com.basiclab.basiclabiot.link.mapper.device
 * @author: BasiclabIoT
 * @e-mainl: andywebjava@163.com
 * @date: 2022-12-17 20:08
 **/
@Mapper
public interface DeviceDatasMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(DeviceDatas record);

    int insertOrUpdate(DeviceDatas record);

    int insertOrUpdateSelective(DeviceDatas record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(DeviceDatas record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    DeviceDatas selectByPrimaryKey(Long id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(DeviceDatas record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(DeviceDatas record);

    int updateBatch(List<DeviceDatas> list);

    int updateBatchSelective(List<DeviceDatas> list);

    int batchInsert(@Param("list") List<DeviceDatas> list);
}