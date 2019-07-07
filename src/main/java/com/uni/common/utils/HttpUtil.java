package com.uni.common.utils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
* @description Http工具类
*
* @author Created by zc on 2019/6/6
*/
public class HttpUtil {

    /**
     * 发送get请求
     *
     * @author Created by zc on 2019/6/6
     */
    public static String sendGetRequest(String url) throws IOException {
        StringBuilder responseStrBud = new StringBuilder();
        URL realUrl = new URL(url);
        // 打开和URL之间的连接
        URLConnection connection = realUrl.openConnection();
//        connection.setRequestProperty("description", "");    // 设置请求头
        // 建立实际的连接
        connection.connect();
        // 定义 BufferedReader输入流来读取URL的响应
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        String line = "";
        while ((line = in.readLine()) != null) {
            responseStrBud.append(line);
        }
        // 关闭资源
        in.close();
        return responseStrBud.toString();
    }

    /**
     * 发送post请求
     *
     * @author Created by zc on 2019/6/28
     */
    public static String sendPostRequest(String url, String param) throws IOException {

        StringBuilder responseStrBud = new StringBuilder();
        URL realUrl = new URL(url);
        // 打开和URL之间的连接
        URLConnection connection = realUrl.openConnection();
        // 设置请求头
//        connection.setRequestProperty("connection", "Keep-Alive");
//        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Mobile Safari/537.36");
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        // 设置发送数据的格式
        connection.setRequestProperty("Content-Type", "application/json");
        // 发送POST请求必须设置如下两行
        connection.setDoOutput(true);
        connection.setDoInput(true);

        // 获取URLConnection对象对应的输出流
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), StandardCharsets.UTF_8));
        // 发送请求参数
        out.write(param);
        // flush输出流的缓冲
        out.flush();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        String line = "";
        while ((line = in.readLine()) != null) {
            responseStrBud.append(line);
        }
        // 关闭资源
        out.close();
        in.close();
        return responseStrBud.toString();
    }

    /**
     * 解析URL（完整路径）
     *
     * @author Created by zc on 2019/6/10
     */
    public static Map<String, String> parseURL(String url) {
        Map<String, String> returnMap = new HashMap<>();
        if (!url.contains("?")) {
            returnMap.put("baseUrl", url);
            return returnMap;
        }
        String[] arr = url.split("\\?");
        String baseUrl = arr[0];
        returnMap.put("baseUrl", baseUrl);

        String paramStr = arr[1];
        // 解析参数字符串
        String[] paramArr = paramStr.split("&");
        for (String param : paramArr) {
            String[] keyValueArr = param.split("=");
            // 参数以键值对形式放进Map集合
            returnMap.put(keyValueArr[0], keyValueArr[1]);
        }

        return returnMap;
    }

    /**
     * 解析URL参数（只有参数部分的URL）
     *
     * @author Created by zc on 2019/6/10
     */
    public static Map<String, String> parseURLParam(String urlParamStr) {
        Map<String, String> paramMap = new HashMap<>();

        // 解析参数字符串
        String[] paramArr = urlParamStr.split("&");
        for (String param : paramArr) {
            String[] keyValueArr = param.split("=");
            // 参数以键值对形式放进Map集合
            paramMap.put(keyValueArr[0], keyValueArr[1]);
        }

        return paramMap;
    }


}
