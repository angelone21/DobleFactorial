/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.controlador;

import edu.cecar.modelo.FactorialHilo;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vincenzo Angelone
 */
public class ServletControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int procesadores = Runtime.getRuntime().availableProcessors();
        if (request.getParameter("accion").equals("calcular")) {
            ControladorNumeros cn = new ControladorNumeros();
            FactorialHilo cf;
            BigInteger numeroCalcular = new BigInteger(request.getParameter("numero"));
            BigInteger inicio;
            BigInteger indice;
            BigInteger finals;
            ArrayList<FactorialHilo> hilos = new ArrayList<>();
            //procesadores = (int) request.getAttribute("cores");
            System.out.println("PROCESAD" + procesadores);
            // System.out.println("RESAULTSADO: "+ cf.factorial(new BigInteger("19")));
            try {
                if (numeroCalcular.compareTo(BigInteger.ZERO) == 0 || numeroCalcular.compareTo(BigInteger.ONE) == 0) {
                    //  JTextResultado.setText(1 + "");
                    request.setAttribute("resultado", "1");
                    request.setAttribute("numero", numeroCalcular);
                    request.getRequestDispatcher("VistaPrincipal.jsp").forward(request, response);
                } else {
                    if (cn.modulo(numeroCalcular) == false) {
                        //par    
                        if (procesadores == 1) {
                            cf = new FactorialHilo(new BigInteger("2"), numeroCalcular);
                            cf.start();
                            cf.join();
                            //    JTextResultado.setText(cf.obtenerValor() + "");
                            request.setAttribute("resultado", cf.obtenerValor());
                            request.setAttribute("numero", numeroCalcular);
                            request.setAttribute("cores", procesadores);
                            request.getRequestDispatcher("VistaPrincipal.jsp").forward(request, response);
                        } else {
                            inicio = new BigInteger("2");
                            indice = ((numeroCalcular.divide(new BigInteger("2"))).divide(BigInteger.valueOf(procesadores)));
                            finals = indice.multiply(new BigInteger("2"));
                            System.out.println("indiceasdf " + indice);
                            BigInteger resultado = new BigInteger("1");
                            for (int i = 0; i < procesadores; i++) {
                                System.out.println("Inicio: " + inicio);
                                System.out.println("Indice: " + finals);
                                cf = new FactorialHilo(inicio, finals);
                                hilos.add(cf);
                                cf.start();
                                if (i == procesadores - 2) {
                                    System.out.println("asd");
                                    inicio = finals.add(new BigInteger("2"));
                                    finals = numeroCalcular;
                                } else {
                                    inicio = finals.add(new BigInteger("2"));
                                    finals = finals.multiply(new BigInteger("2"));
                                }

                            }
                            for (FactorialHilo hilo : hilos) {
                                hilo.join();
                            }
                            for (FactorialHilo hilo : hilos) {
                                resultado = resultado.multiply(hilo.obtenerValor());
                            }
                            System.out.println("R " + resultado);
                            //  JTextResultado.setText(resultado + "");
                            request.setAttribute("resultado", resultado);
                            request.setAttribute("numero", numeroCalcular);
                            request.setAttribute("cores", procesadores);
                            request.getRequestDispatcher("VistaPrincipal.jsp").forward(request, response);
                        }

                    } else {
                        if (procesadores == 1) {
                            cf = new FactorialHilo(new BigInteger("3"), numeroCalcular);
                            cf.start();
                            cf.join();
                            // JTextResultado.setText(cf.obtenerValor() + "");
                            request.setAttribute("resultado", cf.obtenerValor());
                            request.setAttribute("numero", numeroCalcular);
                            request.setAttribute("cores", procesadores);
                            request.getRequestDispatcher("VistaPrincipal.jsp").forward(request, response);
                        } else {
                            //inpar
                            inicio = new BigInteger("3");
                            indice = ((numeroCalcular.divide(new BigInteger("2"))).divide(BigInteger.valueOf(procesadores)));
                            finals = indice.multiply(new BigInteger("2"));
                            finals = finals.add(BigInteger.ONE);
                            System.out.println("indiceasdf " + indice);
                            BigInteger resultado = new BigInteger("1");
                            for (int i = 0; i < procesadores; i++) {
                                System.out.println("Inicio: " + inicio);
                                System.out.println("Indice: " + finals);
                                cf = new FactorialHilo(inicio, finals);
                                hilos.add(cf);
                                cf.start();
                                if (i == procesadores - 2) {
                                    System.out.println("asd");
                                    inicio = finals.add(new BigInteger("2"));
                                    finals = numeroCalcular;
                                } else {
                                    inicio = finals.add(new BigInteger("2"));
                                    finals = finals.add(indice.multiply(new BigInteger("2")));
                                }

                            }
                            for (FactorialHilo hilo : hilos) {
                                hilo.join();
                            }
                            for (FactorialHilo hilo : hilos) {
                                resultado = resultado.multiply(hilo.obtenerValor());
                            }
                            System.out.println("R " + resultado);
                            //JTextResultado.setText(resultado + "");
                            request.setAttribute("resultado", resultado);
                            request.setAttribute("numero", numeroCalcular);
                            request.setAttribute("cores", procesadores);
                            request.getRequestDispatcher("VistaPrincipal.jsp").forward(request, response);
                        }

                    }
                }

            } catch (Exception e) {

            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
