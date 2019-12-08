package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class StoreTest {

    @Test
    @SuppressWarnings("unchecked")
    public void whenCreateRoleStoreAndFindIndexById() {
        RoleStore rs = new RoleStore(10);
        Base one = new Role("Moscow");
        Base two = new Role("London");

        rs.add(one);
        rs.add(two);
        int result = rs.findIndexById("London");
        assertThat(result, is(1));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void whenCreateRoleStoreAndFindById() {
        RoleStore rs = new RoleStore(10);
        Base one = new Role("Moscow");
        Base two = new Role("London");

        rs.add(one);
        rs.add(two);
        Base result = rs.findById("London");
        assertThat(result, is(two));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void whenCreateRoleStoreAndDeleteLastElement() {
        RoleStore rs = new RoleStore(10);
        Base one = new Role("001");
        Base two = new Role("002");
        Base three = new Role("3");

        rs.add(one);
        rs.add(two);
        rs.add(three);
        assertThat(rs.delete("3"), is(true));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void whenCreateRoleStoreAndReplaceLastElement() {
        RoleStore rs = new RoleStore(10);
        Base one = new Role("001");
        Base two = new Role("2");
        Base base = new Role("002");

        rs.add(one);
        rs.add(two);
        assertThat(rs.replace("2", base), is(true));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void whenCreateUserStoreAndFindIndexById() {
        UserStore us = new UserStore(10);
        Base one = new User("Ivanov");
        Base two = new User("Petrov");

        us.add(one);
        us.add(two);
        int result = us.findIndexById("Petrov");
        assertThat(result, is(1));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void whenCreateUserStoreAndFindById() {
        UserStore us = new UserStore(10);
        Base one = new User("Ivanov");
        Base two = new User("Petrov");

        us.add(one);
        us.add(two);
        Base result = us.findById("Petrov");
        assertThat(result, is(two));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void whenCreateUserStoreAndDeleteLastElement() {
        UserStore us = new UserStore(10);
        Base one = new User("001");
        Base two = new User("002");
        Base three = new User("3");

        us.add(one);
        us.add(two);
        us.add(three);
        assertThat(us.delete("3"), is(true));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void whenCreateUserStoreAndReplaceLastElement() {
        UserStore us = new UserStore(10);
        Base one = new User("001");
        Base two = new User("2");
        Base base = new User("002");

        us.add(one);
        us.add(two);
        assertThat(us.replace("2", base), is(true));
    }
}