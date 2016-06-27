package com.getman.security.util;


import com.getman.domain.entity.Permission;
import com.getman.security.domain.PermissionCentricUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Various utility Spring-Security related methods.
 */
@Component
public final class SecurityUtils {

    public static final long NONEXISTENT_USER_ID = -1L;

    private SecurityUtils() {
    }

    /**
     * Returns current user login.
     *
     * @return login name in string representation.
     */
    public static String getCurrentUserLogin() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof UserDetails) {
                return ((UserDetails) principal).getUsername();

            } else if (principal instanceof String) {
                return (String) principal;
            }
        }
        return null;
    }

    /**
     * Checks existing security context to belong to authorized user.
     *
     * @return true if current user is authorized, false otherwise.
     */
    public static boolean isAuthenticated() {

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Collection<? extends GrantedAuthority> authorities =
                securityContext.getAuthentication().getAuthorities();

        if (authorities != null) {
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals("ROLE_ANONYMOUS")) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Retrieves current authenticated user information.
     *
     * @return {@link User} containing user info.
     */
    public static User getCurrentUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof User) {
                return (User) authentication.getPrincipal();
            }
        }
        throw new IllegalStateException("User not found!");
    }

    /**
     * Retrieves current authenticated user ID.
     *
     * @return {@link long} user ID.
     */
    public static long getCurrentUserId() {
        User currentUser = getCurrentUser();
        if (currentUser instanceof PermissionCentricUserDetails) {
            return ((PermissionCentricUserDetails) currentUser).getUserId();
        }
        return NONEXISTENT_USER_ID;
    }

    /**
     * Checks current user to have specified role.
     *
     * @param authority role name.
     * @return true if currently authenticated user has the specified role name among authorities, false otherwise.
     */
    public static boolean isCurrentUserInRole(String authority) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                UserDetails springSecurityUser = (UserDetails) principal;
                return
                        springSecurityUser
                                .getAuthorities()
                                .contains(new SimpleGrantedAuthority(authority));
            }
        }
        return false;
    }

    /**
     * Checks currently authenticated user for having specified {@link Permission} among roles.
     *
     * @param permission <code>toString()</code> representation of {@link Permission}
     * @return true if the specified permission is found in any of the user's roles, false otherwise.
     */
    public static boolean hasPermission(String permission) {
        return hasPermission(Permission.valueOf(permission));
    }

    /**
     * Checks currently authenticated user for having specified {@link Permission} among roles.
     *
     * @param permission {@link Permission} instance.
     * @return true if the specified permission is found in any of the user's roles, false otherwise.
     */
    public static boolean hasPermission(Permission permission) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (permission != null && authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof PermissionCentricUserDetails) {
                return
                        ((PermissionCentricUserDetails) principal)
                                .getPermissions()
                                .contains(permission);
            }
        }
        return false;
    }
}
