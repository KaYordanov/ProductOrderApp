package com.app.pizza.Presentation.Controllers;

import com.app.pizza.Application.ApplicationServices.ServicesInterfaces.ICreateUser;
import com.app.pizza.Application.ApplicationServices.ServicesInterfaces.IDeleteUser;
import com.app.pizza.Application.ApplicationServices.ServicesInterfaces.ILogIn;

public class UserController implements BaseController{
    ICreateUser createUser;
    IDeleteUser deleteUser;

}
