package com.app.pizza.Infrastructure.Repositories;

import com.app.pizza.Application.RepositoryInterfaces.MySqlUserRepository;
import com.app.pizza.Domain.Models.User;
import com.app.pizza.Domain.Enums.UserType;
import com.app.pizza.Infrastructure.Mappers.UserPersistenceMapper;
import com.app.pizza.Infrastructure.Mappers.UserPersistenceMapperProvider;
import com.app.pizza.Infrastructure.PersistanceModels.UserPersistenceModel;
import com.app.pizza.Infrastructure.DataSource.MySqlUserDataSource;

import java.sql.SQLException;
import java.util.Map;

public class MySqlUserRepositoryImplementation implements MySqlUserRepository {
    MySqlUserDataSource userDataSource;
    //UserPersistenceMapper userMapper;

    // constructor

    @Override
    public <E extends User, P extends UserPersistenceModel> void createNewUser(E user) {
        UserType userType = user.getUserType();

        UserPersistenceMapper<E, P> mapper = UserPersistenceMapperProvider.getMapper(userType);
        userDataSource.persist(mapper.toPersistenceModel(user));

        // trqbwa da vidq kak i kakwo 6e verushtam -> boolean?
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public void updateUser(Long id) {

    }

    @Override
    public <E extends User> E getUserById(Long id){
        return userDataSource.findById(id);
    }

    @Override
    public Long validateLogInCredentitals(String email, String password){
        return userDataSource.validateEmailAndPassword(email, password); // how exactly does exception bubbling work, because it wants me tho throw in method signature
    }

    @Override
    public <E extends User, P extends UserPersistenceModel> E getUser(String email, String password){
        Map<String, Object> userDetails = userDataSource.findByEmailAndPassword(email, password);
        UserType userType = (UserType) userDetails.get("user_type");

        UserPersistenceMapper<E, P> mapper = UserPersistenceMapperProvider.getMapper(userType);
        P userModel = mapper.toPersistenceModel(userDetails);

        return mapper.toEntity(userModel);

        // прявя го пак с конкретни мапери, когато връщам мапера му подавам user_type.
        // конкретните мапери може от Map<> към PersistanceModel и от Entity към PersistanceModel,
        // и PersistanceModel към Entity.
    }

    public boolean checkEmail(String email){

    }
}
