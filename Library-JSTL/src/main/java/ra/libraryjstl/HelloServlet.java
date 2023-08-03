package ra.libraryjstl;

import ra.libraryjstl.database.DBUtils;
import ra.libraryjstl.model.Dept;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // truy van du lieu tu DB
        List<Dept> list = DBUtils.queryDepartments();

        //Luu du lieu vao thuoc tinh department cua request
        req.setAttribute("departments",list);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jstl_example.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}