package com.basiclab.iot.framework.ip.core.utils;


import com.basiclab.iot.framework.ip.core.Area;
import com.basiclab.iot.framework.ip.core.enums.AreaTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * {@link AreaUtils} 的单元测试
 *
 * @author BasicLab源码
 */
public class AreaUtilsTest {

    @Test
    public void testGetArea() {
        // 调用：北京
        Area area = AreaUtils.getArea(110100);
        // 断言
        assertEquals(area.getId(), 110100);
        assertEquals(area.getName(), "北京市");
        Assertions.assertEquals(area.getType(), AreaTypeEnum.CITY.getType());
        assertEquals(area.getParent().getId(), 110000);
        assertEquals(area.getChildren().size(), 16);
    }

    @Test
    public void testFormat() {
        assertEquals(AreaUtils.format(110105), "北京 北京市 朝阳区");
        assertEquals(AreaUtils.format(1), "中国");
        assertEquals(AreaUtils.format(2), "蒙古");
    }

}
