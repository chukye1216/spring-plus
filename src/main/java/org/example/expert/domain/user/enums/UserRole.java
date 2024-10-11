package org.example.expert.domain.user.enums;

import org.example.expert.domain.common.exception.InvalidRequestException;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;

public enum UserRole implements GrantedAuthority {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private final String authority;

    UserRole(String authority) {
        this.authority = authority;
    }

    // 권한 값을 반환하는 메서드 (Spring Security에서 사용)
    @Override
    public String getAuthority() {
        return this.authority;
    }

    public static UserRole of(String role) {
        return Arrays.stream(UserRole.values())
                .filter(r -> r.name().equalsIgnoreCase(role))
                .findFirst()
                .orElseThrow(() -> new InvalidRequestException("유효하지 않은 UerRole"));
    }
}
