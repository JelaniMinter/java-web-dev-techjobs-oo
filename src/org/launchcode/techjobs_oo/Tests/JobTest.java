package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JobTest {

    Job firstJob;
    Job secondJob;
    Job thirdJob;
    Job fullJob;
    Job secondFullJob;

    @Before
    public void createJobObject() {
        firstJob = new Job();
        secondJob = new Job();
        thirdJob = new Job();
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
        assertTrue(
                fullJob.getEmployer() instanceof Employer &&
                        fullJob.getLocation() instanceof Location &&
                        fullJob.getPositionType() instanceof PositionType &&
                        fullJob.getCoreCompetency() instanceof CoreCompetency
        );
        assertTrue(
                fullJob.getEmployer().getValue() == "ACME" &&
                        fullJob.getLocation().getValue() == "Desert" &&
                        fullJob.getPositionType().getValue() == "Quality control" &&
                        fullJob.getCoreCompetency().getValue() == "Persistence"
        );
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(
                fullJob.equals(secondFullJob) == true
        );

    }
}
