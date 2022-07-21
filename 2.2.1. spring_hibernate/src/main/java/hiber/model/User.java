package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn (name = "car_id")
   private Car car;

   public User() {}
   
   public User(String firstName, String lastName, String email, Car car) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.car = car;
   }

   public Long getUserId() {
      return id;
   }

   public void setUserId(Long id) {
      this.id = id;
   }

   public String getUserFirstName() {
      return firstName;
   }

   public void setUserFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getUserLastName() {
      return lastName;
   }

   public void setUserLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getUserEmail() {
      return email;
   }

   public void setUserEmail(String email) {
      this.email = email;
   }

   public Car getUserCar() {return car; }

   public void setUserCar(Car car) {this.car = car; }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", car=" + car +
              '}';
   }
}
