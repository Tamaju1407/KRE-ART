package com.indigo.KRE_ART.controllers;

import com.indigo.KRE_ART.models.KreartService;
import com.indigo.KRE_ART.models.Subscription;
import com.indigo.KRE_ART.models.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "SubscriptionsController", urlPatterns = "/subscriptions")
public class SubscriptionsController {
    KreartService service;
    String url;

    public SubscriptionsController() {
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
                List<Subscription> subscriptions = service.findAllSubscriptions();
                request.setAttribute("subscriptions", subscriptions);
                url = "list.jsp";
            }
            if (action.equals("show")){
                int id = Integer.parseInt(request.getParameter("id"));
                Subscription subscription = service.findSubscriptionById(id);
                request.setAttribute("subscription", subscription);
                url = "show.jsp";
            }
            if (action.equals("new")){
                url = "new.jsp";
            }
            if (action.equals("edit")){
                int id = Integer.parseInt(request.getParameter("id"));
                Subscription subscription = service.findSubscriptionById(id);
                request.setAttribute("subscription", subscription);
                url = "edit.jsp";
            }
        }

        if(method.equals("POST")){
            if(action.equals("create")){
                int id = service.getMaxIdSubscription() + 1;
                Person person = service.findPersonById(Integer.parseInt(request.getParameter("person")));
                int type = Integer.parseInt(request.getParameter("type"));
                Double payment = Double.parseDouble(request.getParameter("payment"));
                Date datestarted = new Date() ;
                Date dateexpired = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(datestarted);
                switch (type){
                    case 1:
                        calendar.add(calendar.MONTH, 1);
                        dateexpired =calendar.getTime();
                        break;
                    case 2:
                        calendar.add(calendar.MONTH, 2);
                        dateexpired =calendar.getTime();
                        break;
                    case 3:
                        calendar.add(calendar.MONTH, 3);
                        dateexpired =calendar.getTime();
                        break;

                }
                boolean execute = service.createSubscription(id,person,type,payment,datestarted,dateexpired);
                List<Subscription> subscriptions = service.findAllSubscriptions();
                request.setAttribute("subscriptions", subscriptions);
                url = "list.jsp";
            }
            if(action.equals("update")){
                int id = Integer.parseInt(request.getParameter("int"));
                Subscription subscription = service.findSubscriptionById(id);
                Person person = service.findPersonById(Integer.parseInt(request.getParameter("person")));
                int type = Integer.parseInt(request.getParameter("type"));
                Double payment = Double.parseDouble(request.getParameter("payment"));
                boolean execute = service.updateSubscription(id,person,type,payment,subscription.getDatestarted(),subscription.getDateexpiration());
                List<Subscription> subscriptions = service.findAllSubscriptions();
                request.setAttribute("subscriptions", subscriptions);
                url = "list.jsp";
            }
        }
        request.getRequestDispatcher(url).forward(request,response);
    }
}

