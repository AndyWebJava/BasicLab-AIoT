package com.basiclab.iot.link.mapper.product;

import com.basiclab.iot.link.api.domain.product.entity.ProductServices;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: basiclabiot
 * @description: ${description}
 * @packagename: com.basiclab.basiclabiot.link.mapper.product
 * @author: BasiclabIoT
 * @e-mainl: andywebjava@163.com
 * @date: 2022-11-18 20:38
 **/
@Mapper
public interface ProductServicesMapper {
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
    int insert(ProductServices record);

    int insertOrUpdate(ProductServices record);

    int insertOrUpdateSelective(ProductServices record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(ProductServices record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    ProductServices selectByPrimaryKey(Long id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ProductServices record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ProductServices record);

    int updateBatch(List<ProductServices> list);

    int updateBatchSelective(List<ProductServices> list);

    int batchInsert(@Param("list") List<ProductServices> list);

    List<ProductServices> findByProductIdentifications(@Param("productIdentifications") List<String> productIdentifications);

    List<ProductServices> findAllByProductIdentificationIdAndStatus(@Param("productIdentification") String productIdentification, @Param("status") String status);

    List<ProductServices> findAllByProductIdentificationAndServiceCodeAndStatus(@Param("productIdentification") String productIdentification, @Param("serviceCode") String serviceCode, @Param("status") String status);

    /**
     * 查询产品模型服务
     *
     * @param id 产品模型服务主键
     * @return 产品模型服务
     */
    ProductServices selectProductServicesById(Long id);

    /**
     * 查询产品模型服务列表
     *
     * @param productServices 产品模型服务
     * @return 产品模型服务集合
     */
    List<ProductServices> selectProductServicesList(ProductServices productServices);

    /**
     * 新增产品模型服务
     *
     * @param productServices 产品模型服务
     * @return 结果
     */
    int insertProductServices(ProductServices productServices);

    /**
     * 修改产品模型服务
     *
     * @param productServices 产品模型服务
     * @return 结果
     */
    int updateProductServices(ProductServices productServices);

    /**
     * 批量删除产品模型服务
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteProductServicesByIds(Long[] ids);

    /**
     * 根据产品标识和状态获取产品服务
     *
     * @param productIdentification
     * @param status
     * @return
     */
    List<ProductServices> selectAllByProductIdentificationAndStatus(@Param("productIdentification") String productIdentification, @Param("status") String status);

    List<ProductServices> selectProductServicesByIdList(@Param("serviceIdList") List<Long> serviceIdList);
}