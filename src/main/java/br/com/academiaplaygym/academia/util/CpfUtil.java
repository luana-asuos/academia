package br.com.academiaplaygym.academia.util;

public class CpfUtil {

	public static String formatarCPF(String cpf) {
        // Remove todos os caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) return "CPF inválido";

        // Formata o CPF para o padrão "XXX.XXX.XXX-XX"
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
    }

    public static boolean isCPFValido(String cpf) {
        // Remove todos os caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) return false;

        // Após o tratamento, verifica se o CPF é válido
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 > 9) digito1 = 0;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 > 9) digito2 = 0;

        // Verifica se os dígitos calculados batem com os dígitos informados
        return (cpf.charAt(9) - '0' == digito1 && cpf.charAt(10) - '0' == digito2);
    }
}
