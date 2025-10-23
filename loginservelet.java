package com.school.management.servlet;

import com.google.gson.Gson;
import com.school.management.dao.Database;
import com.school.management.model.User;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LoginServlet extends HttpServlet {
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        BufferedReader reader = req.getReader();
        User loginUser = gson.fromJson(reader, User.class);

        User validUser = Database.validateUser(loginUser.getUsername(), loginUser.getPassword(), loginUser.getRole());

        res.setContentType("application/json");
        if (validUser != null) {
            res.setStatus(HttpServletResponse.SC_OK);
            res.getWriter().write(gson.toJson(validUser));
        } else {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
