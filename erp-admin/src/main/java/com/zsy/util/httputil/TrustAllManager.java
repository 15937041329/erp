package com.zsy.util.httputil;

import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;


/**
 * 信任未签名使用的重写
 *
 * @author AAA
 */
public class TrustAllManager implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) {
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

}
