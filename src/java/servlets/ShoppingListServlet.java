/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 687159
 */
public class ShoppingListServlet extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        doEverything(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        doEverything(request, response);
    }
    
    private void doEverything(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String item = request.getParameter("item");
        String radio = request.getParameter("select");
        String action = request.getParameter("action");
        String hidden = request.getParameter("hidden");
        String username = request.getParameter("username");
        
        ArrayList<String> itemList = null;
        //String[] itemsL = request.getParameterValues("item");
        boolean login = false;

        try
        {
            switch(action) 
            {
                case "register":
                    if(username == null || username.equals(""))
                    {
                        login = false;
                        request.setAttribute("errorM", "Please enter username.");
                        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                    }
                    else
                    {   
                        login = true;
                        session.setAttribute("username", username);
                        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                    }
                    //getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                    break;
                case "add":
                    itemList = (ArrayList<String>) session.getAttribute("itemList");
                    if(itemList==null)
                    {
                        itemList = new ArrayList<>();
                    }
                    item = request.getParameter("item");
                    itemList.add(item);
                    session.setAttribute("itemList", itemList);
                    request.setAttribute("addM", "Item has been added");
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                    break;
                case "delete":
                    itemList = (ArrayList<String>) session.getAttribute("itemList");
                        //session.removeAttribute("itemList");
                        item = request.getParameter("select");
                        itemList.remove(item);
                        session.setAttribute("itemList", itemList);
                        request.setAttribute("deleteM", "Item has been deleted.");
                        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                    
                    break;
                case "logout":
                    session.invalidate();
                    request.setAttribute("logM", "You have been logged out.");
                    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        }
        finally
        {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }
}
