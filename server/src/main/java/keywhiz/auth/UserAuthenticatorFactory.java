package keywhiz.auth;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.auto.service.AutoService;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.jackson.Discoverable;
import io.dropwizard.java8.auth.Authenticator;
import keywhiz.service.daos.UserDAO;

@AutoService(Discoverable.class)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
public interface UserAuthenticatorFactory extends Discoverable {
  /**
   * Builds an authenticator from username/password credentials to a {@link User}.
   */
  Authenticator<BasicCredentials, User> build(UserDAO userDAO);
}
