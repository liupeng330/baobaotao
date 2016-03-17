package baobaotao.web.controller;

import baobaotao.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController
{
    @RequestMapping(value = "/handle91.html", method = RequestMethod.POST)
    public String handle91(@Valid @ModelAttribute("user")User user, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "/user/register3";
        }
        else
        {
            return "/user/showuser";
        }
    }

    @RequestMapping(value = "/handle91.html", method = RequestMethod.GET)
    public String displayUser(ModelMap model)
    {
        model.addAttribute("user", new User());
        return "/user/register3";
    }
}
