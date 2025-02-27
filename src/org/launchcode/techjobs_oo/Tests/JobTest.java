package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import java.sql.SQLOutput;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class JobTest {

    //Declared variables
    Job firstJob;
    Job secondJob;
    Job thirdJob;
    Job emptyJob;
    Job partialJob;
    Job fullJob;
    Job secondFullJob;

    @Before
    public void createJobObject() {
        firstJob = new Job();
        secondJob = new Job();
        thirdJob = new Job();
        emptyJob = new Job(
                "",
                new Employer(),
                new Location(),
                new PositionType(),
                new CoreCompetency()
        );
        partialJob = new Job(
                "",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
        fullJob = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
        secondFullJob = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
    }

    @Test
    public void testSettingJobId() {
        assertFalse(firstJob.getId() == secondJob.getId());
        assertTrue(secondJob.getId() - firstJob.getId() == 1);
    }

    @Test
    public void testCorrectJobIdNum() {
        assertTrue(
                firstJob.getId() == 1 &&
                        secondJob.getId() == 2 &&
                        thirdJob.getId() == 3
        );
    }

    @Test
    public void testJobConstructorSetsAllFields() {
//        assertTrue(
//                fullJob.getEmployer() instanceof Employer &&
//                        fullJob.getLocation() instanceof Location &&
//                        fullJob.getPositionType() instanceof PositionType &&
//                        fullJob.getCoreCompetency() instanceof CoreCompetency
//        );
        assertTrue(
                fullJob.getName() == "Product tester" &&
                        fullJob.getEmployer().getValue() == "ACME" &&
                        fullJob.getLocation().getValue() == "Desert" &&
                        fullJob.getPositionType().getValue() == "Quality control" &&
                        fullJob.getCoreCompetency().getValue() == "Persistence"
        );
        //assertEquals("ACME", fullJob.getEmployer().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(
                fullJob.equals(secondFullJob)
        );
    }

    //Tests for toString Method
    @Test
    public void checkBlankLines() {
        String testJob = fullJob.toString();
        assertTrue(testJob.startsWith("\n") && testJob.endsWith("\n"));
    }

    @Test
    public void testCorrectJobFormat() {
        String testJob = partialJob.toString();
//        String[] resultArray = testJob.split("\n");
//        String testString = resultArray[1];
//        System.out.println(resultArray.length);
        System.out.println(testJob);
        String formatted = String.format("\nEmployer: %s\n", partialJob.getEmployer().getValue());
        assertEquals("\nJob: " + partialJob.getId() +
                "\nName: " + partialJob.getName() +
                "\nEmployer: " + partialJob.getEmployer().getValue() +
                "\nLocation: " + partialJob.getLocation().getValue() +
                "\nPosition Type: " + partialJob.getPositionType().getValue() +
                "\nCore Competency: " + partialJob.getCoreCompetency().getValue() +
                "\n", partialJob.toString());
    }

    @Test
    public void testPartiallyEmptyJob() {
        String testJob = partialJob.toString();
        String[] resultArray = testJob.split("\n");
        String testString = resultArray[2];
        System.out.println(testJob);
        assertEquals("\nJob: " + partialJob.getId() +
                "\nName: Data not available" +
                "\nEmployer: " + partialJob.getEmployer().getValue() +
                "\nLocation: " + partialJob.getLocation().getValue() +
                "\nPosition Type: " + partialJob.getPositionType().getValue() +
                "\nCore Competency: " + partialJob.getCoreCompetency().getValue() +
                "\n", partialJob.toString());
    }

    @Test
    public void testEmptyJob() {
        String testJob = emptyJob.toString();
        assertEquals("OOPS! This job does not seem to exist.", testJob);
    }
}
