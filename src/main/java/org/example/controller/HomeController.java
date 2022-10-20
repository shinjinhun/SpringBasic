package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Set;



@Controller
public class HomeController {

    @RequestMapping("/")
    public String showIndexPage() {
        return "index";
    }

    @RequestMapping("/home")
    public String showHomePage(Locale locale, Model model, HttpServletRequest request) {

        MainMenu mainMenu = new MainMenu();

        try {
            System.out.println("main_menu_nm = " + mainMenu.main_menu());
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate );
        model.addAttribute("name", "엠투" );

        // getParameter 출력 첫번째
        Set<String> keySet = request.getParameterMap().keySet();
        for(String key: keySet) {
            System.out.println(key + ": " + request.getParameter(key));
        }

        // getParameter 출력 두번째
        Enumeration names = request.getParameterNames();
        while(names.hasMoreElements()) {
            String key = (String) names.nextElement();
            System.out.println(key + ": " + request.getParameter(key));
        }

        return "home";
    }
}
