/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.controlador;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Vincenzo Angelone
 */
public class ControladorNumeros {


    public BigInteger multiplicar(BigInteger n1, BigInteger n2) {
        BigInteger resultado = n1.multiply(n2);
        return resultado;
    }

    public boolean modulo(BigInteger val) {
        if (!val.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
            return true;
        }
        return false;
    }

}

