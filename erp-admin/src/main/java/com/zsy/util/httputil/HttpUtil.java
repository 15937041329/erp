package com.zsy.util.httputil;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.PatternPool;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.Data;
import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 实例化此类后只能单线程进入，请勿单实例全局使用。会出问题的。
 *
 * @author AAA
 */
@Component
@Data
public class HttpUtil {

    private static final Object LOCK_OBJ = new Object();
    private static final String LOCAL_HOST = NetUtil.getLocalhostStr();
    private static OkHttpClient okHttpClientStatic;
    private OkHttpClient okHttpClient;
    private CookieJarImpl cookieJar = new CookieJarImpl();
    private Proxy proxy;
    private Authenticator proxyAuthenticator;

    private String orderId = "";


    private String accept = "*/*";
    private String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36";

    private String encoding = "UTF-8";
    private String contentType = "application/json";


    /**
     * 如果是非单例模式或开线程后重复调用的话keepAlive必须设置为false
     * 否则会每次链接都会建立tcp通道，然后好久才关闭。会有端口用尽的危险。
     */
    private boolean keepAlive = true;

    private int timeOut = 20;
    private Request request;
    private Response response;
    private Map<String, String> otherHeaders = new LinkedHashMap<>();


    private StopWatch stopWatch = new StopWatch();
    private String httpUrl = "";
    private String httpData = "";
    private String httpRet = "";

    public HttpUtil() {
        synchronized (LOCK_OBJ) {
            if (okHttpClientStatic == null) {
                okHttpClientStatic = new OkHttpClient();
                okHttpClientStatic.dispatcher().setMaxRequests(128);
                okHttpClientStatic.dispatcher().setMaxRequestsPerHost(32);
            }
        }
        TrustAllManager trustAllManager = new TrustAllManager();
        okHttpClient = okHttpClientStatic
                .newBuilder()
                .connectTimeout(2, TimeUnit.SECONDS)
                .readTimeout(timeOut, TimeUnit.SECONDS)
                .writeTimeout(3, TimeUnit.SECONDS)
                .cookieJar(cookieJar)
                .build();

    }

    /**
     * 关闭SSL认证
     *
     * @param sslVerifier
     */
    public HttpUtil(boolean sslVerifier) {
        synchronized (LOCK_OBJ) {
            if (okHttpClientStatic == null) {
                okHttpClientStatic = new OkHttpClient();
                okHttpClientStatic.dispatcher().setMaxRequests(128);
                okHttpClientStatic.dispatcher().setMaxRequestsPerHost(32);
            }
        }

        TrustAllManager trustAllManager = new TrustAllManager();
        okHttpClient = okHttpClientStatic
                .newBuilder()
                .sslSocketFactory(cookieJar.createTrustAllSslFactory(trustAllManager), trustAllManager)
                .hostnameVerifier(cookieJar.createTrustAllHostnameVerifier())
                .connectTimeout(2, TimeUnit.SECONDS)
                .readTimeout(timeOut, TimeUnit.SECONDS)
                .writeTimeout(3, TimeUnit.SECONDS)
                .cookieJar(cookieJar)
                .build();
        okHttpClient.dispatcher().setMaxRequests(128);
        okHttpClient.dispatcher().setMaxRequestsPerHost(32);
    }

    /**
     * GET访问
     *
     * @param url     地址
     * @param referer 来路
     * @return html
     * @throws IOException IOException
     */
    public String getHtml(String url, String referer) throws IOException {
        try {
            stopWatch.start();
            httpUrl = url;
            httpData = "";
            httpRet = new String(Objects.requireNonNull(get(url, referer).body()).bytes(),encoding);
            return httpRet;
        } finally {
            stopWatch.stop();
        }
    }

    /**
     * GET访问
     *
     * @param url     地址
     * @param referer 来路
     * @return html
     * @throws IOException IOException
     */
    public String getHtml(String url, Map<String, ?> getList, String referer) throws IOException {
        try {
            stopWatch.start();
            httpUrl = url + "?" + toParams(getList);
            httpData = "";
            httpRet = new String(Objects.requireNonNull(get(url + "?" + toParams(getList), referer).body()).bytes(),encoding);
            return httpRet;
        } finally {
            stopWatch.stop();
        }
    }


