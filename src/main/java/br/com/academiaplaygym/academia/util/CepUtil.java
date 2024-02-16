package br.com.academiaplaygym.academia.util;

public class CepUtil {

    public static String formatarCEP(String cep) {
        // Remove todos os caracteres não numéricos
        cep = cep.replaceAll("[^0-9]", "");

        // Verifica se o CEP tem 8 dígitos
        if (cep.length() != 8) {
            return "CEP inválido";
        }

        // Formata o CEP para o padrão "XXXXX-XXX"
        return cep.substring(0, 5) + "-" + cep.substring(5);
    }

    public static boolean isCEPValido(String cep) {
        // Remove todos os caracteres não numéricos
        cep = cep.replaceAll("[^0-9]", "");

        // Verifica se o CEP tem 8 dígitos
        if (cep.length() != 8) {
            return false;
        }

        // CEP é considerado válido
        return true;
    }
	
}
