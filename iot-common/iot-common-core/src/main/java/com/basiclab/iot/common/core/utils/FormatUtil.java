package com.basiclab.iot.common.core.utils;


import cn.hutool.core.io.FileUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @ClassName:FormatUtil.java
 * @author: shisen
 * @date: 2021年12月29日
 * @Description: FormatUtil.java
 */
public class FormatUtil {

    /**
     * 格式化文件大小
     * 形式如：2.22 K, 2.22 M, 2222 Bytes，长度保留4位
     *
     * @param size 文件大小
     * @return 格式化后的字串
     */
    public static String formatSize(long size) {
        String sizeStr = "";
        //小于1024字节
        if (size < 1024) {
            sizeStr = size + " Bytes";
        }
        //大于1M
        else if (size > 1024000) {
            sizeStr = Float.toString((float) size / 1024000);
            if (sizeStr.length() > 4) {
                sizeStr = sizeStr.substring(0, 4);
            }
            if (sizeStr.endsWith(".")) {
                sizeStr = sizeStr.substring(0, sizeStr.length() - 1);
            }
            sizeStr += " M";
        } else {
            sizeStr = Float.toString((float) size / 1024);
            if (sizeStr.length() > 4) {
                sizeStr = sizeStr.substring(0, 4);
            }
            if (sizeStr.endsWith(".")) {
                sizeStr = sizeStr.substring(0, sizeStr.length() - 1);
            }
            sizeStr += " K";
        }
        return sizeStr;
    }

    public static String formatPath(String pathStr, boolean isEndWithSeparator) {
        pathStr = formatPath(pathStr);
        pathStr = pathStr + File.separator;
        return pathStr;
    }

    public static String formatPath(String pathStr) {
        pathStr = pathStr.replace('/', File.separatorChar);
        pathStr = pathStr.replace('\\', File.separatorChar);
        if (pathStr.endsWith(File.separator)) {
            pathStr = pathStr.substring(0, pathStr.length() - 1);
            pathStr = formatPath(pathStr);
        }
        return pathStr;
    }


    /**
     * 对字串进行处理，防止空字串产生错误
     *
     * @return String 格式化后的字串
     */
    public static String formatNullString(String str) {
        if (str == null || str.trim().equals("")) {
            str = "";
        }
        return str;
    }


    /**
     * 如果字符串为空，设成默认值
     *
     * @param str 默认字符串
     * @return String 格式化后的字串
     */
    public static String formatNullString(String str, String defaultStr) {
        if (str == null || str.trim().equals("")) {
            str = defaultStr;
        }
        return str;
    }


    /**
     * 判断是否是数字
     *
     * @param str 字符串
     * @return boolean
     */
    public static boolean isNumeric(String str) {
        if (str != null && !"".equals(str) && !str.startsWith("0")) {
            for (int i = str.length(); --i >= 0; ) {
                int chr = str.charAt(i);
                if (chr < 48 || chr > 57) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }


    /**
     * 判断是否是中文
     *
     * @return boolean
     */
    public static boolean isLetter(char c) {
        int k = 0x80;
        return c / k == 0 ? true : false;
    }


    /**
     * 将字符串中的多个空格，替换成一个
     *
     * @param str
     * @return
     */
    public static String replaceKg(String str) {
        Pattern p = Pattern.compile("\\s+");
        Matcher m = p.matcher(str);
        return m.replaceAll(" ");
    }

    /**
     * 根据url截取域名
     *
     * @return String
     */
    public static String getDomainForUrl(String url) {
        return url.replaceAll("http://([^/|:]+)[/|:].*", "$1");
    }

    /**
     * m转为g
     *
     * @param str
     * @return
     */
    public static double mToG(String str) {
        double result = 0;
        double mod = 1024;
        if (str.contains("M")) {
            double f = Double.valueOf(str.replace("M", ""));
            result = f / mod;
        } else if (str.contains("K")) {
            double f = Double.valueOf(str.replace("K", ""));
            result = (f / mod) / mod;
        } else if (str.contains("T")) {
            double f = Double.valueOf(str.replace("T", ""));
            result = f * 1024;
        } else if (str.contains("G")) {
            result = Double.valueOf(str.replace("G", ""));
        }
        return formatDouble(result, 2);
    }


    // 按map中的value排序 -- 降序
    public static List<String> sortMapValueDouble(Map<String, Integer> maps) {
        List<Map.Entry<String, Integer>> info = new ArrayList<Map.Entry<String, Integer>>(maps.entrySet());
        List<String> desc = new ArrayList<String>();
        Collections.sort(info, new DoubleComparator());
        for (Map.Entry<String, Integer> map : info) {
            desc.add(map.getKey());
        }
        return desc;
    }

    // 自定义比较器：按相似度来排序
    static class DoubleComparator implements Comparator {
        @Override
        public int compare(Object object1, Object object2) {// 实现接口中的方法
            Map.Entry<String, Integer> p1 = (Map.Entry<String, Integer>) object1; // 强制转换
            Map.Entry<String, Integer> p2 = (Map.Entry<String, Integer>) object2;
            return p2.getValue().compareTo(p1.getValue());
        }
    }

    /**
     * 格式化double数据，截取小数点后数字
     *
     * @param str
     * @param num
     * @return
     */
    public static double formatDouble(double str, int num) {
        java.math.BigDecimal b = new java.math.BigDecimal(str);
        double myNum3 = b.setScale(num, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
        return myNum3;
    }

    public static String delChar(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        str = str.replace("%", "");
        return str;
    }

    public static String getPidByFile(String appType, String appPid) {
        if ("1".equals(appType)) {
            return appPid;
        } else {
            try {
                String pid = FileUtil.readString(appPid, "UTF-8");
                if (!StringUtils.isEmpty(pid)) {
                    return pid.trim();
                }
            } catch (Exception e) {
                System.out.println("获取PID文件错误");
            }
        }
        return "";
    }

}