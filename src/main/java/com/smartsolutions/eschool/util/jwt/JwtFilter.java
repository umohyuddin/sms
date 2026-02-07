package com.smartsolutions.eschool.util.jwt;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
@Slf4j
public class JwtFilter extends OncePerRequestFilter {


    private static final String AUTH_HEADER = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer ";
    private final AuthEntryPointJwt authEntryPoint;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    public JwtFilter(AuthEntryPointJwt authEntryPoint, JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.authEntryPoint = authEntryPoint;

        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {


        try {
            handleCoRelationMDC(request);
            // Get the authorization header from the request
            String authHeader = request.getHeader(AUTH_HEADER);

            if (authHeader == null) {
                String token = request.getParameter("token");
                // Log the token or process it as needed
                System.out.println("Token from query parameter: " + token);
                authHeader = token;
            }

            String requestMethod = request.getMethod();
            String requestURL = request.getRequestURL().toString();
            String requestURI = request.getRequestURI();
            String scheme = request.getScheme(); // http or https
            String serverName = request.getServerName();
            int serverPort = request.getServerPort();
            String contextPath = request.getContextPath();

            StringBuilder baseFQDN = new StringBuilder();
            baseFQDN.append(scheme).append("://").append(serverName);
            baseFQDN.append(":").append(serverPort);
            baseFQDN.append(contextPath);
            log.info("Request Receive at filter \n authHeader - [{}],\n requestURL - [{}],\n requestURI - [{}],\n requestMethod - [{}],\n scheme - [{}],\n serverName - [{}],\n serverPort - [{}],\n contextPath - [{}],\n baseFQDN - [{}]", authHeader, requestURL, requestURI, requestMethod, scheme, serverName, serverPort, contextPath, baseFQDN);
            String path = request.getRequestURI();
            // skip public APIs
            if (path.equals("/api/auth/generateToken") || path.startsWith("/swagger-ui") || path.startsWith("/api/institute/employees/profile-photos")|| path.contains("/profile-photos/")) {
                chain.doFilter(request, response);
                return;
            }

            if (isLoginRequest(requestURL, requestURI)) {
                chain.doFilter(request, response);
                //The return; statement immediately exits the current method and returns from the filter. This ensures that the remaining lines of code in the filter method are not executed for the login request.
                return;
            }

            // If the header is null or doesn't start with "Bearer "
            if (authHeader == null || !authHeader.startsWith(TOKEN_PREFIX)) {
                authEntryPoint.commence(request, response, new BadCredentialsException("Invalid or missing authorization header"));
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            // Extract the JWT token from the header
            String jwtToken = authHeader.substring(TOKEN_PREFIX.length());

            if (jwtUtil.validateJwtToken(jwtToken, response)) {
                // Get the user details from the token
                String userName = jwtUtil.extractClaims(jwtToken).get("email", String.class);
                //Claims claims = jwtUtils.extractClaims(jwtToken);
                //List<Map<String, Object>> roleMaps = (List<Map<String, Object>>) claims.get("userRoles");

//            List<Role> roles = roleMaps.stream()
//                    .map(this::convertMapToRole)
//                    .collect(Collectors.toList());
//            List<Long> ids = new ArrayList<>();

//            for(Role item : roles){
//                ids.add(item.getId());
//            }

                //List<Role> roles = jwtUtils.extractClaims(jwtToken).get("userRoles", List.class);
//                List<Long> ids = roles.stream()
//                        .map(Role::getId)
//                        .filter(Objects::nonNull) // Exclude null IDs
//                        .collect(Collectors.toList());

//            RoleDto roleDto = new RoleDto();
//            roleDto.setRoleIds(ids);
//            roleDto.setEndPoint(requestURI);
//            List<Object[]> o =  roleService.getRoleResourcePermission(roleDto);
//            List<RoleResourcePermissionDTO> roleDto_ = new ArrayList<>();
//
//            for(Object[] item :o){
//                RoleResourcePermissionDTO permissionDTO = new RoleResourcePermissionDTO();
//                permissionDTO.setRRoleId((Long) item[0]);
//                permissionDTO.setRoleName((String) item[1]);
//                permissionDTO.setRrpRoleId(Long.valueOf((Integer) item[2]));
//                permissionDTO.setRrpResourcesPermissionsId(Long.valueOf((Integer) item[3]));
//                permissionDTO.setRpId((Long) item[4]);
//                permissionDTO.setRpResourceId(Long.valueOf((Integer) item[5]));
//
//                permissionDTO.setRpPermissionId(Long.valueOf((Integer) item[6]));
//                permissionDTO.setPermissionName((String) item[7]);
//                permissionDTO.setPId((Long) item[8]);
//                permissionDTO.setReId(Long.valueOf((Integer) item[9]));
//                permissionDTO.setResourceName((String) item[10]);
//                permissionDTO.setMethodType((String) item[11]);
//                permissionDTO.setResourceEndpoint((String) item[12]);
//                roleDto_.add(permissionDTO);
//            }

//                if(roleDto_.isEmpty()){
//                    authEntryPoint.commence(request, response, new BadCredentialsException("You lack the necessary permissions for this action. Contact your administrator for assistance"));
//                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                }
                handleUserNameMDC(userName);
                UserDetails userDetails = userDetailsService.loadUserByUsername(userName);


                // Set the authentication object in the security context
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                //When implementing a custom authentication filter (e.g., JWT authentication filter), after validating the token and extracting user details, you need to set the authenticated user in the security context.
                //If you don't set the authentication in the SecurityContextHolder, Spring Security will not recognize the user as authenticated, and the user will not have access to protected resources.
                // is used in a filter after validating the user to ensure that Spring Security recognizes the user as authenticated for the current request and any subsequent processing within that request.
                // It is essential to set the authentication in the SecurityContextHolder when manually authenticating users.
                //This step ensures the authenticated user's information is available throughout the request lifecycle, enabling Spring Security to enforce authentication and authorization consistently.
                //Without setting the authentication, users will not be recognized as authenticated, leading to access issues and inconsistent application behavior.
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                authEntryPoint.commence(request, response, new BadCredentialsException("Invalid or missing authorization header"));
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            chain.doFilter(request, response);
        } finally {
            clearMDC();
        }

    }


    private void handleCoRelationMDC(HttpServletRequest request) {
        String co_relationId = request.getHeader("correlationId");
        if (StringUtils.isNotBlank(co_relationId)) {
            MDC.put("correlationId", co_relationId);
        } else {
            co_relationId = UUID.randomUUID().toString();
            MDC.put("correlationId", co_relationId);
        }
    }

    private void handleUserNameMDC(String userName) {

        if (StringUtils.isNotBlank(userName)) {
            MDC.put("userName", userName);
        } else {
            MDC.put("userName", "");
        }
    }

    private boolean isLoginRequest(String requestURL, String requestURI) {
        logger.info(String.format("Entering AuthTokenFilter.isLoginRequest() - requestURL: [%s], requestURI: [%s]", requestURL, requestURI));
        // Check the request URL or URI for login-specific patterns
        // You can customize this method based on your application's login URL patterns
        //For example, if the URL of the current request is https://www.example.com/products?id=123, then:
        //getRequestURL() would return: https://www.example.com/products
        //getRequestURI() would return: /products
        //It's important to note that the URL represents the complete address of a resource, while the URI represents the path or identifier that can be used to locate a resource.
        //You can check the HTTP method of the request to identify if it corresponds to a login action. For example, login requests often use the POST method to submit the login
        // requests often include specific parameters, such as username and password. You can examine the request parameters to identify if they match the parameters typically used for login.
        //Login requests may include specific headers or header values that indicate they are related to authentication or login. You can inspect the request headers using request.getHeader("headerName") and check for any login-related headers or specific header values.
        return requestURL.contains("/login") || requestURI.contains("/login") || requestURI.contains("/auth");
    }

    private void clearMDC() {
        MDC.clear();
    }

}