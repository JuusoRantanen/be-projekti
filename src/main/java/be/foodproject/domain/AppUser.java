
  package be.foodproject.domain;
  
  import javax.annotation.Generated; import javax.persistence.Column; import
  javax.persistence.Entity; import javax.persistence.GeneratedValue; import
  javax.persistence.GenerationType; import javax.persistence.Id; import
  javax.persistence.JoinColumn; import javax.persistence.ManyToOne; import
  javax.persistence.Table;
  
  
  @Entity public class AppUser {
  
  @Id
  
  @GeneratedValue(strategy = GenerationType.AUTO) private Long id; private
  String role;
  
  @Column(name = "username", nullable = false, unique = true) private String
  username;
  
  @Column(name = "password", nullable = false) private String passwordHash;
  
  public AppUser(Long id, String role, String username, String passwordHash) {
  super(); this.id = id; this.role = role; this.username = username;
  this.passwordHash = passwordHash; }
  
  
  
  public AppUser(String role, String username, String passwordHash) { super();
  this.role = role; this.username = username; this.passwordHash = passwordHash;
  }
  
  
  
  public AppUser() { super();
  // TODO Auto-generated constructor stub
  }
  
  public Long getId() { return id; }
  
  public void setId(Long id) { this.id = id; }
  
  public String getRole() { return role; }
  
  public void setRole(String role) { this.role = role; }
  
  public String getUsername() { return username; }
  
  public void setUsername(String username) { this.username = username; }
  
  public String getPasswordHash() { return passwordHash; }
  
  public void setPasswordHash(String passwordHash) { this.passwordHash =
  passwordHash; }
  
  @Override public String toString() { return "AppUser [id=" + id + ", role=" +
  role + ", username=" + username + ", passwordHash=" + passwordHash + "]"; }
  
  
  
  
  }
 