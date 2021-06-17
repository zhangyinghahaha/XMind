package com.nowcoder.community;

import java.io.IOException;

public class WKTests {
    public static void main(String[] args) {
        String cmd = "D:\\dev\\wkhtmltopdf\\bin\\wkhtmltopdf.exe https://redis.com.cn/ D:\\dev\\data\\wk-pdfs\\2.pdf";
        try {
            Runtime.getRuntime().exec(cmd);
            System.out.println("生成成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
