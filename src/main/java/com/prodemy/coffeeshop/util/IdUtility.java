package com.prodemy.coffeeshop.util;

import java.util.UUID;

public class IdUtility {
    
    public String letterFirstUUID() {
        
        String uuid = UUID.randomUUID().toString();
        
        while(Character.isDigit(uuid.charAt(0))) {
            uuid = UUID.randomUUID().toString();
        }
        
        return uuid;
        
    }
}
