package com.nowcoder.community.util;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangying
 */
@Component
public class SensitiveFilter {
    private static final Logger logger = LoggerFactory.getLogger(SensitiveFilter.class);
    private static final String REPLACE_STR = "***";

    private TrieNode rootNode = new TrieNode();

    @PostConstruct
    public void init() {
        try(
                InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("sensitive-words.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        ) {
            String keyword = null;
            while ((keyword = reader.readLine()) != null) {
                this.addKeyword(keyword);
            }

        } catch (IOException e) {
            logger.error("加载敏感词文件失败:" + e.getMessage());
        }

    }

    /**
     *
     * @param text
     * @return
     */
    public String filter(String text) {
        if (StringUtils.isBlank(text)) {
            return null;
        }

        // 指针1：指向敏感词树
        TrieNode tempNode = rootNode;
        int begin = 0;
        int position = 0;
        // 结果
        StringBuilder stringBuilder = new StringBuilder();

        while (position < text.length()) {
            char c = text.charAt(position);

            // 跳过符号
            if (isSymbol(c)) {
                // 若指针处于根节点,将此符号记录结果
                if(tempNode == rootNode) {
                    stringBuilder.append(c);
                    begin++;
                }
                position++;
                continue;
            }

            // 检查下级节点
            tempNode = tempNode.getSubNode(c);
            if (tempNode == null) {
                stringBuilder.append(text.charAt(begin));
                position = ++begin;
                tempNode = rootNode;
            } else if (tempNode.isKeyWordEnd()) {
                // 发现敏感词
                stringBuilder.append(REPLACE_STR);
                begin = ++position;
                tempNode = rootNode;
            } else {
                position++;
            }
        }

        // 将最后一批字符计入结果
        stringBuilder.append(text.substring(begin));

        return stringBuilder.toString();
    }

    private boolean isSymbol(Character c) {
        return !CharUtils.isAsciiAlpha(c) && (c < 0x2E80 || c > 0x9FFF);
    }

    private void addKeyword(String keyword) {
        TrieNode tempNode = rootNode;
        for (int i=0; i < keyword.length(); i++) {
            char c = keyword.charAt(i);
            TrieNode subNode = tempNode.getSubNode(c);
            if (subNode == null) {
                subNode = new TrieNode();
                tempNode.addSubNode(c, subNode);
            }

            tempNode = subNode;

            // 设置结束标识
            if (i == keyword.length() - 1) {
                tempNode.setKeyWordEnd(true);
            }
        }
    }

    private class TrieNode {
        // 关键词结束标识
        private boolean isKeyWordEnd = false;
        // 子节点(下级字符=>下级节点)
        private Map<Character, TrieNode> subNodes = new HashMap<>();

        public void addSubNode(Character c, TrieNode node) {
            subNodes.put(c, node);
        }

        public TrieNode getSubNode(Character c) {
            return subNodes.get(c);
        }

        public boolean isKeyWordEnd() {
            return isKeyWordEnd;
        }

        public void setKeyWordEnd(boolean keyWordEnd) {
            isKeyWordEnd = keyWordEnd;
        }
    }
}
