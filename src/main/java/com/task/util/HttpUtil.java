package com.task.util;

import com.google.protobuf.GeneratedMessageV3;
import com.googlecode.protobuf.format.JsonFormat;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Runtime.getRuntime;

public class HttpUtil{

    public static HttpResponse doPost(HttpPost post, GeneratedMessageV3 message) throws IOException {
        HttpClient httpclient = HttpClients.createDefault();
        String requestUrl = post.getURI().toString();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(message.toByteArray());
        InputStreamEntity inputStreamEntity = new InputStreamEntity(inputStream);
        post.setEntity(inputStreamEntity);

        post.addHeader("Content-Type", "application/x-protobuf");
        for (Header header : post.getAllHeaders()) {
            System.out.println(header.getName() + ":" + header.getValue());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("curl -XPOST ");
        for (Header header : post.getAllHeaders()) {
            sb.append(" -H \"").append(header.getName()).append(":").append(header.getValue()).append("\"");
        }

        String jsonBody = JsonFormat.printToString(message);
        jsonBody = jsonBody.replace("\"", "\\\"");
        sb.append(" -d \"").append(jsonBody).append("\"");
        sb.append(" ").append(requestUrl);

        System.out.println(sb.toString());
        return httpclient.execute(post);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        /*String a="aaddd,dfes,dfg";
        int b=a.lastIndexOf(",");
        System.out.println(b);

        System.out.println(a.substring(b));*/
        /*String aa="sddssa";
        System.out.println(aa.concat("jjk"));
        boolean xx=false;
        if(!xx){
            System.out.println("aaaaaaaaaaaaaaaa");
        }*/

        /*Runtime runtime = getRuntime();
        try {
            Process process =runtime.exec(new String[]{"sh","-c","su"});
            process.waitFor();
            System.out.println(process.exitValue());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }*/
        String command = "chmod -R 777 /opt/upload/real";
        String[] cmd = new String[]{"sh","-c",command+"&"};
        Process pro = Runtime.getRuntime().exec(cmd);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pro.getInputStream()));
        String reader="";
        while ((reader=bufferedReader.readLine()) != null){
            System.out.println("read==="+reader);
        }
        pro.waitFor();
        System.out.println(pro.exitValue());
    }
}
