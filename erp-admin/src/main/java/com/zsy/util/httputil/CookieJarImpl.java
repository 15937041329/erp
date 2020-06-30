package com.zsy.util.httputil;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.net.HttpCookie;
import java.net.URI;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author AAA
 */
public class CookieJarImpl implements CookieJar {
    public List<HttpCookie> cookieStore = new LinkedList<>();

    /**
     * 访问后保存新的Cookie
     *
     * @param httpUrl httpUrl
     * @param cookies cookies
     */
    @Override
    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> cookies) {

        for (Cookie cookieNew : cookies) {
            List<HttpCookie> cookieList = cookieStore.stream().filter(
                    s -> Objects.equals(s.getName(), cookieNew.name())
                            && Objects.equals(s.getDomain(), cookieNew.domain())
                            && Objects.equals(s.getPath(), cookieNew.path())
            ).collect(Collectors.toList());
            if (cookieList.size() > 0) {
                cookieStore.removeAll(cookieList);
            }

        }

        for (Cookie cookieNew : cookies) {
            HttpCookie httpCookie = new HttpCookie(cookieNew.name(), cookieNew.value());
            httpCookie.setDomain(cookieNew.domain());
            httpCookie.setPath(cookieNew.path());
            httpCookie.setMaxAge(60 * 60 * 24 * 365);
            httpCookie.setVersion(0);
            cookieStore.add(httpCookie);
        }

    }

    /**
     * 访问时加入Cookie
     *
     * @param httpUrl httpUrl
     * @return List<Cookie>
     */
    @Override
    public List<Cookie> loadForRequest(HttpUrl httpUrl) {

        List<Cookie> cookies = new LinkedList<>();

        for (HttpCookie cookie : cookieStore) {
            //域名匹配
            if (HttpCookie.domainMatches("." + cookie.getDomain(), httpUrl.host())) {
                //路径匹配
                URI urlUri = httpUrl.uri();
                if (httpUrl.uri().getPath().startsWith(urlUri.getPath())) {

                    Cookie okHttpCookie = new Cookie.Builder()
                            .name(cookie.getName())
                            .value(cookie.getValue())
                            .domain(cookie.getDomain())
                            .path(cookie.getPath())
                            .expiresAt(cookie.getMaxAge())
                            .build();
                    cookies.add(okHttpCookie);
                }
            }
        }
        return cookies;
    }

    public SSLSocketFactory createTrustAllSslFactory(TrustAllManager trustAllManager) {
        SSLSocketFactory ssfFactory = null;
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{trustAllManager}, new SecureRandom());
            ssfFactory = sc.getSocketFactory();
        } catch (Exception ignored) {
        }
        return ssfFactory;
    }


    public HostnameVerifier createTrustAllHostnameVerifier() {
        return (hostname, session) -> true;
    }

}
