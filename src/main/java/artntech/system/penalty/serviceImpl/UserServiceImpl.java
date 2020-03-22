package artntech.system.penalty.serviceImpl;

import artntech.system.penalty.domain.User;

import artntech.system.penalty.dto.SignInReq;
import artntech.system.penalty.enums.UserType;
import artntech.system.penalty.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    /**
     * 회원 전체 조회
     *
     * @return DefaultRes
     */
    public List<User> findAllUsers() {
        List<User> userList = userRepository.findAll();
        userList.stream().forEach(u->u.setPassword(""));
        return userList;
    }

    /**
     * 회원별 정보 조회
     *
     * @return DefaultRes
     */
    public User findUserById(final int id) {
        return userRepository.findById(id).get();
    }

    /**
     * 회원별 정보 조회
     *
     * @return DefaultRes
     */
    public UserType findUserTypeById(final int id) {
        return userRepository.findById(id).get().getUserType();
    }

    public int authorization(final String jwt) {

        final int userIdx = jwtServiceImpl.decode(jwt).getUser_idx();
        if (userIdx == -1) return -1;

        final Optional<User > user = userRepository.findById(userIdx);
        if (!user.isPresent()) return -1;

        return userIdx;

    }
}
