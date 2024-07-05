package com.basiclab.iot.link.mapper.product;

import com.basiclab.iot.link.api.domain.product.entity.ProductCommands;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: java类作用描述
 * @Author: BasiclabIoT
 * @E-mail: andywebjava@163.com
 * @Website: https://gitee.com/vegetable-chicken-blog/basiclab-iot
 * @CreateDate: 2021/12/25$ 23:52$
 * @UpdateUser: BasiclabIoT
 * @UpdateDate: 2021/12/25$ 23:52$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Mapper
public interface ProductCommandsMapper {
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
    int insert(ProductCommands record);

    int insertOrUpdate(ProductCommands record);

    int insertOrUpdateSelective(ProductCommands record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(ProductCommands record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    ProductCommands selectByPrimaryKey(Long id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ProductCommands record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ProductCommands record);

    int updateBatch(List<ProductCommands> list);

    int updateBatchSelective(List<ProductCommands> list);

    int batchInsert(@Param("list") List<ProductCommands> list);

    /**
     * 查询产品模型设备服务命令
     *
     * @param id 产品模型设备服务命令主键
     * @return 产品模型设备服务命令
     */
    ProductCommands selectProductCommandsById(Long id);

    /**
     * 查询产品模型设备服务命令列表
     *
     * @param productCommands 产品模型设备服务命令
     * @return 产品模型设备服务命令集合
     */
    List<ProductCommands> selectProductCommandsList(ProductCommands productCommands);

    /**
     * 新增产品模型设备服务命令
     *
     * @param productCommands 产品模型设备服务命令
     * @return 结果
     */
    int insertProductCommands(ProductCommands productCommands);

    /**
     * 修改产品模型设备服务命令
     *
     * @param productCommands 产品模型设备服务命令
     * @return 结果
     */
    int updateProductCommands(ProductCommands productCommands);

    /**
     * 批量删除产品模型设备服务命令
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteProductCommandsByIds(Long[] ids);

    List<ProductCommands> selectProductCommandsByIdList(@Param("commandIdList") List<Long> commandIdList);

    List<ProductCommands> selectProductCommandsByServiceIdList(@Param("serviceIdList") List<Long> serviceIdList);
}
