package com.basiclab.iot.link.service.product.impl;

import com.basiclab.iot.common.core.utils.DateUtils;
import com.basiclab.iot.link.api.domain.product.entity.ProductCommands;
import com.basiclab.iot.link.mapper.product.ProductCommandsMapper;
import com.basiclab.iot.link.service.product.ProductCommandsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
public class ProductCommandsServiceImpl implements ProductCommandsService {

    @Resource
    private ProductCommandsMapper productCommandsMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return productCommandsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ProductCommands record) {
        return productCommandsMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(ProductCommands record) {
        return productCommandsMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(ProductCommands record) {
        return productCommandsMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(ProductCommands record) {
        return productCommandsMapper.insertSelective(record);
    }

    @Override
    public ProductCommands selectByPrimaryKey(Long id) {
        return productCommandsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductCommands record) {
        return productCommandsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProductCommands record) {
        return productCommandsMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<ProductCommands> list) {
        return productCommandsMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<ProductCommands> list) {
        return productCommandsMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<ProductCommands> list) {
        return productCommandsMapper.batchInsert(list);
    }

    /**
     * 查询产品模型设备服务命令
     *
     * @param id 产品模型设备服务命令主键
     * @return 产品模型设备服务命令
     */
    @Override
    public ProductCommands selectProductCommandsById(Long id) {
        return productCommandsMapper.selectProductCommandsById(id);
    }

    /**
     * 查询产品模型设备服务命令列表
     *
     * @param productCommands 产品模型设备服务命令
     * @return 产品模型设备服务命令
     */
    @Override
    public List<ProductCommands> selectProductCommandsList(ProductCommands productCommands) {
        return productCommandsMapper.selectProductCommandsList(productCommands);
    }

    /**
     * 新增产品模型设备服务命令
     *
     * @param productCommands 产品模型设备服务命令
     * @return 结果
     */
    @Override
    public int insertProductCommands(ProductCommands productCommands) {
        return productCommandsMapper.insertProductCommands(productCommands);
    }

    /**
     * 修改产品模型设备服务命令
     *
     * @param productCommands 产品模型设备服务命令
     * @return 结果
     */
    @Override
    public int updateProductCommands(ProductCommands productCommands) {
        return productCommandsMapper.updateProductCommands(productCommands);
    }

    /**
     * 批量删除产品模型设备服务命令
     *
     * @param ids 需要删除的产品模型设备服务命令主键
     * @return 结果
     */
    @Override
    public int deleteProductCommandsByIds(Long[] ids) {
        return productCommandsMapper.deleteProductCommandsByIds(ids);
    }

    @Override
    public List<ProductCommands> selectProductCommandsByIdList(List<Long> commandIdList){
        return productCommandsMapper.selectProductCommandsByIdList(commandIdList);
    }

    @Override
    public List<ProductCommands> selectProductCommandsByServiceIdList(List<Long> serviceIdList) {
        return productCommandsMapper.selectProductCommandsByServiceIdList(serviceIdList);
    }
}
