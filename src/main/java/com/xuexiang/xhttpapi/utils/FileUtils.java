package com.xuexiang.xhttpapi.utils;

import org.springframework.util.StringUtils;

import java.io.File;

/**
 * @author xuexiang
 * @since 2018/7/18 下午4:30
 */
public final class FileUtils {

    private FileUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 生成随机的文件名
     *
     * @return
     */
    public static String randomFileName(String filePath) {
        String fileExtension = getFileExtension(filePath);
        return RandomGUID.getRandomGUID() + "." + fileExtension;
    }


    /**
     * 获取全路径中的文件拓展名
     *
     * @param filePath 文件路径
     * @return 文件拓展名
     */
    public static String getFileExtension(final String filePath) {
        if (StringUtils.isEmpty(filePath)) return filePath;
        int lastPoi = filePath.lastIndexOf('.');
        int lastSep = filePath.lastIndexOf(File.separator);
        if (lastPoi == -1 || lastSep >= lastPoi) return "";
        return filePath.substring(lastPoi + 1);
    }
}
