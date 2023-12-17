package com.example.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StockCrawlerServiceImpl {


    //@Autowired
    //@Qualifier("eastmoneyStockInfoParser")
    //private StockInfoParser stockInfoParser;

    public static void main(String[] args) {

        //// 初始化Spring容器
        //ApplicationContext context = new AnnotationConfigApplicationContext(StockInfoParser.class);
        //
        //// 获取MyAutowiredClass的实例
        //StockInfoParser bean = context.getBean(StockInfoParser.class);
        // 创建 HttpClient 实例
        HttpClient httpClient = HttpClients.createDefault();

        // 构建 GET 请求
        HttpGet httpGet = new HttpGet("http://20.push2.eastmoney.com/api/qt/clist/get?pn=1&pz=10000000&np=1&fid=f3&fields=f12,f13,f14&fs=m:0+t:6,m:0+t:13,m:0+t:80,m:0+t:81+s:2048,m:1+t:2,m:1+t:23,b:MK0021,b:MK0022,b:MK0023,b:MK0024");

        try {
            // 发送请求并获取响应
            HttpResponse response = httpClient.execute(httpGet);

            // 获取响应码
            int statusCode = response.getStatusLine().getStatusCode();

            System.out.println("Response Code: " + statusCode);
            // 读取响应内容
            String responseBody = EntityUtils.toString(response.getEntity());
            //responseBody
            //if code.startswith('300') or code.startswith('688'):
            JSONObject jsonObject = JSONObject.parseObject(responseBody);
            //System.out.println(jsonObject);
            JSONObject data = jsonObject.getJSONObject("data");
            JSONArray diff2 = data.getJSONArray("diff");


               //System.out.println("---"+diff2);
            // 使用 Stream 过滤 JSON 数组元素

            //JSONArray filteredArray = diff2.stream()
            //        .filter(jsonObj -> {
            //            String temp = ((JSONObject) jsonObj).getString("f12");
            //            String temp2 = ((JSONObject) jsonObj).getString("f14");
            //
            //            return temp.indexOf("688")==-1 &&temp2.indexOf("ST")==-1;
            //        })
            //        .collect(Collectors.toCollection(JSONArray::new));
            System.out.println(diff2);
            System.out.println(diff2.size());
            //System.out.println(filteredArray);
            //long count = diff2.stream()
            //        .filter(jsonObj -> {
            //            String temp = ((JSONObject) jsonObj).getString("f12");
            //            String temp2 = ((JSONObject) jsonObj).getString("f14");
            //            return temp.indexOf("688")==-1 && temp2.indexOf("ST")==-1;
            //        }).count();
            ////System.out.println("---"+data);
            //System.out.println(count);
            //System.out.println("---"+filteredArray);
            //Iterator<Object> iterator = diff2.stream().iterator();
            //int i = 0;
            //int k = 0;
            //StringBuffer stringBuffer = new StringBuffer();
            //
            //while (iterator.hasNext()) {
            //    Map next = (Map) iterator.next();
            //
            //    if ( next.get("f12").toString().lastIndexOf("60")==0||next.get("f12").toString().lastIndexOf("00")==0 ||next.get("f12").toString().lastIndexOf("30")==0) {
            //        i++;
            //
            //
            //        stringBuffer.append(next.get("f12")).append(",").append(next.get("f14"));
            //        if ((next.get("f14").toString().indexOf("ST")==0)) {
            //            k++;
            //        }
            //    }
            //}
            //System.out.println(stringBuffer);
            //System.out.println(i);
            //System.out.println(i);
            if (responseBody != null) {
                // 创建实现了接口的类的实例
                StockInfoParser stockInfoParser = new StockInfoParser() {
                    @Override
                    public List<EmStock> parseStockInfoList(String content) {
                        return null;
                    }
                };

                // 调用接口中的方法
                //List<StockInfoParser.EmStock> list = bean.parseStockInfoList(responseBody);
                //list = list.stream().filter(v -> v.getStockInfo().getExchange() != null).collect(Collectors.toList());
            }

            //System.out.println("Response Body:\n" + responseBody);

        } catch (IOException e) {
            e.printStackTrace();
        }



}



}