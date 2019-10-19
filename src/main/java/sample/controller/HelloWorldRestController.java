package sample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import sample.response.HelloWorldResponse;
import sample.util.ViewRenderHelper;

@RestController
@RequiredArgsConstructor
public class HelloWorldRestController {

    private final ViewRenderHelper viewRenderHelper;

    @RequestMapping
    public HelloWorldResponse helloWorld() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("index");
        modelAndView.addObject("message", "Hello, world!");

        return new HelloWorldResponse(200,viewRenderHelper.render(modelAndView));
    }
}
