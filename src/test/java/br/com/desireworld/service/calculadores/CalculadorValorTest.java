package br.com.desireworld.service.calculadores;

import br.com.desireworld.core.ValorMag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadorValorTest {

    CalculadorValor calculador;

    @BeforeEach
    void setUp() {
        this.calculador = new CalculadorValor();
    }

    @Test
    //Testa se está convertendo 10m3 para 100
    void valorMagToInteger_10m3_to_100() {
        ValorMag valor = new ValorMag(10, 3);
        assertEquals(100, calculador.ValorMagToInteger(valor));
    }

    @Test
    //Testa se está multiplicando 10m3 por 10m2 e dando 10m4
    void multiplicaValorMag_10m3_10m2() {
        ValorMag valor1 = new ValorMag(10, 3);
        ValorMag valor2 = new ValorMag(10, 2);
        ValorMag resultado = new ValorMag(10, 4);
        assertEquals(resultado, calculador.MultiplicaValorMag(valor1, valor2));
    }

    @Test
    //Testa se está convertendo 2500 em 25m4
    void IntToValorMag(){
        ValorMag resultado = new ValorMag(25, 4);
        assertEquals(resultado, calculador.IntToValorMag(2500));
    }

    @Test
    //Testa se está convertendo 0,35 para 35m0
    void DoubleToValorMag(){
        ValorMag resultado = new ValorMag(35, 0);
        assertEquals(resultado, calculador.DoubleToValorMag(0.35));
    }

    @Test
    //Testa se está dividingo 1000 (10m4) por 50 (50m2) e dando 20 (20m2)
    void DivideValorMag_10m4_50m2(){
        ValorMag resultado = new ValorMag(20, 2);
        ValorMag valorMag = new ValorMag(10, 4);
        ValorMag divisor = new ValorMag(50, 2);
        assertEquals(resultado, calculador.DivideValorMag(valorMag, divisor));
    }

    @Test
    //Testa se está dividindo 1000 (10m4) por 50 e dando 20 (20m2)
    void DivideValorMag_10m4_50(){
        ValorMag resultado = new ValorMag(20, 2);
        ValorMag valorMag = new ValorMag(10, 4);
        int divisor = 50;
        assertEquals(resultado, calculador.DivideValorMag(valorMag, divisor));
    }

    @Test
    //Testa se 25% de 1000 é 250
    void CalculaPorcentagem(){
        assertEquals(250, calculador.CalculaPorcentagem(25, 1000));
    }

    @Test
    //Testa se 10m4 + 25m3 = 12m4
    void SomaValorMag(){
        ValorMag valor1 = new ValorMag(10, 4);
        ValorMag valor2 = new ValorMag(25, 3);
        ValorMag resultado = new ValorMag(12, 4);
        assertEquals(resultado, calculador.SomaValorMag(valor1, valor2));
    }

    @Test
    //Testa se 95m4 - 50m4 = 45m4
    void SubtraiValorMag(){
        ValorMag valor1 = new ValorMag(95, 4);
        ValorMag valor2 = new ValorMag(50, 4);
        ValorMag resultado = new ValorMag(45, 4);
        assertEquals(resultado, calculador.SubtraiValorMag(valor1, valor2));
    }
}