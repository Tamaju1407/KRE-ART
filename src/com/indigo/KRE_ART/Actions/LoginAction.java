package com.indigo.KRE_ART.Actions;

import com.indigo.KRE_ART.models.KreartService;
import com.indigo.KRE_ART.models.Person;
import com.indigo.KRE_ART.models.PersonAll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "LoginAction", urlPatterns = "/login")
public class LoginAction extends javax.servlet.http.HttpServlet{
    KreartService service;
    String url;

    public LoginAction() {
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
        if(method.equals("POST")) {
            String error = "";
            if(action.equals("verify")){
                Person person = service.findPersonByEmail(request.getParameter("email"));
                if(person != null){
                    if(person.getPassword() == request.getParameter("password")){
                        PersonAll personAll = service.createPersonAll(person);
                        request.setAttribute("personall", personAll);
                        url = "miperfil.jsp";
                    }
                    else{
                        error = "error";
                        request.setAttribute("error", error);
                        url = "login.jsp";
                    }
                }
                else{
                    error = "error";
                    request.setAttribute("error", error);
                    url = "login.jsp";
                }
            }
        }
        request.getRequestDispatcher(url).forward(request,response);
    }
}
