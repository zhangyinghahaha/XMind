package com.nowcoder.community.web.controller;

import com.nowcoder.community.config.WKProperties;
import com.nowcoder.community.entity.Event;
import com.nowcoder.community.event.EventProducer;
import com.nowcoder.community.event.EventTopicConstants;
import com.nowcoder.community.util.CommunityUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ying.zhang01
 */
@Controller
public class ShareController {
    private static final Logger logger = LoggerFactory.getLogger(ShareController.class);

    @Autowired
    private EventProducer eventProducer;
    @Autowired
    private WKProperties wkProperties;

    private String domain = "http://localhost:8080";
    private String contextPath = "/community";

    @RequestMapping(path = "/share", method = RequestMethod.GET)
    @ResponseBody
    public String share(String url) {
        // 生成文件名
        String fileName = CommunityUtil.generateUUID() + ".png";
        Event event = new Event()
                .setTopic(EventTopicConstants.TOPIC_SHARE)
                .setData("url", url)
                .setData("fileName", fileName);
        eventProducer.fireEvent(event);

        // 返回访问路径
        Map<String, Object> map = new HashMap<>();
        map.put("shareUrl", domain + contextPath + "/share/image/" + fileName);
        return CommunityUtil.getJsonString(0, null, map);
    }

    @RequestMapping(path = "/share/image/{fileName}", method = RequestMethod.GET)
    public void getShareImage(@PathVariable String fileName, HttpServletResponse response) {
        if (StringUtils.isBlank(fileName)) {
            throw new IllegalArgumentException("文件名不能为空!");
        }
        response.setContentType("image/png");
        Path path = Paths.get(wkProperties.getStorage() + "/" + fileName);
        try {

            OutputStream os = response.getOutputStream();
            FileInputStream fis = new FileInputStream(path.toFile());
            byte[] buffer = new byte[1024];
            int b = 0;
            while ((b=fis.read(buffer)) != -1) {
                os.write(buffer, 0, b);
            }
        } catch (IOException exception) {
           logger.error("文件下载失败！");
        }
    }
}
