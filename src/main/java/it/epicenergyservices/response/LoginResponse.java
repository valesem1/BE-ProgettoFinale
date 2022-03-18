package it.epicenergyservices.response;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {




private final String type = "Bearer";
private String token;
private List<String> roles;
//	private String token;
//	private final String type = "Bearer";
//	private Long id;
//	private String username;
//	private String email;
//	private List<String> roles;
//	private Date expirationTime;
}
