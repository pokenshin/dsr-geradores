package br.com.desireworld.service.calculadores;

import br.com.desireworld.core.ValorMag;

public class CalculadorValor {

    public CalculadorValor() {
    }

    public int ValorMagToInteger(ValorMag numero){
        int result = 0;
        String zeros = "";
        int numeroLen = String.valueOf(numero.getValor()).length();

        for (int i=0; i < numero.getMag() - numeroLen; i++){
            zeros = zeros + "0";
        }

        result = Integer.parseInt(String.valueOf(numero.getValor()) + zeros);

        return result;
    }

    public ValorMag MultiplicaValorMag(ValorMag valor1, ValorMag valor2){
        return new ValorMag();
    }
}
