package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Ford", 100)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Audi", 5)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("VW", 200)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Mercedes", 600)));

      System.out.println(userService.getUserByCar("Audi", 5));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getUserId());
         System.out.println("First Name = "+user.getUserFirstName());
         System.out.println("Last Name = "+user.getUserLastName());
         System.out.println("Email = "+user.getUserEmail());
         System.out.println("Car = "+user.getUserCar());
         System.out.println();
      }

      context.close();
   }
}
