package com.indigo.KRE_ART.Actions;

import com.indigo.KRE_ART.models.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
                    if(person.getPassword().equals(request.getParameter("password"))){
                        PersonAll personAll = service.createPersonAll(person);
                        List<Image> images = service.findAllImagesByPerson(person);
                        request.setAttribute("personall", personAll);
                        request.setAttribute("images", images);
                        url = "perfil.jsp";
                    }
                    else{
                        error = "errorpassword";
                        request.setAttribute("error", error);
                        request.setAttribute("person", person);
                        url = "login.jsp";
                    }
                }
                else{
                    error = "Error Person Null";
                    request.setAttribute("error", error);
                    request.setAttribute("person", person);
                    url = "login.jsp";
                }
            }
        }
        request.getRequestDispatcher(url).forward(request,response);
    }
}
