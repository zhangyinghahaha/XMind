package com.nowcoder.community.core.pojo;

import org.springframework.stereotype.Component;

/**
 * @author ying.zhang01
 */
public class RsaKey {
    private String publicKey;
    private String privateKey;

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
}
