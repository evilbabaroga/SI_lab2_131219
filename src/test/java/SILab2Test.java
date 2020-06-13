import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    SILab2 siLab2 = new SILab2();

    @Test
    void multiple_condition_test() {
        assertThrows(RuntimeException.class, () ->
                siLab2.function(null, null));
        assertThrows(RuntimeException.class, () ->
                siLab2.function(new User(null, null, null), null));
        final ArrayList<String> allUsers = new ArrayList<String>();
        allUsers.add("aaa");
        assertThrows(RuntimeException.class, () ->
                siLab2.function(new User("aaa", null, null), allUsers));
        final ArrayList<String> allUsers2 = new ArrayList<String>();
        assertFalse(siLab2.function(new User("aaa", null, null), allUsers2));
        assertFalse(siLab2.function(new User("aaa", null, "@"), allUsers2));
        assertTrue(siLab2.function(new User("aaa", null, "@."), allUsers2));
    }

    @Test
    void every_branch_test(){

    }
}