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
        if (valor1.toString() == "1m2" || valor1.toString() == "10m1"){
            return valor2;
        } else if (valor2.toString() == "1m2" || valor2.toString() == "10m1"){
            return valor1;
        } else if (valor1.getValor() == 0 || valor2.getValor() == 0){
            return new ValorMag();
        } else {
            int magFinal = (valor1.getMag() + valor2.getMag()) -2;
            int valorFinal = (valor1.getValor() * valor2.getValor());
            while(valorFinal > 99){
                valorFinal /=  10;
                magFinal += 1;
            }
            return new ValorMag(valorFinal, magFinal);
        }
    }
    
    public ValorMag MultiplicaValorMag(ValorMag valor, int multiplicador){
        if (multiplicador == 1){
            return valor;
        } else if (valor == new ValorMag() || multiplicador == 0){
            return new ValorMag();
        } else{
            return this.MultiplicaValorMag(valor, this.IntToValorMag(multiplicador));
        }
    }

    public ValorMag IntToValorMag(int numero) {
        int  magnitude;
        int valor;
        ValorMag result;
        String numeroString = String.valueOf(numero);

        //Se for numero inteiro ou decimal maior que 10
        magnitude = numeroString.length();
        if (magnitude > 1){
            valor = Integer.parseInt(numeroString.substring(0, 2));
        }else{
            valor = Integer.parseInt(numeroString + "0");
        }
        result = new ValorMag(valor, magnitude);
        return result;
    }

    public ValorMag DoubleToValorMag(double numero){
        int  magnitude;
        int valor;
        ValorMag result;
        String numeroString = String.valueOf(numero);

        //Se o numero decimal for menor que 10
        if (numero < 10){
            //Se o numero decimal for maior que 1
            if (numero > 1){
                magnitude = 1;
                numeroString = Character.toString(numeroString.charAt(0)) + Character.toString(numeroString.charAt(2));
                int valorNumber = Integer.parseInt(numeroString);
                result = new ValorMag(valorNumber, magnitude);
                return result;
            }else{
                //Se o numero decimal for menor que 1
                magnitude = 0;

                if (numeroString.contains(",")){
                    numeroString = numeroString.split("\\,")[1];
                }else{
                    numeroString = numeroString.split("\\.")[1];
                }

                while (numeroString.startsWith("0", 0)){
                    magnitude = magnitude - 1;
                    numeroString = numeroString.substring(1, numeroString.length());
                }

                if (numeroString.length() > 3)
                    numeroString = numeroString.substring(2, numeroString.length() - 2);

                valor = Integer.parseInt(numeroString);

                if (valor < 10){
                    valor = valor * 10;
                }

                result = new ValorMag(valor, magnitude);

                return result;
            }
        }else{
            //Se o numero decimal for maior que 10, descarta quebrados
            if (numeroString.contains(",")){
                numeroString = numeroString.split(",")[0];
            } else{
                numeroString = numeroString.split(".")[0];
            }
            return this.IntToValorMag(Integer.parseInt(numeroString));
        }
    }
}
