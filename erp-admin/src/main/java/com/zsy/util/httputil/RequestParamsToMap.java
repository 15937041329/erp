package com.zsy.util.httputil;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class RequestParamsToMap {

    /**
     * 返回值类型为Map<String, Object>
     * @param request
     * @return
     */
    public static Map<String, Object> getParameterMap(HttpServletRequest request) {
        //把请求参数封装到Map<String, String[]>中
        Map<String, String[]> properties = request.getParameterMap();
        Map<String, Object> returnMap = new LinkedHashMap<>();
        Iterator<Map.Entry<String, String[]>> iter = properties.entrySet().iterator();
        String name = "";
        String value = "";
        while (iter.hasNext()) {
            Map.Entry<String, String[]> entry = iter.next();
            name = entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else {
                //用于请求参数中有多个相同名称
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }

    /**
     * 返回值类型为Map<String, String>
     * @param request
     * @return
     */
    public static Map<String, String> getParameterStringMap(HttpServletRequest request) {
        //把请求参数封装到Map<String, String[]>中
        Map<String, String[]> properties = request.getParameterMap();
        Map<String, String> returnMap = new LinkedHashMap<>();
        String name = "";
        String value = "";
        for (Map.Entry<String, String[]> entry : properties.entrySet()) {
            name = entry.getKey();
            String[] values = entry.getValue();
            if (null == values) {
                value = "";
            } else if (values.length>1) {
                //用于请求参数中有多个相同名称
                for (String s : values) {
                    value = s + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                //用于请求参数中请求参数名唯一
                value = values[0];
            }
            returnMap.put(name, value);

        }
        return returnMap;
    }


    public static JSONObject getRequestJsonObject(HttpServletRequest request) throws IOException {
        String json = getRequestJsonString(request);
        return JSONUtil.parseObj(json);
    }


    public static com.alibaba.fastjson.JSONObject getRequestJsonObject2(HttpServletRequest request) throws IOException {
        String json = getRequestJsonString(request);
        return com.alibaba.fastjson.JSONObject.parseObject(json);
    }
    /***
     * 获取 request 中 json 字符串的内容
     *
     * @param request
     * @return : <code>byte[]</code>
     * @throws IOException
     */
    public static String getRequestJsonString(HttpServletRequest request)
            throws IOException {
        String submitMehtod = request.getMethod();
        // GET
        if (submitMehtod.equals("GET")) {
            return new String(request.getQueryString().getBytes("iso-8859-1"),"utf-8").replaceAll("%22", "\"");
            // POST
        } else {
            return getRequestPostStr(request);
        }
    }

    /**
     * 描述:获取 post 请求的 byte[] 数组
     * <pre>
     * 举例：
     * </pre>
     * @param request
     * @return
     * @throws IOException
     */
    public static byte[] getRequestPostBytes(HttpServletRequest request)
            throws IOException {
        int contentLength = request.getContentLength();
        if(contentLength<0){
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength;) {

            int readlen = request.getInputStream().read(buffer, i,
                    contentLength - i);
            if (readlen == -1) {
                break;
            }
            i += readlen;
        }
        return buffer;
    }

    /**
     * 描述:获取 post 请求内容
     * <pre>
     * 举例：
     * </pre>
     * @param request
     * @return
     * @throws IOException
     */
    public static String getRequestPostStr(HttpServletRequest request)
            throws IOException {
        byte buffer[] = getRequestPostBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        return new String(buffer, charEncoding);
    }



}
