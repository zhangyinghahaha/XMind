package com.nowcoder.community.web.modular.auth.controller;

import com.google.code.kaptcha.Producer;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.RsaKeyService;
import com.nowcoder.community.service.UserService;
import com.nowcoder.community.util.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RsaKeyService rsaKeyService;

    @Autowired
    private Producer kapcha;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String getRegisterPage() {
        return "/site/register";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(Model model, User user) {
        Map<String, Object> map = userService.register(user);
        if (map == null || map.isEmpty()) {
            model.addAttribute("msg", "注册成功，请尽快激活");
            model.addAttribute("target", "/index");
            return "/site/operate-result";
        } else {
            model.addAttribute("usernameMsg", map.get("usernameMsg"));
            model.addAttribute("passwordMsg", map.get("passwordMsg"));
            model.addAttribute("emailMsg", map.get("emailMsg"));
            return "/site/register";
        }
    }

    @RequestMapping(path = "/activation/{userId}/{code}", method = RequestMethod.GET)
    public String activation(Model model, @PathVariable("userId") int userId, @PathVariable("code") String code) {
        int result = userService.activation(userId, code);
        switch (result) {
            case CommunityConstant.ACTIVATION_SUCCESS:
                model.addAttribute("msg", "激活成功，您的账号已经可以正常使用");
                model.addAttribute("target", "/login");
                break;
            case CommunityConstant.ACTIVATION_REPEAT:
                model.addAttribute("msg", "无效操作，账号已经激活过了！");
                model.addAttribute("target", "/index");
                break;
            default:
                model.addAttribute("msg", "激活失败，激活码不正确！");
                model.addAttribute("target", "/index");
                break;
        }
        return "/site/operate-result";
    }

    @RequestMapping(path = "/kaptcha", method = RequestMethod.GET)
    public void getKaptcha(HttpServletResponse response) {
        String text = kapcha.createText();
        BufferedImage bufferedImage = kapcha.createImage(text);

        // 验证码归属
        String kaptchaOwner = CommunityUtil.generateUUID();
        Cookie cookie = new Cookie("kaptchaOwner", kaptchaOwner);
        cookie.setMaxAge(60);
        cookie.setPath(contextPath);
        response.addCookie(cookie);

        // 将验证码存入redis
        String kaptchaKey = RedisKeyUtil.getKaptchaKey(kaptchaOwner);
        redisTemplate.opsForValue().set(kaptchaKey, text, 60, TimeUnit.SECONDS);

        response.setContentType("image/png");
        try{
            OutputStream os = response.getOutputStream();
            ImageIO.write(bufferedImage, "png", os);
        } catch (IOException e) {
            logger.error("响应验证码失败:" + e.getMessage());
        }
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "/site/login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(String username, String password, String code, boolean rememberMe,
                        Model model, HttpServletResponse response, @CookieValue(value = "kaptchaOwner", required = false) String kaptchaOwner) {
        // 检查验证码
        String kaptcha = null;
        if (StringUtils.isNotBlank(kaptchaOwner)) {
            String kaptchaKey = RedisKeyUtil.getKaptchaKey(kaptchaOwner);
            kaptcha = (String) redisTemplate.opsForValue().get(kaptchaKey);
        }
        if (StringUtils.isBlank(kaptcha) || StringUtils.isBlank(code) || !kaptcha.equalsIgnoreCase(code)) {
            model.addAttribute("codeMsg", "验证码超时或不正确");
            return "/site/login";
        }

        // 检查账号，密码
        // 用私钥解密用户名，密码
        String privateKey = rsaKeyService.getPrivateKey(username);
        password = RsaUtil.privateDecrypt(password, privateKey);
        int expiredSeconds = rememberMe ? CommunityConstant.REMEMBER_EXPIRED_SECONDS : CommunityConstant.DEFAULT_EXPIRED_SECONDS;

        Map<String, Object> map = userService.login(username, password, expiredSeconds);
        if (map.containsKey("ticket")) {
            rsaKeyService.deleteKeyPair(username);
            Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
            cookie.setPath(contextPath);
            cookie.setMaxAge(expiredSeconds);
            response.addCookie(cookie);
            return "redirect:/index";
        } else {
            model.addAttribute("usernameMsg", map.get("usernameMsg"));
            model.addAttribute("passwordMsg", map.get("passwordMsg"));
            return "/site/login";
        }
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(@CookieValue("ticket") String ticket) {
        userService.logout(ticket);
        SecurityContextHolder.clearContext();
        return "redirect:/login";
    }

    @RequestMapping(path = "/rsa/publicKey/{username}", method = RequestMethod.GET)
    @ResponseBody
    public String getRsaPublicKey(@PathVariable(required = true) String username) {
        String publicKey = rsaKeyService.getPublicKey(username);
        Map<String, Object> map = new HashMap<>();
        map.put("publicKey", publicKey);
        return CommunityUtil.getJsonString(0, "ok", map);
    }
}
