package com.basiclab.iot.system.api.dept;

import com.basiclab.iot.framework.common.pojo.CommonResult;
import com.basiclab.iot.framework.common.util.object.BeanUtils;
import com.basiclab.iot.system.api.dept.dto.PostRespDTO;
import com.basiclab.iot.system.dal.dataobject.dept.PostDO;
import com.basiclab.iot.system.service.dept.PostService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static com.basiclab.iot.framework.common.pojo.CommonResult.success;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
public class PostApiImpl implements PostApi {

    @Resource
    private PostService postService;

    @Override
    public CommonResult<Boolean> validPostList(Collection<Long> ids) {
        postService.validatePostList(ids);
        return success(true);
    }

    @Override
    public CommonResult<List<PostRespDTO>> getPostList(Collection<Long> ids) {
        List<PostDO> list = postService.getPostList(ids);
        return success(BeanUtils.toBean(list, PostRespDTO.class));
    }

}
