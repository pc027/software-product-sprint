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

    ArrayList<String> comments = new ArrayList<String>();
    
    /** addtoComments adds strings to comments ArrayList */
    public void addtoComments() {
        comments.add("hotdogs");
        comments.add("french fries");
        comments.add("soda");
    }

    /** convertJSON converts ArrayList into a JSON string manually*/
    private String convertJSON(ArrayList<String> commentslist) {
        String json = "{";
        json += "\"mainCourse\": ";
        json += "\"" + comments.get(0) + "\"";
        json += ", ";
        json += "\"sideDish\": ";
        json += "\"" + comments.get(1) + "\"";
        json += ", ";
        json += "\"drinks\": ";
        json += "\"" + comments.get(2) + "\"";
        json += "}";
        return json;
    }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    addtoComments();
    String json = convertJSON(comments);
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

}
