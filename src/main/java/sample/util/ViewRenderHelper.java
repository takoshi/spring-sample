package sample.util;

import lombok.RequiredArgsConstructor;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class ViewRenderHelper {
    private final ViewResolver viewResolver;

    public String render(ModelAndView mv) {

        try {
            View view = viewResolver.resolveViewName(mv.getViewName(), Locale.JAPAN);

            if(view == null) {
                throw new RuntimeException("not found view template");
            }

            HttpServletRequest httpServletRequest = new MockHttpServletRequest();
            MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();

            view.render(mv.getModel(), httpServletRequest, mockHttpServletResponse);

            return new String(mockHttpServletResponse.getContentAsByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