    /**
     * 获取Stream 图片类，文件类
     *
     * @param url     地址
     * @param referer 来路
     * @return Stream
     * @throws IOException IOException
     */
    public InputStream getCode(String url, String referer) throws IOException {
        try {
            stopWatch.start();
            httpUrl = url;
            httpData = "";
            httpRet = "InputStream";
            return Objects.requireNonNull(get(url, referer).body()).byteStream();
        } catch (IOException e) {
            throw new IOException(e);
        } finally {
            stopWatch.stop();
        }
    }


    /**
     * POST访问
     *
     * @param url     地址
     * @param postObj JSONObject
     * @param referer 来路
     * @return html
     * @throws IOException IOException
     */
    @SuppressWarnings("unchecked")
    public String postHtml(String url, Object postObj, String referer) throws IOException {
        try {
            stopWatch.start();
            String postData = "";
            MediaType mediaType;
            if (postObj instanceof JSONObject) {
                postData = postObj.toString();
                mediaType = MediaType.parse("application/json");
            } else if (postObj instanceof com.alibaba.fastjson.JSONObject) {
                postData = postObj.toString();
                mediaType = MediaType.parse("application/json");
            } else if (postObj instanceof Map) {
                postData = toParams((Map<String, ?>) postObj);
                mediaType = MediaType.parse("application/x-www-form-urlencoded");
            } else if (postObj instanceof String) {
                mediaType = MediaType.parse(contentType);
                postData = postObj.toString();
            } else {
                throw new IOException("提交类型错误");
            }
            httpUrl = url;
            httpData = postData;
            RequestBody requestBody = RequestBody.create(mediaType, postData);
            httpRet = new String(Objects.requireNonNull(post(url, requestBody, referer).body()).bytes(),encoding) ;
            return httpRet;
        } catch (IOException e) {
            throw new IOException(e);
        } finally {
            stopWatch.stop();
        }
    }

    /**
     * 获取Stream 图片类，文件类
     *
     * @param url     地址
     * @param postObj map或JSONObject
     * @param referer 来路
     * @return Stream
     * @throws IOException IOException
     */
    @SuppressWarnings("unchecked")
    public InputStream postCode(String url, Object postObj, String referer) throws IOException {
        try {
            stopWatch.start();
            String postData = "";
            MediaType mediaType;
            if (postObj instanceof JSONObject) {
                postData = postObj.toString();
                mediaType = MediaType.parse("application/json");
            } else if (postObj instanceof com.alibaba.fastjson.JSONObject) {
                postData = postObj.toString();
                mediaType = MediaType.parse("application/json");
            } else if (postObj instanceof Map) {
                postData = toParams((Map<String, ?>) postObj);
                mediaType = MediaType.parse("application/x-www-form-urlencoded");
            } else if (postObj instanceof String) {
                mediaType = MediaType.parse(contentType);
                postData = postObj.toString();
            } else {
                throw new IOException("提交类型错误");
            }
            httpUrl = url;
            httpData = postData;
            httpRet = "InputStream";
            RequestBody requestBody = RequestBody.create(mediaType, postData);
            String getUrl = url + "?" + postData;
            return Objects.requireNonNull(post(getUrl, requestBody, referer).body()).byteStream();
        } catch (IOException e) {
            throw new IOException(e);
        } finally {
            stopWatch.stop();
        }
    }


    /**
     * Get扩展
     *
     * @param url     地址
     * @param referer 来路
     * @return ResponseBody
     * @throws IOException IOException
     */
    private Response get(String url, String referer) throws IOException {
        if (okHttpClient.readTimeoutMillis() != timeOut * 1000) {
            okHttpClient.newBuilder().readTimeout(timeOut, TimeUnit.SECONDS).build();
        }
        Request.Builder builder = new Request.Builder()
                .url(url)
                .removeHeader("User-Agent")
                .addHeader("Accept", accept)
                .addHeader("User-Agent", userAgent);
        if (otherHeaders.size() > 0) {
            otherHeaders.forEach(builder::addHeader);
        }
        if (!StrUtil.isEmpty(referer)) {
            builder.addHeader("Referer", referer);
        }
        if (!keepAlive) {
            builder.addHeader("Connection", "close");
        }
        request = builder
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        response = call.execute();
        return response;
    }

