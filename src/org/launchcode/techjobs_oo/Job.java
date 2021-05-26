package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    private String resultString = "";

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
      return resultString;
    };

    public String toString(Job someJob) {
        String jobName;
        String jobEmployer;
        String jobLocation;
        String jobPositionType;
        String jobCoreCompetency;

        if (someJob.name == "") {
            jobName = "Data not available";
        } else {
            jobName = someJob.getName();
        }

        if (someJob.employer.getValue() == null) {
            jobEmployer = "Data not available";
        } else {
            jobEmployer = someJob.getEmployer().getValue();
        }

        if (someJob.location.getValue() == null) {
            jobLocation = "Data not available";
        } else {
            jobLocation = someJob.getLocation().getValue();
        }

        if (someJob.positionType.getValue() == null) {
            jobPositionType = "Data not available";
        } else {
            jobPositionType = someJob.getPositionType().getValue();
        }

        if (someJob.coreCompetency.getValue() == null) {
            jobCoreCompetency = "Data not available";
        } else {
            jobCoreCompetency = someJob.getCoreCompetency().getValue();
        }

        if (
                jobName == "Data not available" &&
                        jobEmployer == "Data not available" &&
                        jobLocation == "Data not available" &&
                        jobPositionType == "Data not available" &&
                        jobCoreCompetency == "Data not available"
        ) {
            return "OOPS! This job does not seem to exist.";
        }

        resultString = "\nJob: " + id +
                "\nName: " + jobName +
                "\nEmployer: " + jobEmployer +
                "\nLocation: " + jobLocation +
                "\nPosition Type: " + jobPositionType +
                "\nCore Competency: " + jobCoreCompetency +
                "\n";

        return "\nJob: " + id +
                "\nName: " + jobName +
                "\nEmployer: " + jobEmployer +
                "\nLocation: " + jobLocation +
                "\nPosition Type: " + jobPositionType +
                "\nCore Competency: " + jobCoreCompetency +
                "\n";
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
