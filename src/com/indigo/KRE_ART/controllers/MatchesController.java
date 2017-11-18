package com.indigo.KRE_ART.controllers;

import com.indigo.KRE_ART.models.KreartService;
import com.indigo.KRE_ART.models.Match;
import com.indigo.KRE_ART.models.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "MatchesController", urlPatterns = "/matches")
public class MatchesController extends javax.servlet.http.HttpServlet{
    KreartService service;
    String url;

    public MatchesController() {
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
            if (action.equals("index")){
                List<Match> matches = service.findAllMatches();
                request.setAttribute("matches", matches);
                url = "list.jsp";
            }
            if (action.equals("show")){
                int id = Integer.parseInt(request.getParameter("id"));
                Match match = service.findMatchById(id);
                request.setAttribute("match", match);
                url = "show.jsp";
            }
            if (action.equals("new")){
                url = "new.jsp";
            }
            if (action.equals("edit")){
                int id = Integer.parseInt(request.getParameter("id"));
                Match match = service.findMatchById(id);
                request.setAttribute("match", match);
                url = "edit.jsp";
            }
        }

        if(method.equals("POST")){
            if(action.equals("create")){
                int id = service.getMaxIdMatch() + 1;
                Person personsend = service.findPersonById(Integer.parseInt(request.getParameter("personsend")));
                Person personrecive = service.findPersonById(Integer.parseInt(request.getParameter("personrecive")));
                String message = request.getParameter("message");
                int rate = 0;
                boolean execute = service.createMatch(id,personsend,personrecive,message,rate);
                List<Match> matches = service.findAllMatches();
                request.setAttribute("matches", matches);
                url = "list.jsp";
            }
            if(action.equals("update")){
                int id = Integer.parseInt(request.getParameter("int"));
                Person personsend = service.findPersonById(Integer.parseInt(request.getParameter("personsend")));
                Person personrecive = service.findPersonById(Integer.parseInt(request.getParameter("personrecive")));
                String message = request.getParameter("message");
                int rate = 0;
                boolean execute = service.updateMatch(id,personsend,personrecive,message,rate);
                List<Match> matches = service.findAllMatches();
                request.setAttribute("matches", matches);
                url = "list.jsp";
            }
        }
        request.getRequestDispatcher(url).forward(request,response);
    }
}
