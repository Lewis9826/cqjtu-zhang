package edu.cqjtu.zhang.demo;


import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.FileOutputStream;
import java.io.IOException;

public class HttpClientDemo {
    public static void main(String[] args) {
        //创建客户端
        CloseableHttpClient client = HttpClients.createDefault();

        HttpUriRequest request = RequestBuilder.get("http://www.baidu.com").build();

        try {
            //发送请求，得到响应
            CloseableHttpResponse response = client.execute(request);
            //判断是否正常返回
            if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
                //将结果写到本地
                response.getEntity().writeTo(new FileOutputStream("F:/tmp/baodu.html"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
