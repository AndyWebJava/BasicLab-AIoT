package com.basiclab.iot.link.service.product.impl;

import com.basiclab.iot.common.core.utils.DateUtils;
import com.basiclab.iot.link.mapper.product.ProductCommandsResponseMapper;
import com.basiclab.iot.link.service.product.ProductCommandsResponseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.basiclab.iot.link.api.domain.product.entity.ProductCommandsResponse;

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
@Service
public class ProductCommandsResponseServiceImpl implements ProductCommandsResponseService {

    @Resource
    private ProductCommandsResponseMapper productCommandsResponseMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return productCommandsResponseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ProductCommandsResponse record) {
        return productCommandsResponseMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(ProductCommandsResponse record) {
        return productCommandsResponseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(ProductCommandsResponse record) {
        return productCommandsResponseMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(ProductCommandsResponse record) {
        return productCommandsResponseMapper.insertSelective(record);
    }

    @Override
    public ProductCommandsResponse selectByPrimaryKey(Long id) {
        return productCommandsResponseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductCommandsResponse record) {
        return productCommandsResponseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProductCommandsResponse record) {
        return productCommandsResponseMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<ProductCommandsResponse> list) {
        return productCommandsResponseMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<ProductCommandsResponse> list) {
        return productCommandsResponseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<ProductCommandsResponse> list) {
        return productCommandsResponseMapper.batchInsert(list);
    }

    /**
     * 查询产品模型设备响应服务命令属性
     *
     * @param id 产品模型设备响应服务命令属性主键
     * @return 产品模型设备响应服务命令属性
     */
    @Override
    public ProductCommandsResponse selectProductCommandsResponseById(Long id) {
        return productCommandsResponseMapper.selectProductCommandsResponseById(id);
    }

    /**
     * 查询产品模型设备响应服务命令属性列表
     *
     * @param productCommandsResponse 产品模型设备响应服务命令属性
     * @return 产品模型设备响应服务命令属性
     */
    @Override
    public List<ProductCommandsResponse> selectProductCommandsResponseList(ProductCommandsResponse productCommandsResponse) {
        return productCommandsResponseMapper.selectProductCommandsResponseList(productCommandsResponse);
    }

    /**
     * 新增产品模型设备响应服务命令属性
     *
     * @param productCommandsResponse 产品模型设备响应服务命令属性
     * @return 结果
     */
    @Override
    public int insertProductCommandsResponse(ProductCommandsResponse productCommandsResponse) {
        return productCommandsResponseMapper.insertProductCommandsResponse(productCommandsResponse);
    }

    /**
     * 修改产品模型设备响应服务命令属性
     *
     * @param productCommandsResponse 产品模型设备响应服务命令属性
     * @return 结果
     */
    @Override
    public int updateProductCommandsResponse(ProductCommandsResponse productCommandsResponse) {
        return productCommandsResponseMapper.updateProductCommandsResponse(productCommandsResponse);
    }

    /**
     * 批量删除产品模型设备响应服务命令属性
     *
     * @param ids 需要删除的产品模型设备响应服务命令属性主键
     * @return 结果
     */
    @Override
    public int deleteProductCommandsResponseByIds(Long[] ids) {
        return productCommandsResponseMapper.deleteProductCommandsResponseByIds(ids);
    }

    @Override
    public List<ProductCommandsResponse> selectProductCommandsResponseByCommandIdList(List<Long> commandIdList) {
        return productCommandsResponseMapper.selectProductCommandsResponseByCommandIdList(commandIdList);
    }

}