    /**
     * POST扩展
     *
     * @param url         地址
     * @param requestBody requestBody
     * @param referer     referer
     * @return ResponseBody
     * @throws IOException IOException
     */
    private Response post(String url, RequestBody requestBody, String referer) throws IOException {
        if (okHttpClient.readTimeoutMillis() != timeOut * 1000) {
            okHttpClient.newBuilder().readTimeout(timeOut, TimeUnit.SECONDS).build();
        }
        Request.Builder builder = new Request.Builder()
                .url(url)
                .removeHeader("User-Agent")
                .addHeader("Accept", accept)
                .addHeader("User-Agent", userAgent);

        if (otherHeaders.size() > 0) {
            otherHeaders.forEach(builder::addHeader);
        }
        if (!StrUtil.isEmpty(referer)) {
            builder.addHeader("Referer", referer);
        }
        if (!keepAlive) {
            builder.addHeader("Connection", "close");
        }
        request = builder
                .post(requestBody)
                .build();
        Call call = okHttpClient.newCall(request);
        response = call.execute();
        return response;
    }

    /**
     * 添加Cookie
     *
     * @param name   name
     * @param value  value
     * @param path   path
     * @param domain domain
     */
    public void addCookie(String name, String value, String path, String domain) {

        //检测cookie是否存在，存在就先删除后。
        cookieJar.cookieStore.removeIf(s ->
                name.equals(s.getName()) && domain.equals(s.getDomain()) && path.equals(s.getPath())
        );
        HttpCookie httpCookie = new HttpCookie(name, value);
        httpCookie.setDomain(domain);
        httpCookie.setPath(path);
        httpCookie.setMaxAge(60 * 60 * 24 * 365);
        httpCookie.setVersion(0);
        cookieJar.cookieStore.add(httpCookie);
    }

    /**
     * 根据name获取value值
     *
     * @param name   name
     * @param domain domain
     * @return value
     */
    public String getCookieValue(String name, String domain) {
        for (HttpCookie httpCookie : cookieJar.cookieStore) {
            if (httpCookie.getName().equals(name) && httpCookie.getDomain().equals(domain)) {
                return httpCookie.getValue();
            }
        }
        return "";
    }


    /**
     * CookieManager转String
     *
     * @return Cookie字符串
     */
    public String getCookieString() {
        JSONArray cookieArray = JSONUtil.createArray();
        for (HttpCookie item : cookieJar.cookieStore) {
            JSONObject json = JSONUtil.createObj();
            json.put("name", item.getName());
            json.put("value", item.getValue());
            json.put("path", item.getPath());
            json.put("domain", item.getDomain());
            cookieArray.add(json);
        }
        return cookieArray.toString();
    }


    /**
     * String设置Cookie
     *
     * @param cookieStr cookie字符串
     */
    public void setCookie(String cookieStr) {
        //cookieJar.cookieStore = new LinkedList<>();
        if (!JSONUtil.isJson(cookieStr)) {
            return;
        }

        JSONArray jsonArray = JSONUtil.parseArray(cookieStr);
        List<ModelCookie> nodeList = jsonArray.toList(ModelCookie.class);
        for (ModelCookie item : nodeList) {
            //检测cookie是否存在，存在就先删除后。
            cookieJar.cookieStore.removeIf(s ->
                    item.name.equals(s.getName()) && item.domain.equals(s.getDomain()) && item.path.equals(s.getPath())
            );

            HttpCookie httpCookie = new HttpCookie(item.name, item.value);
            httpCookie.setDomain(item.domain);
            httpCookie.setPath(item.path);
            httpCookie.setMaxAge(60 * 60 * 24 * 365);
            httpCookie.setVersion(0);
            cookieJar.cookieStore.add(httpCookie);
        }

    }

    /**
     * 清除Cookie
     */
    public void clearCookie() {
        cookieJar.cookieStore = new LinkedList<>();
    }


    /**
     * 开启本地代理访问
     */
   public void openLocalProxy() {
        String proxyUrl = "127.0.0.1";
        int proxyPort = 8888;
        openProxy(proxyUrl, proxyPort, "", "");

    }

