package br.com.biblioteca.util;

import br.com.biblioteca.exception.CampoObrigatorioException;

public class ValidacaoUtil {
    private ValidacaoUtil(){
    }

    public static String validarCampoObrigatorio(String valor, String nomeCampo){
        if(valor == null || valor.isBlank()){
            throw new CampoObrigatorioException(nomeCampo);
        }
        return valor.trim();
    }
}
