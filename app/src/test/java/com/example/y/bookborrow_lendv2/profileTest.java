package com.example.y.bookborrow_lendv2;

import android.media.Image;
import android.provider.ContactsContract;

import org.junit.Test;
import static org.junit.Assert.*;

public class profileTest {

    public profileTest(){}


    @Test
    public void setName(){
        NormalUser user2 = new NormalUser();
        user2.setName("testName");

        assertEquals(user2.getName(),"testName");
    }


    @Test
    public void testsetPhone(){
        lender lender1= new lender();
        Integer new_number= 992238201;
        lender1.setPhone(new_number);
        assertEquals(lender1.getPhone(),new_number);
    }



    @Test
    public void testsetEmail(){
        lender lender1= new lender();
        String new_email= "hahah2GM@gmail.com";
        lender1.setEmail(new_email);
        assertEquals(lender1.getEmail(),new_email);
    }

}
