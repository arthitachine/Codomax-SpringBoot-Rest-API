package com.codomax.api.service;

import com.codomax.api.exception.ResourceNotFoundException;
import com.codomax.api.model.User;
import com.codomax.api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user) {
        user.setId(null);
        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public User updateUser(Long id, User updatedDetails) {
        User existing = getUserById(id);
        existing.setName(updatedDetails.getName());
        existing.setEmail(updatedDetails.getEmail());
        existing.setRole(updatedDetails.getRole());
        return repository.save(existing);
    }

    public void deleteUser(Long id) {
        if (!repository.deleteById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
    }
}
