package com.mine.channel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Cleanup;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.CRC32;

/**
 * @author yanyimim
 * @since 2019/12/25 15:14
 */
public class ChannelTest {

    @Test
    public void  method1() throws IOException {
        Path path = Paths.get("src","main","java","com","mine","file","Enum.java");
        @Cleanup FileChannel fc = FileChannel.open(path);
        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY,0,8000);
        CRC32 crc32 = new CRC32();
        while(mbb.hasRemaining()){
            int i = mbb.get();
            crc32.update(i);
            System.out.println((char)i);
        }
        long checksum = crc32.getValue();
        System.out.println(checksum);
    }

    @Test
    public void method2() throws IOException {
        Path path = Paths.get("src","main","java","com","mine","file","Enum.java");
        Path topath = Paths.get("src","main","java","com","mine","file","Enum_to.java");
        @Cleanup FileChannel fc = FileChannel.open(path);
        @Cleanup FileChannel fco = FileChannel.open(topath);
        System.out.println(fc.size());
        MappedByteBuffer buffer = fc.map(FileChannel.MapMode.READ_WRITE,0,fc.size());
        fco.write(buffer);
    }

    @Test
    public void method3(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("sss","wangwu");
        map.put("aaa","ccc");
        String str = JSON.toJSONString(map);
        System.out.println(str);
    }

    @Test
    public void method4(){
        JSONObject obj = new JSONObject();
        obj.put("aaa","ccc");
        obj.put("ddd","ddd");
        System.out.println(String.valueOf(obj.toJSONString()));
    }
}