    /**
     * @param proxyUrl  代理地址
     * @param proxyPort 代理端口
     * @param proxyUser 代理账号
     * @param proxyPass 代理密码
     */
    public void openProxy(String proxyUrl, int proxyPort, String proxyUser, String proxyPass) {
        proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyUrl, proxyPort));
        proxyAuthenticator = (route, response) -> {
            String credential = Credentials.basic(proxyUser, proxyPass);
            return response.request().newBuilder()
                    .header("Proxy-Authorization", credential)
                    .build();
        };
        okHttpClient = okHttpClient
                .newBuilder()
                .proxy(proxy)
                .proxyAuthenticator(proxyAuthenticator)
                .build();
    }

    /**
     * 关闭代理访问
     */
    public void closeProxy() {
        proxy = Proxy.NO_PROXY;
        okHttpClient = okHttpClient
                .newBuilder()
                .proxy(proxy)
                .build();
    }

    public Map<String, Object> inputToMap(String html, String formName) {

        Document doc = Jsoup.parse(html);
        Element formEle = doc.getElementById(formName);
        if (formEle == null) {
            formEle = doc.getElementsByClass(formName).get(0);
        }
        if (formEle == null) {
            formEle = doc.select("input[name=" + formName + "]").get(0);
        }

        Map<String, Object> postList = new HashMap<>(16);
        Elements inputs = formEle.select("input");
        for (Element input : inputs) {
            String name = input.attr("name");
            String id = input.attr("id");
            String value = input.attr("value");
            if (name != null) {
                if (!postList.containsKey(name)) {
                    postList.put(name, value);
                }
            } else if (id != null) {
                if (!postList.containsKey(id)) {
                    postList.put(id, value);
                }
            }
        }
        return postList;
    }


    /**
     * JsonObj转MAp
     *
     * @param jsonObject
     * @return
     */
    public Map<String, Object> jsonObjToMap(JSONObject jsonObject) {
        Map<String, Object> data = new LinkedHashMap<>();
        for (String key : jsonObject.keySet()) {
            String value = jsonObject.getStr(key);
            data.put(key, value);
        }
        return data;
    }


    /**
     * @param jsonStr
     * @return
     */
    public Map<String, Object> jsonStrToMap(String jsonStr) {
        Map<String, Object> data = new LinkedHashMap<>();
        JSONObject jsonObject = JSONUtil.parseObj(jsonStr);
        for (String str : jsonObject.keySet()) {
            String value = jsonObject.getStr(str);
            data.put(str, value);
        }
        return data;
    }

    /**
     * 将Map形式的Form表单数据转换为Url参数形式<br>
     * 会自动url编码键和值
     *
     * <pre>
     * key1=v1&amp;key2=&amp;key3=v3
     * </pre>
     *
     * @param paramMap 表单数据
     * @return url参数
     */
    public String toParams(Map<String, ?> paramMap) throws UnsupportedEncodingException {

        StringBuilder stringBuilder = new StringBuilder();
        for (String key : paramMap.keySet()) {
            String value = "";
            if (paramMap.get(key) != null) {
                value = paramMap.get(key).toString();
            }
            stringBuilder.append(URLEncoder.encode(key, encoding));
            stringBuilder.append("=");
            stringBuilder.append(URLEncoder.encode(value, encoding));
            stringBuilder.append("&");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }


    /**
     * 生成一个随机订单号
     *
     * @return
     */
    public String randomOrderId() {
        return "P" + DateUtil.date().toString("yyMMddHHmmssSSS") +
                RandomUtil.randomNumbers(5);
    }

    /**
     * 截取指定字符串中间部分 支持正则表达式
     */
    public String getValue(String content, String s, String e) {
        String regex = "(?<=(" + s + "))[.\\s\\S]*?(?=(" + e + "))";
        Pattern pattern = PatternPool.get(regex, Pattern.DOTALL);
        final Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

    @Data
    static class ModelCookie {
        /**
         * path : /H5
         * domain : jf1001.com
         * name : JSESSIONID
         * value : 2C3C655AA61F37ABA1367C318439C9EF
         */

        private String path;
        private String domain;
        private String name;
        private String value;

    }
}
