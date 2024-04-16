package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    /**
     * Конструктор сервиса.
     *
     * @param roleRepository Репозиторий для работы с ролями.
     */
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * Получает все роли.
     *
     * @return Множество ролей.
     */
    @Override
    public Set<Role> getRoles() {
        return new HashSet<>(roleRepository.findAll());
    }

    /**
     * Находит роль по ее идентификатору.
     *
     * @param id Идентификатор роли.
     * @return Объект Role, представляющий роль.
     */
    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    /**
     * Находит роль по ее строковому идентификатору.
     *
     * @param sid Строковый идентификатор роли.
     * @return Объект Role, представляющий роль.
     */
    @Override
    public Role findByStringId(String sid) {
        Long LongId = Long.parseLong(sid);
        return roleRepository.findById(LongId).orElse(null);
    }


    @Override
    @Transactional
    public void saveRole(Role role) {
        roleRepository.save(role);
    }
}