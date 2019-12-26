package tij.temp;

import tij.stream.FileToWords;

/**
 * Informational class
 *
 * @author zhangying
 * @date 2019/12/18
 */
public class Informational {
    public static void main(String[] args) throws Exception {
        System.out.println(
                FileToWords.stream("aaa").count()
        );
        System.out.println(FileToWords.stream("aa").min(String.CASE_INSENSITIVE_ORDER));
    }
}
