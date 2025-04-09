package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
    @Test
    public void equals_case1(){
        assertTrue(team.equals(team), "the same object shoudl equal" );
    }
    @Test
    public void equals_case2(){
        String temp = "team";
        assertFalse(team.equals(temp), "Objects of differnt type cannot be equal");
    }
    @Test
    public void equals_case3_1(){
        Team temp;
	temp = new Team("test-team");
	assertTrue(team.equals(temp), "same name and same members should be equal");
    }

    @Test
    public void equals_case3_2(){
        Team temp;
	temp = new Team("test-team");
	temp.addMember("spy");
	assertFalse(team.equals(temp), "same name and different members should be false");
    }

    @Test
    public void equals_case3_3(){
        Team temp;
	temp = new Team("wrong-team");
	assertFalse(team.equals(temp), "Different name and same members should not be equal");
    }

    @Test
    public void equals_case3_4(){
        Team temp;
	temp = new Team("wrong-team");
	temp.addMember("spy");
	assertFalse(team.equals(temp), "wrong name and wrong members should not be equal");
    }

    @Test
    public void hashCode_check(){
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }



}
