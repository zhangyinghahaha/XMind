package com.nowcoder.community;

import com.nowcoder.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
public class MailTest {
    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail() {
        Context context = new Context();
        context.setVariable("username", "张颖");
        String content = templateEngine.process("/mail/demo", context);
        mailClient.sendMail("zhangyingmark@gmail.com", "Spring Mail Test", content);
    }
}
