# Assignment 2 - Continuous Integration
The purpose of this project is to implement a CI server for the course DD2480.

# Webserver
The server is hosted on [Hetzner](https://www.hetzner.com/) and can be accessed on http://37.27.20.70:8007/. 

The server lists all commits in the format `commit-{date and time}-{commit sha}`. Clicking on any of the commits, will display the test and build outputs in `test.log` and `build.log`, respectively.

## Browsable documentation
All documentation has been generated and placed in the doc folder. Alternatively, our server also has an endpoint to browse the documentation at http://37.27.20.70:8007/docs/

## How to build, run and, test
This assignment has been done using rust, and therefore requires the rust toolchain. It can be compiled with:

```
cargo build
```

and then ran with:

```
cargo run
```

Finally, tests can be run using the command:

```
cargo test
```

In order for the project to work properly as a CI server, a .env file has to be created in the assignment2 folder. This file should contain:
```
GITHUB_TOKEN={your token}
```
You also need to setup the webhooks in your GIT-repository properly.

## P1 How compilation has been implemented
Compilation has been implemented using the Command struct, which runs 
```
cargo build --message-fmt json
```


The compilation has been unit-tested as part of the tests in the "tests" module in the "ci.rs" file.

For more details see the source code.

## P2 How test execution has been implemented
Test execution has been implemented using the Command struct, which runs
```
cargo test --verbose
```

The test execution has been unit-tested as part of the tests in the "tests" module in the "ci.rs" file.

For more details see the source code.

## P3 How notification has been implemented
Notification has been implemented by setting the commit status of the repository as either "failing" or "success" for each commit. It is not currently unit tested but is instead testing manually with integration tests.

For more details see the source code.


## Statement of contributions
For more details, go to issues and sort by assignee.

### Marcus Alström
* Setup testing and logging of incoming push on CI server
* Setup the base for sending commit status to GitHub

### Oliver Lindgren
* Did not contribute

### Marcus Nilszén
* Setup webserver
* hetzner server
* Parse webhook data
* Frontend

### Noak Jönsson
* Ci Build method, unittests and functionality
* Refactoring of github.send_commit_status method
* Refactoring of github_webhook relating to CI process

### Leo Bosch
* integration test of git2 for git manipulation

## Our team (Essence standard)
We would classify our team as being in the state "formed". This is a regression from how we would classify how our team was performing at the end of assignment 1 which could be classified as "Collaborating". The reason for this regression is that the team has not been working as one cohesive unit for assignment 2, and communication has been poor as opposed to open and honest.

Note: this is a classification of the team as a whole, there are certain individual group members who have been performing very well, and who do not deserve blame for this regression.
