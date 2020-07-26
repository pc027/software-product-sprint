// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
//import com.google.sps.data.allComments;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import com.google.gson.Gson;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {

    ArrayList<String> commentList = new ArrayList<String>();

    /** addtoComments add hardcoded messages into commentList*/
    public void addtoComments() {
        commentList.add("hotdogs");
        commentList.add("french fries");
        commentList.add("soda");
    }

    /** gsonconvertJSON converts ArrayList into a JSON string with GSON library*/
    private String gsonConvertJSON(ArrayList<String> listOfComments) {
        Gson gsonObj = new Gson();
        String json = gsonObj.toJson(listOfComments);
        return json;
    }

    @Override
    /** doGet gives the client form input comments from comments ArrayList */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String jsonStr = gsonConvertJSON(commentList);
        response.setContentType("application/json;");
        response.getWriter().println(jsonStr);
    }

    @Override
    /** doPost adds form input comments into comments ArrayList */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get the input from the form and add to comment ArrayList
        String text = getParameter(request, "comment-input", "");
        commentList.add(text.toString());

        // Redirect back to homepage
        response.sendRedirect("/index.html");
        return;
    }
    /**
    * getParameter
    * @return the request parameter, or the default value if the parameter
    *         was not specified by the client
    */
    public String getParameter(HttpServletRequest request, String input, String defaultValue) {
        String value = request.getParameter(input);
        if (value == null) {
            return defaultValue;
        }
        return value;
    }  

}
