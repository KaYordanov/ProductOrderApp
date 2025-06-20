package com.app.pizza.Application.ApplicationServices;

import com.app.pizza.Application.ApplicationServices.ServicesInterfaces.ILogIn;
import com.app.pizza.Application.RepositoriesInterfaces.IUserRepository;

public class LogIn implements ILogIn {
    private IUserRepository userRepository;
}
