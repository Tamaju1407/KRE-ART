package com.indigo.KRE_ART.controllers;

import com.indigo.KRE_ART.models.KreartService;
import com.indigo.KRE_ART.models.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "PersonsController", urlPatterns = "/persons")
public class PersonsController extends javax.servlet.http.HttpServlet {
    KreartService service;
    String url;

    public PersonsController() {
        super();
        service = new KreartService();
        url = "";
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest("POST", request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest("GET", request, response);
    }

    private void processRequest(String method, HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");

        if(method.equals("GET")){
            if(action.equals("index")){
                List<Person> persons = service.findAllPersons();
                request.setAttribute("persons", persons);
                url = "listPersons.jsp";
            }
        }
    }
}
