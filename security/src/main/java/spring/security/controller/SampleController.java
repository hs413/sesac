package spring.security.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/sample")
@SecurityRequirement(name = "Authorization")
public class SampleController {
    @Operation(summary = "Sample GET doA")
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/doA")
    public List<String> doA(Principal principal) {
//        System.out.println(principal);
        System.out.println("a");
        return Arrays.asList("AAA", "BBB", "CCC");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/doB")
    public List<String> doB() {
        return Arrays.asList("adminAAA", "adminBBB", "adminCCC");
    }
}
