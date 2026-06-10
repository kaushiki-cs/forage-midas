package com.jpmc.midascore;

import com.jpmc.midascore.entity.Balance;
import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.repository.UserRepository;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    private final UserRepository userRepository;

    public BalanceController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public Balance getBalance(@RequestParam("userId") Long userId) {

        UserRecord user = userRepository.findById(userId)
                .orElse(null);

        if (user == null) {
            return new Balance(null, 0.0);
        }

        return new Balance(
                user.getId(),
                (double) user.getBalance()
        );
    }
}
