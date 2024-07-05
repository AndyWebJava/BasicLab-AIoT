package com.basiclab.iot.link.service.casbinRule;

import com.basiclab.iot.link.api.domain.device.entity.CasbinRule;

import java.util.List;
    /**
* @Description: java类作用描述
* @Author: BasiclabIoT
* @E-mail: andywebjava@163.com
* @Website: https://gitee.com/vegetable-chicken-blog/basiclab-iot
* @CreateDate: 2022/6/15$ 15:22$
* @UpdateUser: BasiclabIoT
* @UpdateDate: 2022/6/15$ 15:22$
* @UpdateRemark: 修改内容
* @Version: V1.0
*/
public interface CasbinRuleService{


    int deleteByPrimaryKey(Integer id);

    int insert(CasbinRule record);

    int insertOrUpdate(CasbinRule record);

    int insertOrUpdateSelective(CasbinRule record);

    int insertSelective(CasbinRule record);

    CasbinRule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CasbinRule record);

    int updateByPrimaryKey(CasbinRule record);

    int updateBatch(List<CasbinRule> list);

    int updateBatchSelective(List<CasbinRule> list);

    int batchInsert(List<CasbinRule> list);

        /**
         * 查询CAS规则管理
         *
         * @param id CAS规则管理主键
         * @return CAS规则管理
         */
        public CasbinRule selectCasbinRuleById(Long id);

        /**
         * 查询CAS规则管理列表
         *
         * @param casbinRule CAS规则管理
         * @return CAS规则管理集合
         */
        public List<CasbinRule> selectCasbinRuleList(CasbinRule casbinRule);

        /**
         * 新增CAS规则管理
         *
         * @param casbinRule CAS规则管理
         * @return 结果
         */
        public int insertCasbinRule(CasbinRule casbinRule);

        /**
         * 修改CAS规则管理
         *
         * @param casbinRule CAS规则管理
         * @return 结果
         */
        public int updateCasbinRule(CasbinRule casbinRule);

        /**
         * 批量删除CAS规则管理
         *
         * @param ids 需要删除的CAS规则管理主键集合
         * @return 结果
         */
        public int deleteCasbinRuleByIds(Long[] ids);

        /**
         * 删除CAS规则管理信息
         *
         * @param id CAS规则管理主键
         * @return 结果
         */
        public int deleteCasbinRuleById(Long id);

}
