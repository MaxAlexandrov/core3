package com.exchanger.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("error")
public class ErrorRedirectController implements ErrorController {

        private static final String PATH = "/error";

        @RequestMapping(value = "/pageNotFound", method = { RequestMethod.GET, RequestMethod.POST })
        public String pageNotFound() {
            return "pageNotFound";
        }

        @RequestMapping(value = "/accessDenied", method = { RequestMethod.GET, RequestMethod.POST })
        public String accessDenied() {
            return "accessDenied";
        }

        @RequestMapping(value = PATH)
        public String error() {
            return "error";
        }

        @Override
        public String getErrorPath() {
            return PATH;
        }
}
