package artntech.system.penalty.serviceImpl;

import artntech.system.penalty.domain.User;

import artntech.system.penalty.dto.SignInReq;
import artntech.system.penalty.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtServiceImpl jwtServiceImpl;

    public UserServiceImpl(final PasswordEncoder passwordEncoder,
                           final UserRepository userRepository, final JwtServiceImpl jwtServiceImpl) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.jwtServiceImpl = jwtServiceImpl;
    }

    /**
     * 회원 정보 저장
     *
     * @param user 회원
     * @return DefaultRes
     */
    public void saveUser(final User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    /**
     * 회원 정보 인증
     *
     * @param signInReq 회원 데이터
     * @return DefaultRes
     */
    public String authUser(final SignInReq signInReq) {
        if (userRepository.findByStudentId(signInReq.getStudentId()).isPresent()) {
            User user = userRepository.findByStudentId(signInReq.getStudentId()).get();
            if (passwordEncoder.matches(signInReq.getPassword(), user.getPassword())) {
                return new JwtServiceImpl.TokenRes(jwtServiceImpl.create(user.getId())).getToken();
            } else return "";
        } else return "";
    }
}
