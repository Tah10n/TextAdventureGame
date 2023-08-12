import org.example.Location;
import org.example.TextAdventureGame;
import org.example.TextAdventureServlet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@ExtendWith(MockitoExtension.class)
public class TextAdventureServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Spy
    private TextAdventureGame game;

    private TextAdventureServlet servlet;

    @BeforeEach
    public void setUp() {

        servlet = new TextAdventureServlet();
        servlet.setGame(game);
    }

    @Test
    public void testDoGetWithAction() throws ServletException, IOException {

        Mockito.when(request.getParameter("input")).thenReturn("выпить пива");
        Mockito.when(request.getRequestDispatcher("/game.jsp")).thenReturn(requestDispatcher);

        servlet.doGet(request, response);


        Mockito.verify(request, Mockito.times(1)).setAttribute("location", Location.HOBBITON.getTitle());
        Mockito.verify(request, Mockito.times(1)).setAttribute("description", "После пива вы очнулись в своей кровати, не помня чем закончился вчерашний вечер");
        Mockito.verify(request, Mockito.times(1)).setAttribute("game", game);
        Mockito.verify(requestDispatcher, Mockito.times(1)).forward(request, response);
    }

    @Test
    public void testDoGetWithNullAction() throws ServletException, IOException {
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(request.getSession().getAttribute("playerName")).thenReturn("Player");
        Mockito.when(request.getParameter("input")).thenReturn(null);

        Mockito.when(request.getRequestDispatcher("/game.jsp")).thenReturn(requestDispatcher);

        servlet.doGet(request, response);

        //
        Mockito.verify(request, Mockito.times(1)).setAttribute("location", Location.HOBBITON.getTitle());
        Mockito.verify(request, Mockito.times(1)).setAttribute("description", "Выберите действие, Player");
        Mockito.verify(request, Mockito.times(1)).setAttribute("game", game);
        Mockito.verify(requestDispatcher, Mockito.times(1)).forward(request, response);
    }

    @Test
    public void testDoGetWhenGameEnded() throws ServletException, IOException {

        Mockito.when(request.getParameter("input")).thenReturn("рискнуть и забрать сокровища у дракона");
        Mockito.when(request.getRequestDispatcher("/game.jsp")).thenReturn(requestDispatcher);

        servlet.doGet(request, response);


        Mockito.verify(game).isGameEnded();

        Mockito.verify(request, Mockito.times(1)).setAttribute("location", Location.LONELY_MOUNTAIN.getTitle());

        Mockito.verify(request, Mockito.times(1)).setAttribute("game", game);
        Mockito.verify(requestDispatcher, Mockito.times(1)).forward(request, response);
    }
}
