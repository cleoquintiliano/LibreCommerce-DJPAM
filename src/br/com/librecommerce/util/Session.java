/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.util;

import java.util.HashMap;

/**
 *
 * @author Clovis
 */
public class Session {
    
    private final HashMap<String, Object> sessionMap = new HashMap<>();
    private static Session session;
    
    private Session() {}
    
    public static Session getInstance() {
        if (session == null) session = new Session();
        return session;
    }
    
    public HashMap<String, Object> getSessionMap() {
        return sessionMap;
    }
    
}
