package com.demo;

import org.beetl.core.BeetlKit;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ying.zhang01
 */
public class BeetlTest {
    public static void main(String[] args) throws IOException {
        StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
        Configuration configuration = Configuration.defaultConfiguration();

        GroupTemplate groupTemplate = new GroupTemplate(configuration);

        Template template = groupTemplate.getTemplate("hello, ${name}! age: ${age} sex: ${sex}");
        Map<String, Object> params = new HashMap<>(4);
        params.put("name", "zhangying");
        params.put("age", 12);
        template.binding(params);

        String result2 = BeetlKit.render("hello, ${name}! age: ${age}", params);

        String result = template.render();
        System.out.println(result);
        System.out.println(result2);
    }
}
