package org.zerock.b2.board.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
@Log4j2
@RequiredArgsConstructor
public class SocialUserService extends DefaultOAuth2UserService {


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        log.info("-------------------");
        log.info("-------------------");

        log.info(userRequest);

        String serviceName = userRequest.getClientRegistration().getClientName();

        OAuth2User oAuth2User = super.loadUser(userRequest);

        java.util.Map<String, Object>  paramMap = oAuth2User.getAttributes();

        paramMap.forEach((k,v) -> {
            log.info("key: " + k + " value: " + v);
        });

        log.info("-------------------");
        log.info("-------------------");
        log.info("-------------------");

        log.info("===========================");
        log.info(serviceName);

        LinkedHashMap accountMap = (LinkedHashMap) paramMap.get("kakao_account");

        String email = (String) accountMap.get("email");

        log.info("email: " + email);

        return oAuth2User;
    }
}
