package com.github.mdjc.youmeal.web;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
	@RequestMapping("/principal")
	public Principal principal(Principal principal) {
		return principal;
	}
}
