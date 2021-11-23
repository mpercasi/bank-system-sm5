package com.example.bank.service;

import org.springframework.stereotype.Service;

@Service
public class ClienteServices {

    public String busquedaNumeros(String contra){
        char[] contraChar = contra.toCharArray();
        char[] numero = {'1','2','3','4','5','6','7','8','9','0'};
        for(int i = 0; i<numero.length;i++){
            for (int j=0; j<contraChar.length;j++){
                if (numero[i]==contraChar[j]){
                    return "1";
                }
            }
        }
        return "2";
    }
}
