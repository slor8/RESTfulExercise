package edu.matc;

import edu.matc.entity.User;
import edu.matc.persistence.UserDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/UserService")
public class UserService {

    private UserDao userDao = new UserDao();

    /**
     * Returns all user from the database.
     * /UserService
     * @return
     */

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<User> getUsers() {
        List<User> listOfUsers = userDao.getAllUsers();
        return listOfUsers;

    }

    /**
     * Returns all user from the database by user id
     * /UserService/id
     * @return
     */

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User getByUserId(@PathParam("id") int id) {
        return userDao.getById(id);
    }


}

