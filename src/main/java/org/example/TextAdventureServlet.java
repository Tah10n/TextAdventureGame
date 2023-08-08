package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/game")
public class TextAdventureServlet extends HttpServlet {
    private TextAdventureGame game;

    @Override
    public void init() {
        game = new TextAdventureGame(new Scene(Location.HOBBITON));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("input");
        String description = "";
        String location = "";
        if (action == null) {
            description = "Выберите действие, " + request.getSession().getAttribute("playerName");
        } else {
            Scene curScene = game.travelToScene(action);
            game.setCurSceneAndLocation(curScene);
            description = curScene.getDescription();
            location = game.getCurrentLocation().getTitle();
        }

        request.setAttribute("location", location);
        request.setAttribute("description", description);
        request.setAttribute("game", game);

        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }
}
