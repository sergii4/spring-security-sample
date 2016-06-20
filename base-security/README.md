### Base Spring Security Configuration

As you probably know two major areas of application security are "authentication" and "authorization" (or "access-control"). 
These are the two main areas that Spring Security targets. 
"Authentication" is the process of establishing a principal is who they claim to be (a "principal" generally means a user, device or some other system which can perform an action in your application).
"Authorization" refers to the process of deciding whether a principal is allowed to perform an action within your application. 
To arrive at the point where an authorization decision is needed, the identity of the principal has already been established by the authentication process. 
These concepts are common, and not at all specific to Spring Security.


## Spring MVC Integration

To enable Spring Security integration with Spring MVC add the *@EnableWebSecurity* annotation to your configuration.
Spring Security provides the configuration using Spring MVC’s *WebMvcConfigurerAdapter*. 
This means that if you are using more advanced options, like integrating with WebMvcConfigurationSupport directly, 
then you will need to manually provide the Spring Security configuration.

## Simple Security Configuration

```java 

package spitter.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.
configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.
configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin().and()
            .httpBasic();
        }
}

```




