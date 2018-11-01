package com.bayuedekui.paasbackend.utiltest;

import com.bayuedekui.paasbackend.utils.PswMD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UtilTest {
    
    @Test
    public void testPswMD5() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println(PswMD5Util.EncoderByMd5("zhegnkui"));
        
        
    }
}
