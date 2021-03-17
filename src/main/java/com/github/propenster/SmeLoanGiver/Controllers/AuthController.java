package com.github.propenster.SmeLoanGiver.Controllers;

import com.github.propenster.SmeLoanGiver.Authentication.Models.ERole;
import com.github.propenster.SmeLoanGiver.Authentication.Models.Role;
import com.github.propenster.SmeLoanGiver.Authentication.Models.User;
import com.github.propenster.SmeLoanGiver.Authentication.Payloads.Request.LoginRequest;
import com.github.propenster.SmeLoanGiver.Authentication.Payloads.Request.SignupRequest;
import com.github.propenster.SmeLoanGiver.Authentication.Payloads.Request.UserMakeSmeAccountRequest;
import com.github.propenster.SmeLoanGiver.Authentication.Payloads.Response.JwtResponse;
import com.github.propenster.SmeLoanGiver.Authentication.Payloads.Response.MessageResponse;
import com.github.propenster.SmeLoanGiver.Authentication.Repository.RoleRepository;
import com.github.propenster.SmeLoanGiver.Authentication.Repository.UserRepository;
import com.github.propenster.SmeLoanGiver.Authentication.Security.Jwt.JwtUtils;
import com.github.propenster.SmeLoanGiver.Authentication.Security.Services.UserDetailsImpl;
import com.github.propenster.SmeLoanGiver.Entity.NewSMEAccountRequest;
import com.github.propenster.SmeLoanGiver.Repository.SMEAccountOpeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.github.propenster.SmeLoanGiver.Controllers.SMEAccountOpeningController.encodeFileToBase64;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    SMEAccountOpeningRepository smeRepo;


    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles, userDetails.getSme_account()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
    @PostMapping("/updateUserMakeNewSmeAccount")
    public ResponseEntity<?> updateUserMakeNewSmeAccount(@RequestBody UserMakeSmeAccountRequest userSmeAccountRequest) {

        //findUser
        User existingUser = userRepository.findByUsername(userSmeAccountRequest.getUsername()).orElse(null);
        if(userSmeAccountRequest.getUsername() != null)
            existingUser.setUsername(userSmeAccountRequest.getUsername());
        if(userSmeAccountRequest.getEmail() != null)
            existingUser.setEmail(userSmeAccountRequest.getEmail());
        if(userSmeAccountRequest.getSme_account() == null)
            {}
            //existingUser.setSme_account(userSmeAccountRequest.getSme_account());
        NewSMEAccountRequest dto = new NewSMEAccountRequest();
        dto.setFirstName(userSmeAccountRequest.getSme_account().getFirstName());
        dto.setLastName(userSmeAccountRequest.getSme_account().getLastName());
        dto.setOtherNames(userSmeAccountRequest.getSme_account().getOtherNames());
        dto.setPhoneNumber(userSmeAccountRequest.getSme_account().getPhoneNumber());
        dto.setHomeAddress(userSmeAccountRequest.getSme_account().getHomeAddress());
        dto.setOccupation(userSmeAccountRequest.getSme_account().getOccupation());
        dto.setBusinessName(userSmeAccountRequest.getSme_account().getBusinessName());
        dto.setBusinessRcNumber(userSmeAccountRequest.getSme_account().getBusinessRcNumber());
        dto.setBusinessCategory(userSmeAccountRequest.getSme_account().getBusinessCategory());
        dto.setSizeOfBusiness(userSmeAccountRequest.getSme_account().getSizeOfBusiness());
        dto.setIdentificationType(userSmeAccountRequest.getSme_account().getIdentificationType());
        dto.setIdentificationCard(encodeFileToBase64(userSmeAccountRequest.getSme_account().getIdentificationCard()));
        dto.setIdentificationNumber(userSmeAccountRequest.getSme_account().getIdentificationNumber());
        dto.setIdentificationIssuedDate(userSmeAccountRequest.getSme_account().getIdentificationIssuedDate());
        dto.setIdentificationExpiredDate(userSmeAccountRequest.getSme_account().getIdentificationExpiredDate());
        dto.setBankName(userSmeAccountRequest.getSme_account().getBankName());
        dto.setBankAccountNumber(userSmeAccountRequest.getSme_account().getBankAccountNumber());
        dto.setBVN(userSmeAccountRequest.getSme_account().getBVN());
        dto.setBankAccountType(userSmeAccountRequest.getSme_account().getBankAccountType());
        dto.setBankStatementSixMonths(encodeFileToBase64(userSmeAccountRequest.getSme_account().getBankStatementSixMonths()));//file encodeTobase64
        dto.setBusinessProposal(encodeFileToBase64(userSmeAccountRequest.getSme_account().getBusinessProposal()));
        dto.setRequestedLoanAmount(userSmeAccountRequest.getSme_account().getRequestedLoanAmount());
        dto.setRepaymentPeriod(userSmeAccountRequest.getSme_account().getRepaymentPeriod());
        dto.setLoanPercent(userSmeAccountRequest.getSme_account().getLoanPercent());
        dto.setReferee1FirstName(userSmeAccountRequest.getSme_account().getReferee1FirstName());
        dto.setReferee1LastName(userSmeAccountRequest.getSme_account().getReferee1LastName());
        dto.setReferee1OtherNames(userSmeAccountRequest.getSme_account().getReferee1OtherNames());
        dto.setReferee1PhoneNumber(userSmeAccountRequest.getSme_account().getReferee1PhoneNumber());
        dto.setReferee1Email(userSmeAccountRequest.getSme_account().getReferee1Email());
        dto.setReferee1Occupation(userSmeAccountRequest.getSme_account().getReferee1Occupation());
        dto.setReferee1Address(userSmeAccountRequest.getSme_account().getReferee1Address());
        dto.setReferee1SignatureDoc(encodeFileToBase64(userSmeAccountRequest.getSme_account().getReferee1SignatureDoc()));

        dto.setReferee2FirstName(userSmeAccountRequest.getSme_account().getReferee2FirstName());
        dto.setReferee2LastName(userSmeAccountRequest.getSme_account().getReferee2LastName());
        dto.setReferee2OtherNames(userSmeAccountRequest.getSme_account().getReferee2OtherNames());
        dto.setReferee2PhoneNumber(userSmeAccountRequest.getSme_account().getReferee2PhoneNumber());
        dto.setReferee2Email(userSmeAccountRequest.getSme_account().getReferee2Email());
        dto.setReferee2Occupation(userSmeAccountRequest.getSme_account().getReferee2Occupation());
        dto.setReferee2Address(userSmeAccountRequest.getSme_account().getReferee2Address());
        dto.setReferee2SignatureDoc(encodeFileToBase64(userSmeAccountRequest.getSme_account().getReferee2SignatureDoc()));

        dto.setAcceptedTermsAndAgreements(userSmeAccountRequest.getSme_account().isAcceptedTermsAndAgreements());
        dto.setAccountNumber((long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L);
        //now save the DTO
        smeRepo.save(dto);
        existingUser.setSme_account(dto);

        //long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;


        userRepository.save(existingUser);

        return ResponseEntity.ok(new MessageResponse("User updated successfully!\n\"You have successfully created a new SME Loan Account\\n We will review your application and get back to you.\n Your AccountNumber is : " + dto.getAccountNumber()));
    }



}