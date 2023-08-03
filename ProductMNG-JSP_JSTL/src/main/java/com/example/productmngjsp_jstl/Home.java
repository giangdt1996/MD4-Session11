package com.example.productmngjsp_jstl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/Home")
public class Home extends HttpServlet {
public List<Product> products = new ArrayList<>();


    public void init() throws ServletException {
        products.add(new Product(1,"Iphone 14",1400000,"New 100%"));
        products.add(new Product(2,"Iphone 14",1200000,"Like New 98%"));
        products.add(new Product(3,"SamSung S25",1400000,"New 100%"));
        products.add(new Product(4,"BPhone",1300000,"New 100%"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            getProducts(req, resp);
        } else {
            switch (action) {
                case "delete":
                    products.remove(findById(Integer.parseInt(req.getParameter("id"))));
                    break;
                case "edit":
                    updateProducts(req, resp);
                    break;
                default:
                    break;
            }
            getProducts(req, resp);
        }
    }
    public void getProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("products", products);
        req.getRequestDispatcher("view/listProduct.jsp").forward(req, resp);}
    public void updateProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            req.setAttribute("products", product);
            dispatcher= req.getRequestDispatcher("view/update.jsp");
        }try {
            dispatcher.forward(req, resp);
        }catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        switch (action) {
            case "submit":
                String name = req.getParameter("name");
                double price = Double.parseDouble(req.getParameter("price"));
                String description = req.getParameter("description");
                int id = getnewId();
               products.add(new Product(id, name, price,description));
                getProducts(req, resp);
                break;
            case "update":
                updateProduct(req,resp);
            default:
                break;
        }
    }
    public void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        Product productToUpdate = findById(id);

        if (productToUpdate == null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("error-404.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        productToUpdate.setName(name);
        productToUpdate.setDescription(description);
        productToUpdate.setPrice(price);


        resp.sendRedirect(req.getContextPath() + "/Home");
    }

    public int getnewId() {
        int maxid = 0;
        for (Product s : products) {
            if (s.getId() > maxid) {
                maxid = s.getId();
            }
        }
        return maxid + 1;
    }

    public Product findById(int id) {
        for (Product s : products) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}