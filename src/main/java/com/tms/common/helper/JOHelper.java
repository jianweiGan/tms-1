package com.tms.common.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tms.common.exception.BussinessException;
import com.tms.common.exception.ErrorCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

public class JOHelper {
    /**
     * json转换为class
     *
     * @param jo
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T jo2class(JSONObject jo, Class<T> clazz) {
        T t = JSON.parseObject(jo.toJSONString(), clazz);
        return t;
    }

    /**
     * jsonarray 转换为list
     *
     * @param array
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> jo2list(JSONArray array, Class<T> clazz) {
        List<T> list = JSON.parseArray(array.toJSONString(), clazz);
        return list;
    }

    /**
     * obj 2 json
     *
     * @param obj
     * @return
     */
    public static JSONObject obj2Json(Object obj) throws BussinessException {
        if (ObjectUtils.isEmpty(obj)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }
        return JSON.parseObject(JSON.toJSONString(obj));
    }

    /**
     * @param args
     *         key-value 看起来必须是偶数，对吧
     * @return
     */
    public static JSONObject gen(Object... args) {
        JSONObject ret = new JSONObject();
        for (int i = 0, len = args.length; i < len; i += 2) {
            if (args[i + 1] == null) {
                ret.remove(args[i].toString());
            } else {
                ret.put(args[i].toString(), args[i + 1]);
            }
        }
        return ret;
    }

    /**
     * @param jo
     * @return
     */
    public static boolean isEmpty(JSONObject jo) {
        if (jo == null) {
            return true;
        }
        if (jo.keySet().size() > 0) {
            return false;
        }
        return true;
    }

    public static boolean hasIgnoreCase(String key, JSONObject vo) {
        if (isEmpty(vo)) {
            return false;
        }
        if (StringUtils.isBlank(key)) {
            return false;
        }
        if (vo.get(key) != null || vo.get(key.toLowerCase()) != null || vo.get(key.toUpperCase()) != null) {
            return true;
        }
        return false;
    }
}
